
package com.github.zhiduoming.interceptor;

import com.github.zhiduoming.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            responseNotLogin(response);
            return false;
        }

        String token = authorization.substring(7);

        try {
            JwtUtils.parseToken(token);
            return true;
        } catch (Exception e) {
            responseNotLogin(response);
            return false;
        }
    }

    private void responseNotLogin(HttpServletResponse response) throws Exception {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\":0,\"msg\":\"NOT_LOGIN\",\"data\":null}");
    }
}
