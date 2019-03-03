package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 系统日志dao
 * @author: SongJian
 * @create: 2019-02-27 20:34
 **/
@Repository
public interface LogDao {
    public int add(Log log);
    public List<Log> findList(Map<String,Object> queryMap);
    public int getTotal(Map<String,Object> map);
    public int delete(String ids);
}
