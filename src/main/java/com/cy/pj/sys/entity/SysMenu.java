package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 建议: 在java中所有用于存储数据的对象都实现序列化接口  网络传输一个对象时会将对象序列化成字节 在进行传输  cache 缓存同理
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 6957715733386177156L;
    private Integer id;
    /**菜单名称*/
    private String name;
    /**菜单url: log/doFindPageObjects*/
    private String url;
    /**菜单类型(两种:按钮,普通菜单)*/
    private Integer type=1;
    /**排序(序号)*/
    private Integer sort;
    /**备注*/
    private String note;
    /**上级菜单id*/
    private Integer parentId;
    /**菜单对应的权限标识(sys:log:delete)*/
    private String permission;
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;
}

