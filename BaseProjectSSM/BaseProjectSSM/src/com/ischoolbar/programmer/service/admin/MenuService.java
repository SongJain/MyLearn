package com.ischoolbar.programmer.service.admin;

import com.ischoolbar.programmer.entity.admin.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 菜单管理Service
 * @author: SongJian
 * @create: 2019-02-24 20:18
 **/
@Service
public interface MenuService {
    public int add(Menu menu);
    public List<Menu> findList(Map<String,Object> queryMap);
    public List<Menu> findTopList();
    public int getTotal(Map<String,Object> queryMap);
    public int edit(Menu menu);
    public int delete(Long id);
    public List<Menu> findChildernList(Long parentId);
    public List<Menu> findListByIds(String ids);
}
