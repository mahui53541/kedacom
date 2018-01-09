# Spring Security+JWT 实现服务器端去Session
Spring Security+JWT 相关配置在security模块下，相关SpringSecurity配置请参照分支V1.0

## 什么是JWT？

如需了解详情，出门自行百度，不在本文讨论范围。

## 添加依赖
在pom.xml中添加如下配置，引入对JWT的依赖，这里引入一个比较成熟的JWT类库jjwt。
```
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.0</version>
</dependency>
```

## JWT的生成和解析

```
//JWT生成
Jwts.builder()
        .setClaims(claims)
        .setExpiration(generateExpirationDate())
        .signWith(SignatureAlgorithm.HS512, secret) //采用什么算法是可以自己选择
        .compact();
        
//解析JWT
Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();
```

## 定制自己的UserDetails
新建JwtUser类实现UserDetails接口和接口中的方法
```java
public class JwtUser implements UserDetails {

    private final Long id;

    //用户昵称，不唯一，登录时使用phone
    private final String nickname;

    //登录时使用
    private final String phone;

    private final String email;

    private final String password;

    private final Date regTime;

    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id, String nickname, String phone, String email, String password, Date regTime, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.regTime = regTime;
        this.authorities = authorities;
    }

    //分配给用户的权限
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public Date getRegTime() {
        return regTime;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

```
## 修改原来的UserDetailService实现类

重命名类UserDetailServiceImpl为JwtUserDetailsServiceImpl，实现loadUserByUsername方法
```java
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtUserFactory jwtUserFactory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByPhone(username);
        if(user==null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        else
            return jwtUserFactory.create(user);
    }
}

```
## 集成JWT和Spring Security

新建JwtAuthenticationTokenFilter类
```java
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            String username = jwtTokenUtil.getUsernameFromToken(authToken);

            logger.info("checking authentication " + username);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
```
- doFilterInternal方法过滤所有请求，获取请求中的token，并验证token的有效性，
事实上如果我们足够相信token中的数据，也就是我们足够相信签名token的secret的机制足够好，这种情况下，我们可以不用再查询数据库，而直接采用token中的数据。
本例中，我们还是通过Spring Security的 @UserDetailsService 进行了数据查询，
但简单验证的话，你可以采用直接验证token是否合法来避免昂贵的数据查询。

## Spring Security配置

修改Spring Security配置类WebSecurityConfig.java

```java
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义UserDetailsService实现
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    //过滤器
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    //加密方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 设置UserDetailsService
                .userDetailsService(userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 添加JWT filter
                .addFilterBefore(authenticationTokenFilterBean(),UsernamePasswordAuthenticationFilter.class)
                //用于处理用户无权
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                //由于使用的是JWT，不需要csrf,禁用
                .csrf().disable()
                //基于token，禁用Session
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                //允许对静态资源和部分url访问
                .authorizeRequests()
                    .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**").permitAll()
                    .antMatchers("/").permitAll()//首页
                    .antMatchers("/goods/**").permitAll()//商品浏览
                    .antMatchers(HttpMethod.GET,"/login").permitAll()//登录页面
                    .antMatchers(HttpMethod.GET,"/register").permitAll()//注册页面
                    .antMatchers("/auth/**").permitAll()//登陆注册
                    .antMatchers(HttpMethod.GET,"/cart").permitAll()//购物车页面
                    .antMatchers(HttpMethod.GET,"/orders").permitAll()//购物车页面
                    .antMatchers(HttpMethod.GET,"/orders/detail").permitAll()//购物车页面
                    .anyRequest().authenticated()
                    .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/")
//                    .permitAll()
//                    .and()
                //禁用缓存
                .headers()
                    .cacheControl();


    }
}
```
* 注入自定义的UserDetailService
* 加入定义的过滤器JwtAuthenticationTokenFilter
* 删除form表单配置，这里使用Ajax进行登录
* 禁用Session
* 自定义无权访问时的处理类JwtAuthenticationEntryPoint

## 加入登录和注册方法
```java
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    /**
     * 用户登陆
     * @param authenticationRequest
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMessageVO createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException, IOException {
        final HashMap<String,Object> data = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ReturnMessageVO.success("成功登陆",data);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    public ReturnMessageVO doRegister(@RequestBody User user){
        return userService.register(user);
    }
}
```
