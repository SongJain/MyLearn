package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.AuthorityDao;
import com.ischoolbar.programmer.dao.admin.LogDao;
import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.entity.admin.Log;
import com.ischoolbar.programmer.service.admin.AuthorityService;
import com.ischoolbar.programmer.service.admin.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-02-27 20:36
 **/
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public int add(Log log) {
        return logDao.add(log);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return logDao.getTotal(map);
    }

    @Override
    public int delete(String ids) {
        return logDao.delete(ids);
    }

    @Override
    public int add(String content) {
        Log log = new Log();
        log.setContent(content);
        log.setCreateTime(new Date());
        return logDao.add(log);
    }

    @Override
    public List<Log> findList(Map<String, Object> queryMap) {
        return logDao.findList(queryMap);
    }
}
