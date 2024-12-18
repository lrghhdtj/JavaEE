package com.example.demo.Filter;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.Utils.Jwtutils;
import com.example.demo.Utils.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@Component
@Slf4j
@WebFilter(filterName = "checklogin", urlPatterns = "/*")
public class LoginCheck implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI().toString();

        if (url.contains("/login")||url.contains("/register")){
            chain.doFilter(request,response);
            return;
        }
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            System.out.println("Options");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        String jwt = request.getHeader("Authorization");
        System.out.println("jwt:"+jwt);
        if (!StringUtils.hasLength(jwt)){
            Result error = Result.error("NoLogin!");
            String nologin = JSONObject.toJSONString(error);
            response.getWriter().write(nologin);
            return;
        }
        try {
            Jwtutils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败！");
            Result error = Result.error("NoLogin!");
            String nologin = JSONObject.toJSONString(error);
            response.getWriter().write(nologin);
            return;
        }
        log.info("令牌合法");
        chain.doFilter(request,response);

    }
}
