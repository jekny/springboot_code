package com.example.kaoshi.interceptor;

import com.example.kaoshi.utils.JwtUtil;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginInterceptor
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:33
 * @Version 1.0
 */
@Component//提交给bean容器管理
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = null;
        //获取token并进行校验
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("token")){
                    token = cookie.getValue();//获取到用户请求中的token
                }
            }
        }
        if (token == null) {//没有权限
            response.sendRedirect("toLogin");//重定向到登录页面
            return false;//表示token校验不通过，请求被拦截
        }else {//不为空还要校验一次
            if (!JwtUtil.verifyToken(token)){//存在但校验不通过//过期
                response.sendRedirect("toLogin");
                return false;
            }else{
                return true;
            }

        }


    }
}
