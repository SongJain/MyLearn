package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/**
 * @program: BaseProjectSSM
 * @description 角色role实体
 * @author: SongJian
 * @create: 2019-02-26 20:23
 **/

@Component
public class Role {
    private Long id;
    private String name;
    private  String remark;//角色备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
