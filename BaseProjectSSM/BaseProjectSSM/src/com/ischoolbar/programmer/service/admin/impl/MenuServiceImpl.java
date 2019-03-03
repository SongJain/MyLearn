package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.MenuDao;
import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.service.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 菜单管理实现类
 * @author: SongJian
 * @create: 2019-02-24 20:24
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public List<Menu> findListByIds(String ids) {
        return menuDao.findListByIds(ids);
    }

    @Override
    public int delete(Long id) {
        return menuDao.delete(id);
    }

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findTopList() {
        return menuDao.findTopList();
    }

    @Override
    public int add(Menu menu) {
        return menuDao.add(menu);
    }

    @Override
    public List<Menu> findList(Map<String, Object> queryMap) {
        return menuDao.findList(queryMap);
    }

    @Override
    public int getTotal(Map<String, Object> queryMap) {
        return menuDao.getTotal(queryMap);
    }

    @Override
    public int edit(Menu menu) {
        return menuDao.edit(menu);
    }

    @Override
    public List<Menu> findChildernList(Long parentId) {
        return menuDao.findChildernList(parentId);
    }
}
