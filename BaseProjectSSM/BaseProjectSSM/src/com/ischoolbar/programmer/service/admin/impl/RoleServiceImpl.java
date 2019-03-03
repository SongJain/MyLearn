package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.RoleDao;
import com.ischoolbar.programmer.entity.admin.Role;
import com.ischoolbar.programmer.service.admin.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description role 的实现类
 * @author: SongJian
 * @create: 2019-02-26 21:06
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public int add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public int edit(Role role) {
        return roleDao.edit(role);
    }

    @Override
    public int delete(Long id) {
        return roleDao.delete(id);
    }

    @Override
    public Role find(Long id) {
        return roleDao.find(id);
    }

    @Override
    public List<Role> findList(Map<String, Object> map) {
        return roleDao.findList(map);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return roleDao.getTotal(map);
    }
}
