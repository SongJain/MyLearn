package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: BaseProjectSSM
 * @description 权限dao
 * @author: SongJian
 * @create: 2019-02-27 20:34
 **/
@Repository
public interface AuthorityDao {
    public int add(Authority authority);
    public int deleteByRoleId(Long roleId);
    public List<Authority> findListByRoleId(Long roleId);
}
