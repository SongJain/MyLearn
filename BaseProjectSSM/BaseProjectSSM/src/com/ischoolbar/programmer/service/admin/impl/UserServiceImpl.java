package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.UserDao;
import com.ischoolbar.programmer.entity.admin.User;
import com.ischoolbar.programmer.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-02-23 11:02
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int getTotal(Map<String, Object> querymap) {
        return userDao.getTotal(querymap);
    }

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int edit(User user) {
        return userDao.edit(user);
    }

    @Override
    public int delete(String ids) {
        return userDao.delete(ids);
    }

    @Override
    public int editPassword(User user) {
        return userDao.editPassword(user);
    }

    @Override
    public List<User> findList(Map<String, Object> querymap) {
        return userDao.findList(querymap);
    }
}
