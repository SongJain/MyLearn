package com.ischoolbar.programmer.util;

import com.ischoolbar.programmer.entity.admin.Log;
import com.ischoolbar.programmer.service.admin.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-03-03 13:29
 **/
@Component
public class LogUtil {

    @Autowired
    private LogService logService;

//    public static void addLog(String content){
//        Log log = new Log();
//        log.setContent(content);
//        log.setCreateTime(new Date());
//        logService.add(log);
//}

}
