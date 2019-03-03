package com.ischoolbar.programmer.service.admin;

import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Log;
import org.apache.log4j.lf5.LogLevel;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 日志接口
 * @author: SongJian
 * @create: 2019-03-03 11:50
 **/
public interface LogService {
    public int add(Log log);
    public int add(String content);
    public List<Log> findList(Map<String,Object> queryMap);
    public int getTotal(Map<String,Object> map);
    public int delete(String ids);
}
