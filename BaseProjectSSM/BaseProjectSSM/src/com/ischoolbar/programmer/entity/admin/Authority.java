package com.ischoolbar.programmer.entity.admin;


import org.springframework.stereotype.Component;

/**
 * @program: BaseProjectSSM
 * @description 权限实体
 * @author: SongJian
 * @create: 2019-02-26 20:23
 **/
@Component
public class Authority {
    private Long id;

    private Long roleId;//角色id

    private Long menuId;//菜单id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }


}

