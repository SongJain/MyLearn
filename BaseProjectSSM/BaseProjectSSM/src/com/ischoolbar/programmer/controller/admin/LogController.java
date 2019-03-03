package com.ischoolbar.programmer.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.Log;
import com.ischoolbar.programmer.entity.admin.User;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.LogService;
import com.ischoolbar.programmer.service.admin.RoleService;
import com.ischoolbar.programmer.service.admin.UserService;
import org.apache.commons.lang.StringUtils;
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
 * @description 日志管理控制器
 * @author: SongJian
 * @create: 2019-02-28 22:41
 **/

@Controller
@RequestMapping("/admin/log")
public class LogController {
    @Autowired
    LogService logService;


    /** 
    * @Description: 用户列表页面
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("log/list");
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
                                      @RequestParam(name="content",required = false,defaultValue = "") String content
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> querymap = new HashMap<String, Object>();
        querymap.put("content",content);
        querymap.put("offset",page.getOffset());
        querymap.put("pageSize",page.getRows());
        map.put("rows",logService.findList(querymap));
        map.put("total",logService.getTotal(querymap));
        return map;
    }

    /** 
    * @Description: 添加日志
    * @Param:  
    * @return:  
    * @Author: SongJian
    * @Date:  
    */ 
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map<String,Object> add(Log log){
        Map<String,Object> map = new HashMap<String, Object>();
        if(log == null){
            map.put("type","error");
            map.put("message","请填写正确用户信息!");
            return map;
        }
        if(StringUtil.isEmpty(log.getContent())){
            map.put("type", "error");
            map.put("message", "请填写日志内容!");
            return map;
        }
        log.setCreateTime(new Date());
        if(logService.add(log) <= 0){
            map.put("type","error");
            map.put("message","添加失败，请联系管理员！");
            return map;
        }
        map.put("type","success");
        map.put("message","添加成功！");
        return map;
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
        if(logService.delete(ids) <= 0){
            ret.put("type", "error");
            ret.put("msg", "用户删除失败，请联系管理员！");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "用户删除成功！");
        return ret;
    }

}
