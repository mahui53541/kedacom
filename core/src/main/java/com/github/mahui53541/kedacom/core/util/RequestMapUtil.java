package com.github.mahui53541.kedacom.core.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 10:20
 * @version:1.0.0
 */
public class RequestMapUtil {
    /**
     * 获取请求参数
     */
    public static Map<String, Object> getParamsMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<?> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String key = params.nextElement().toString();
            map.put(key, request.getParameter(key));
        }
        return map;
    }
}
