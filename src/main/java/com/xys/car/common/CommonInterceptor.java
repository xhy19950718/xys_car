package com.xys.car.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommonInterceptor implements HandlerInterceptor {
    /**
     * preHandle在执行Controller之前执行，返回true，则继续执行Contorller
     * 返回false则请求中断。
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        //只有返回true才会继续向下执行，返回false取消当前请求
        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("startTime", startTime);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        return true;
    }

    /**
     * postHandle是在请求执行完，但渲染ModelAndView返回之前执行
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        long startTime = (Long) httpServletRequest.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        StringBuilder sb = new StringBuilder(1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        sb.append("-----------------------").append(date).append("-------------------------------------\n");
        sb.append("URI    : ").append(httpServletRequest.getRequestURI()).append("\n");
        sb.append("CostTime : ").append(executeTime).append("ms").append("\n");
        sb.append("-------------------------------------------------------------------------------");
        System.out.println(sb.toString());
    }

    /**
     * afterCompletion是在整个请求执行完毕后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
