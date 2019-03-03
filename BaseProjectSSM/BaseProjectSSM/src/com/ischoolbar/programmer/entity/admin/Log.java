package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: BaseProjectSSM
 * @description 日志实体
 * @author: SongJian
 * @create: 2019-02-26 20:23
 **/
@Component
public class Log {

	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Date createTime;

	private String content;

}
