package com.cy.pj.sys.entity;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;
import lombok.Data;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;
import java.util.Date;

/**
 * 建议: 在java中所有用于存储数据的对象都实现序列化接口  网络传输一个对象时会将对象序列化成字节 在进行传输  cache 缓存同理
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = 8924387722922123121L;
    private Integer id;
    //用户名
    private String username;
    //用户操作1
    private String operation;
    //请求方法
    private String method;
    //请求参数
    private String params;
    //执行时长(毫秒)
    private Long time;
    //IP地址
    private String ip;
    //创建时间
    private Date createdTime;
}

