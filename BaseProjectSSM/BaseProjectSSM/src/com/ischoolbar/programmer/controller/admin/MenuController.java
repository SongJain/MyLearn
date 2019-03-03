package com.ischoolbar.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 菜单管理控制器
 * @author: SongJian
 * @create: 2019-02-24 18:41
 *
 * 只有被Controller注解的类才会被扫描
 **/
@RequestMapping("/admin/menu")
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /** 
    * @Description: 菜单管理列表页面
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.addObject("topList",menuService.findTopList());
        modelAndView.setViewName("menu/list");
        return modelAndView;
    }

    /** 
    * @Description: 获取菜单列表 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getMenuList(Page page,
            @RequestParam(name="name",required = false,defaultValue = "") String name){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset",page.getOffset());
        queryMap.put("pageSize",page.getRows());
        queryMap.put("name",name);
        List<Menu> list = menuService.findList(queryMap);
        map.put("rows",list);
        map.put("total",menuService.getTotal(queryMap));
        return map;
    }

    /** 
    * @Description:  获取指定目录下的系统icon集合
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/get_icons",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getIconList(HttpServletRequest httpServletRequest){
        Map<String,Object> map = new HashMap<String, Object>();
        String realPath = httpServletRequest.getServletContext().getRealPath("/");
        File file = new File(realPath + "\\resource\\admin\\easyui\\css\\icons");
        List<String> icons = new ArrayList<String>();
        if(!file.exists()){
            map.put("type","error");
            map.put("message","文件目录不存在！");
            return map;
        }
        File[] files = file.listFiles();
        for(File f:files){
            if(f != null && f.getName().contains("png")){
                icons.add("icon-" + f.getName().substring(0,f.getName().indexOf(".")).replace("_","-"));
            }
            System.out.println(f.getName());
        }
        map.put("type","success");
        map.put("content",icons);
        return map;
    }
    /** 
    * @Description:  菜单添加
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Menu menu){
        Map<String,String> map = new HashMap<String, String>();
        if(menu == null){
            map.put("type","error");
            map.put("message","请填写正确的菜单信息！");
            return map;
        }
        if(StringUtil.isEmpty(menu.getName())){
            map.put("type","error");
            map.put("message","请填写菜单名称！");
            return map;
        }
        if(StringUtil.isEmpty(menu.getIcon())){
            map.put("type","error");
            map.put("message","请填写菜单图标类！");
            return map;
        }
        if(menu.getParentId() == null){
            menu.setParentId(0l);
        }
        if(menuService.add(menu) <= 0){
            map.put("type","error");
            map.put("message","添加失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","添加成功！");
        return map;
    }

    /**
     * @Description:  菜单修改
     * @Param:
     * @return:
     * @Author: SongJian
     * @Date:
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(Menu menu){
        Map<String,String> map = new HashMap<String, String>();
        if(menu == null){
            map.put("type","error");
            map.put("message","请选择正确的菜单信息！");
            return map;
        }
        if(StringUtil.isEmpty(menu.getName())){
            map.put("type","error");
            map.put("message","请填写菜单名称！");
            return map;
        }
        if(StringUtil.isEmpty(menu.getIcon())){
            map.put("type","error");
            map.put("message","请选择菜单图标类！");
            return map;
        }
        if(menu.getParentId() == null){
            menu.setParentId(0l);
        }
        if(menuService.edit(menu) <= 0){
            map.put("type","error");
            map.put("message","修改失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","修改成功！");
        return map;
    }

    /** 
    * @Description: 删除菜单信息 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> delete(
            @RequestParam(name="id",required = true) Long id
    ){
        Map<String,String> map = new HashMap<String, String>();
        if(id == null){
            map.put("type","error");
            map.put("message","请选择要删除的菜单信息！");
            return map;
        }
        List<Menu> childernList = menuService.findChildernList(id);
        if(childernList != null && childernList.size() > 0){
            //表示分类下存在子分类，不能删除
            map.put("type","error");
            map.put("message","分类下存在子分类，不能删除！");
            return map;
        }
        if(menuService.delete(id) <=0 ){
            map.put("type","error");
            map.put("message","删除失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","删除成功！");
        return map;
    }
}
