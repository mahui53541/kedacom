# 整合Spring Security
Spring Security相关配置在security模块下

## 添加依赖
在pom.xml中添加如下配置，引入对Spring Security的依赖。
```
<dependencies>
    ...
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    ...
</dependencies>
```
## 自定义UserDetailService实现类

创建类UserDetailService.java，实现loadUserByUsername方法
```java
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByPhone(username);
        if(user==null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        List<SysRole> roles=sysRoleDao.findByUserId(user.getId());
        //List<SysPermission> permissions = sysPermissionDao.findByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (SysRole role : roles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), grantedAuthorities);
    }
}

```
## Spring Security配置

创建Spring Security配置类SecurityConfig.java

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImpl();
    };

    @Bean
    public PasswordEncoder passwordEncoder(){//加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/goods/**").permitAll()
                    .antMatchers("/user/register").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                //允许 ajax 跨域（不安全）
                .csrf().disable();
    }
}
```
* 通过@EnableWebMvcSecurity注解开启Spring Security的功能
* 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
* 注入自定义的UserDetailService
* 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。



