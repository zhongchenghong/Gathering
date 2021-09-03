package com.museum.common.shiro;

import com.alibaba.fastjson.JSON;
import com.museum.common.ResultUtil;
import com.museum.util.HttpContextUtil;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class JWTFilter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String token=request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        return new JWTToken(token);
    }



    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String token=request.getHeader("token");
        String servletPath = request.getServletPath();

        if(token!=null&&!"".equals(token)||"/account/login".equals(servletPath)
        ||"/swagger-ui.html".equals(servletPath)||"/account/codelogin".equals(servletPath)
        ||"/account/sendpassword".equals(servletPath)
        ) {

            if(token!=null&&!"".equals(token)){
                String name=JWTUtil.getUsername(token);
                if(name==null||"".equals(name)){
                    return false;
                }
            }

            return true;
        }else {

            return false;

        }
    }


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        return super.preHandle(request, response);
    }

    /**
     * 将非法请求跳转到 /unauthorized/**
     */
    private void responseError(ServletResponse response, String message) {

        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
