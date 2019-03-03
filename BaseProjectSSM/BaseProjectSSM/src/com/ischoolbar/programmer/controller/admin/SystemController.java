package com.ischoolbar.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.*;
import com.ischoolbar.programmer.service.admin.*;
import com.ischoolbar.programmer.util.CpachaUtil;
import com.ischoolbar.programmer.util.LogUtil;
import com.ischoolbar.programmer.util.MenuUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LogService logService;

    /**
    * @Description: 系统登入后的主页
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("system/index");
        List<Menu> userMenus = (List<Menu>) httpServletRequest.getSession().getAttribute("userMenus");
        modelAndView.addObject("topMenuList", MenuUtil.getAllTopMenu(userMenus));
        modelAndView.addObject("secondMenuList", MenuUtil.getAllSecondMenu(userMenus));
        return modelAndView;
    }
    /** 
    * @Description: 系统登入后的欢迎页面
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView){
        modelAndView.setViewName("system/welcome");
        return modelAndView;
    }

    /**
    * @Description: 登录
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("system/login");
        return modelAndView;
    }

    /**
    * @Description: 登陆表单提交处理控制器
    * @Param:  @ResponseBody 指定返回对象为json类型
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> loginAct(User user,String cpacha,HttpServletRequest httpServletRequest){
        Map<String,String> map = new HashMap<String,String>();
        if(user == null){
            map.put("type","error");
            map.put("message","请填写用户信息！");
            return map;
        }
        if(StringUtil.isEmpty(cpacha)){
            map.put("type","error");
            map.put("message","请填写验证码！");
            return map;
        }
        if(StringUtil.isEmpty(user.getUsername())){
            map.put("type","error");
            map.put("message","请填写用户名！");
            return map;
        }
        if(StringUtil.isEmpty(user.getPassword())){
            map.put("type","error");
            map.put("message","请填写密码！");
            return map;
        }

        Object loginCpacha = httpServletRequest.getSession().getAttribute("loginCpacha");
        if(loginCpacha == null){
            map.put("type","error");
            map.put("message","会话超时,已刷新页面！");
            logService.add("【" +user.getUsername()+ "】" + " 用户会话超时");
            return map;
        }
        if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
            map.put("type","error");
            map.put("message","验证码错误！");
            logService.add("【" +user.getUsername()+ "】" + " 用户登入时验证码输入错误");
            return map;
        }

        User findByUsername = userService.findByUsername(user.getUsername());

        if(findByUsername == null){
            map.put("type","error");
            map.put("message","用户名不存在！");
            return map;
        }
        if(!user.getPassword().equals(findByUsername.getPassword())){
            map.put("type","error");
            map.put("message","密码错误！");
            logService.add("【" +user.getUsername()+ "】" + " 用户登入时密码输入错误");
            return map;
        }
        //说明用户名密码及验证码都正确
        //此时需要查询用户的角色权限
        Role role = roleService.find(findByUsername.getRoleId());
        List<Authority> authorityList = authorityService.findListByRoleId(role.getId());//根据角色获取权限列表
        String menuIds = "";
        for(Authority authority:authorityList){
            menuIds += authority.getMenuId() + ",";
        }
        if(!StringUtils.isEmpty(menuIds)){
            menuIds = menuIds.substring(0,menuIds.length()-1);
        }
        List<Menu> userMenus = menuService.findListByIds(menuIds);
        //把角色信息、菜单信息放到session中
        httpServletRequest.getSession().setAttribute("admin", findByUsername);
        httpServletRequest.getSession().setAttribute("role", role);
        httpServletRequest.getSession().setAttribute("userMenus", userMenus);
        map.put("type", "success");
        map.put("msg", "登录成功！");
        logService.add("【"+role.getName()+"】"+"【" +user.getUsername()+ "】" + " 用户登入成功");
        return map;
    }

    /**
    * @Description:
    * @Param:  后台退出注销功能
    * @return:
    * @Author: SongJian
    * @Date:
    */

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        User user = (User) session.getAttribute("admin");
        logService.add("【"+role.getName()+"】"+"【" +user.getUsername()+ "】" + " 用户退出");
        session.setAttribute("admin",null);
        session.setAttribute("role",null);
        session.setAttribute("userMenus",null);
        return "redirect:login";
    }


    /** 
    * @Description: 修改密码界面
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/edit_password",method = RequestMethod.GET)
    public ModelAndView editPassword(ModelAndView modelAndView){
        modelAndView.setViewName("system/edit_password");
        return modelAndView;
    }

    @RequestMapping(value = "/edit_password",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> editPasswordAct(String newpassword,String oldpassword,HttpServletRequest httpServletRequest) {
        Map<String, String> map = new HashMap<String, String>();
        User user = (User)httpServletRequest.getSession().getAttribute("admin");
        Role role = (Role)httpServletRequest.getSession().getAttribute("role");
        if (StringUtils.isEmpty(newpassword)) {
            map.put("type", "error");
            map.put("message", "请填写新密码！");
            return map;
        }
        if(!user.getPassword().equals(oldpassword)){
            map.put("type", "error");
            map.put("message", "原密码错误！");
            return map;
        }
        user.setPassword(newpassword);
        if(userService.editPassword(user) <= 0){
            map.put("type", "error");
            map.put("message", "修改失败，请联系管理员！");
            return map;
        }
        map.put("type", "success");
        map.put("message", "密码修改成功！");
        logService.add("【" +role.getName()+ "】" + "【" +user.getUsername()+ "】" +" 用户修改密码成功");
        return map;
    }

    /**
    * @Description: 本系统所有的验证码都采用此方法
    * @Param:  @param cpachaType 用来区别验证码的类型，传入字符串
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/get_cpacha",method = RequestMethod.GET)
    public void generateCpacha(
            @RequestParam(name = "vl",required = false,defaultValue = "4") Integer vcodeLen,
            @RequestParam(name = "w",required = false,defaultValue = "110") Integer width,
            @RequestParam(name = "h",required = false,defaultValue = "30") Integer height,
            @RequestParam(name = "type",required = true,defaultValue = "loginCpacha") String cpachaType,
            HttpServletRequest request,
            HttpServletResponse response){

        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen,width,height);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute(cpachaType,generatorVCode);
        BufferedImage generatorVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode,true);
        try {
            ImageIO.write(generatorVCodeImage, "gif", response.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
