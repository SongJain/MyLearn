package com.ischoolbar.programmer.service.admin;

import com.ischoolbar.programmer.entity.admin.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: BaseProjectSSM
 * @description 角色role service
 * @author: SongJian
 * @create: 2019-02-26 21:01
 **/
@Service
public interface RoleService {
    public int add(Role role);
    public int edit(Role role);
    public  int delete(Long id);
    public List<Role> findList(Map<String,Object> map);
    public int getTotal(Map<String,Object> map);
    public Role find(Long id);
}
