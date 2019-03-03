package com.ischoolbar.programmer.interceptor.admin;

import com.google.gson.JsonObject;
import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.util.MenuUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-02-23 20:00
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        Object admin = httpServletRequest.getSession().getAttribute("admin");
        if(admin == null){
            //表示未登录或者登录失效
            System.out.println(requestURI + "进入拦截器");
            String header = httpServletRequest.getHeader("X-Requested-With");
            //判断是否是ajax请求
            if("XMLHttpRequest".equals(header)){
                //表示是ajax请求
                Map<String,String> map = new HashMap<String,String>();
                map.put("type","error");
                map.put("message","登录会话超时或未登录，请重新登录");
                httpServletResponse.getWriter().write(JSONObject.fromObject(map).toString());
                return false;
            }
            //表示是普通链接跳转，直接重定向到登陆页面
            httpServletResponse.sendRedirect(httpServletRequest.getServletContext().getContextPath() + "/system/login");
            return false;
        }
        String mid = httpServletRequest.getParameter("_mid");
        if(!StringUtils.isEmpty(mid)){
            List<Menu> allThirdMenu =  MenuUtil.getAllThirdMenu((List<Menu>)httpServletRequest.getSession().getAttribute("userMenus"),Long.valueOf(mid));
            httpServletRequest.setAttribute("thirdMenuList",allThirdMenu);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
