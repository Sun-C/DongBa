package com.cy.pj.sys.service;

import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.entity.SysLog;

/**
 * 业务层接口: 负责定义日志模块规则
 * 1)查询日志业务(添加分页业务实现
 * 2)删除日志业务(后期会进行权限控制
 * 3)添加日志业务(用AOP实现
 */
public interface SysLogService {

    /**
     * 基于前端传过来的数据 来进行日志删除操作
     * @param ids
     * @return
     */
    int deleteSysLogByIds(Integer...ids);
    /**
     * 定义日志分页查询业务
     * @param username 用户名 数据最终来自客户端 client
     * @param pageCurrent 当前页码值 数据最终来自客户端 client
     * @return 封装当前页记录和分业信息的对象PageObject
     */
    PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
}
