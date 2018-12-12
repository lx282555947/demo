package com.lixin.interceptor;

import com.alibaba.fastjson.JSON;
import com.lixin.annotation.LoginRequired;
import com.lixin.token.TokenUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 使用拦截器先向拦截器注册中心注册并且配置拦截路径
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler 一般为HandlerMethod
     * @return 通过为true，不通过为false
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取拦截路径的实体类   此处为controller
            Class<?> beanType = handlerMethod.getBeanType();
            System.out.println("beanType:" + JSON.toJSONString(beanType));
            Method method = handlerMethod.getMethod();
            System.out.println("method:" + JSON.toJSONString(method));
            //判断该方法上是否有注解
            boolean hasMethodAnnotation = handlerMethod.hasMethodAnnotation(LoginRequired.class);
            if (hasMethodAnnotation) {
                //获取LoginRequired注解
                LoginRequired loginRequiredAnnotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
                System.out.println("loginRequiredAnnotation:" + JSON.toJSONString(loginRequiredAnnotation));
                //从header中取出token
                String token = request.getHeader("token");
                String customerId = request.getHeader("customerId");
                System.out.println("token:" + token);
                //验证token
                boolean isAccess = TokenUtils.verifyToken(token, customerId);
                return isAccess;
            }
            //获取方法参数
            Parameter[] parameters = method.getParameters();
            System.out.println("methodParameters:"+JSON.toJSONString(parameters));
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
