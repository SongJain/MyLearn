package com.ischoolbar.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.User;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.RoleService;
import com.ischoolbar.programmer.service.admin.UserService;
import org.apache.commons.lang.StringUtils;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * @program: BaseProjectSSM
 * @description 用户管理控制器
 * @author: SongJian
 * @create: 2019-02-28 22:41
 **/

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    /** 
    * @Description: 用户列表页面
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        Map<String,Object> queryMap = new HashMap<String, Object>();
        modelAndView.addObject("roleList",roleService.findList(queryMap));
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    /** 
    * @Description: 获取用户列表 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(Page page,
                                      @RequestParam(name="username",required = false,defaultValue = "") String username,
                                      @RequestParam(name="roleId",required = false) Long roleId,
                                      @RequestParam(name="sex",required = false) Integer sex
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> querymap = new HashMap<String, Object>();
        querymap.put("name",username);
        querymap.put("roleId",roleId);
        querymap.put("sex",sex);
        querymap.put("offset",page.getOffset());
        querymap.put("pageSize",page.getRows());
        map.put("rows",userService.findList(querymap));
        map.put("total",userService.getTotal(querymap));
        return map;
    }

    /** 
    * @Description: 添加用户
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map<String,Object> add(User user){
        Map<String,Object> map = new HashMap<String, Object>();
        if(user == null){
            map.put("type","error");
            map.put("message","请填写正确用户信息!");
            return map;
        }
        if(StringUtil.isEmpty(user.getUsername())) {
            map.put("type", "error");
            map.put("message", "请填写正确用户名称!");
            return map;
        }
        if(StringUtil.isEmpty(user.getPassword())) {
            map.put("type", "error");
            map.put("message", "请填写正确用户密码!");
            return map;
        }
        if(user.getRoleId() == null){
            map.put("type","error");
            map.put("message","请选择所属角色!");
            return map;
        }
        if(isExist(user.getUsername(),0l)){
            map.put("type","error");
            map.put("message","该用户名已经存在，请重新输入！");
            return map;
        }
        if(userService.add(user) <= 0){
            map.put("type","error");
            map.put("message","添加失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","添加成功！");
        return map;
    }

    /**
    * @Description: 编辑用户
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(User user){
        Map<String, String> ret = new HashMap<String, String>();
        if(user == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的用户信息！");
            return ret;
        }
        if(StringUtils.isEmpty(user.getUsername())){
            ret.put("type", "error");
            ret.put("msg", "请填写用户名！");
            return ret;
        }
        if(user.getRoleId() == null){
            ret.put("type", "error");
            ret.put("msg", "请选择所属角色！");
            return ret;
        }
        if(isExist(user.getUsername(), user.getId())){
            ret.put("type", "error");
            ret.put("msg", "该用户名已经存在，请重新输入！");
            return ret;
        }
        if(userService.edit(user) <= 0){
            ret.put("type", "error");
            ret.put("msg", "用户添加失败，请联系管理员！");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "角色添加成功！");
        return ret;
    }

    /** 
    * @Description: 删除用户 
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(String ids){
        Map<String, String> ret = new HashMap<String, String>();
        if(StringUtils.isEmpty(ids)){
            ret.put("type", "error");
            ret.put("msg", "选择要删除的数据！");
            return ret;
        }
        if(ids.contains(",")){
            ids = ids.substring(0,ids.length()-1);
        }
        if(userService.delete(ids) <= 0){
            ret.put("type", "error");
            ret.put("msg", "用户删除失败，请联系管理员！");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "用户删除成功！");
        return ret;
    }

    private boolean isExist(String username, Long id){
        User user = userService.findByUsername(username);
        if(user == null) return false;
        if(user.getId().longValue() == id.longValue()) return false;
        return true;
    }


    /**
    * @Description: 上传图片
    * @Param:
    * @return:
    * @Author: SongJian
    * @Date:
    */
    @RequestMapping(value="/upload_photo",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request){
        Map<String, String> ret = new HashMap<String, String>();
        if(photo == null){
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
            return ret;
        }
        if(photo.getSize() > 1024*1024*1024){
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过10M！");
            return ret;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")+1,photo.getOriginalFilename().length());
        if(!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())){
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png格式的图片！");
            return ret;
        }
        String savePath = request.getServletContext().getRealPath("/") + "/resource/upload/";
        File savePathFile = new File(savePath);
        if(!savePathFile.exists()){
            //若不存在改目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime()+"."+suffix;
        try {
            //将文件保存至指定目录
            photo.transferTo(new File(savePath+filename));
        }catch (Exception e) {
            // TODO Auto-generated catch block
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "用户删除成功！");
        ret.put("filepath",request.getServletContext().getContextPath() + "/resource/upload/" + filename );
        return ret;
    }
}
