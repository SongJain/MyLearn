package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.AuthorityDao;
import com.ischoolbar.programmer.entity.admin.Authority;
import com.ischoolbar.programmer.service.admin.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: BaseProjectSSM
 * @description
 * @author: SongJian
 * @create: 2019-02-27 20:36
 **/
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityDao authorityDao;

    @Override
    public int add(Authority authority) {
        return authorityDao.add(authority);
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        return authorityDao.deleteByRoleId(roleId);
    }

    @Override
    public List<Authority> findListByRoleId(Long roleId) {
        return authorityDao.findListByRoleId(roleId);
    }
}
