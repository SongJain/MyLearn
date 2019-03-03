package com.ischoolbar.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.entity.admin.Role;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.AuthorityService;
import com.ischoolbar.programmer.service.admin.MenuService;
import com.ischoolbar.programmer.service.admin.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-02-26 20:26
 **/
@RequestMapping("/admin/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    MenuService menuService;

    /**
    * @Description: 角色列表页面
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/role/list");
        return modelAndView;
    }

    /**
    * @Description: 获取角色列表
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(Page page,
                 @RequestParam(name="name",required = true,defaultValue = "")String name
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> querymap = new HashMap<String, Object>();
        querymap.put("name",name);
        querymap.put("offset",page.getOffset());
        querymap.put("pageSize",page.getRows());
        map.put("rows",roleService.findList(querymap));
        map.put("total",roleService.getTotal(querymap));
        return map;
    }

    /** 
    * @Description:  用户添加
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map<String,Object> add(Role role){
        Map<String,Object> map = new HashMap<String, Object>();
        if(role == null){
            map.put("type","error");
            map.put("message","请填写正确角色信息!");
            return map;
        }
        if(StringUtil.isEmpty(role.getName())) {
            map.put("type", "error");
            map.put("message", "请填写正确角色名称!");
            return map;
        }
        if(roleService.add(role) <= 0){
            map.put("type","error");
            map.put("message","添加失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","添加成功！");
        return map;
    }

    /**
     * @Description:  用户修改
     * @Param:
     * @return:
     * @Author: SongJian
     * @Date:
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Map<String,Object> edit(Role role){
        Map<String,Object> map = new HashMap<String, Object>();
        if(role == null){
            map.put("type","error");
            map.put("message","请填写正确角色信息！");
            return map;
        }
        if(StringUtil.isEmpty(role.getName())){
            map.put("type","error");
            map.put("message","请填写正确角色名称！");
            return map;
        }
        if(roleService.edit(role) <= 0){
            map.put("type","error");
            map.put("message","添加失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","修改成功！");
        return map;
    }

    /**
     * @Description:  用户删除
     * @Param:
     * @return:
     * @Author: SongJian
     * @Date:
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> delete(Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        if(id == null){
            map.put("type","error");
            map.put("message","请选择删除角色！");
            return map;
        }
        try {
            if(roleService.delete(id) <= 0){
                map.put("type","error");
                map.put("message","删除失败，请联系管理员！");
                return map;
            }
        }catch (Exception e){
            map.put("type","error");
            map.put("message","该角色下存在权限，不能删除！");
            return map;
        }
        map.put("type","success");
        map.put("message","删除成功！");
        return map;
    }

    /** 
    * @Description: 获取所有的菜单信息 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value="/get_all_menu",method=RequestMethod.POST)
    @ResponseBody
    public List<Menu> getAllMenu(){
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 99999);
        return menuService.findList(queryMap);
    }

    /**
    * @Description: 添加权限
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value="/add_authority",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addAuthority(
            @RequestParam(name="ids",required=true) String ids,
            @RequestParam(name="roleId",required=true) Long roleId
    ){
        Map<String,String> ret = new HashMap<String, String>();
        if(StringUtils.isEmpty(ids)){
            ret.put("type", "error");
            ret.put("msg", "请选择相应的权限！");
            return ret;
        }
        if(roleId == null){
            ret.put("type", "error");
            ret.put("msg", "请选择相应的角色！");
            return ret;
        }
        if(ids.contains(",")){
            ids = ids.substring(0,ids.length()-1);
        }
        String[] idArr = ids.split(",");
        if(idArr.length > 0){
            authorityService.deleteByRoleId(roleId);
        }
        for(String id:idArr){
            Authority authority = new Authority();
            authority.setMenuId(Long.valueOf(id));
            authority.setRoleId(roleId);
            authorityService.add(authority);
        }
        ret.put("type", "success");
        ret.put("msg", "权限编辑成功！");
        return ret;
    }

    /** 
    * @Description: 获得某个role的权限 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value="/get_role_authority",method=RequestMethod.POST)
    @ResponseBody
    public List<Authority> getRoleAuthority(
            @RequestParam(name="roleId",required=true) Long roleId
    ){
        return authorityService.findListByRoleId(roleId);
    }
}
