package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 建议: 在java中所有用于存储数据的对象都实现序列化接口  网络传输一个对象时会将对象序列化成字节 在进行传输  cache 缓存同理
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 2583837214687426259L;
    private Integer id;
    //角色名
    private String name;
    //角色描述信息
    private String note;
    //创建时间
    private Date createdTime;
    //修改时间
    private Date modifiedTime;
    //创建用户
    private String createdUser;
    //修改用户
    private String modifiedUser;
}

