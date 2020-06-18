package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.common.exception.ServiceException;
import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public int deleteSysLogByIds(Integer... ids) {
        //1.校验参数的合法性
        System.out.println(ids.toString()+"==============================================");
        if (ids==null || ids.length<1)throw new IllegalArgumentException("请先选择要删除的数据");
        //2.执行删除操作
        int i = sysLogDao.deleteSysLogByIds(ids);
        //3.判断是否有数据被删除
        if (i<1)throw new ServiceException("该记录可能已经不存在");
        return i;
    }

    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        //1.验证参数的合法性
        if (pageCurrent == null || pageCurrent <1) throw new IllegalArgumentException("页码值不正确");
        //2.基于条件查询记录数
        //2.1 执行查询
        int rowCount = sysLogDao.getRowCount(username);
        //2.2 假如记录为0 说明没有对应的记录就不往下查询  serviceException 我们自定义的处理业务异常
        if (rowCount==0)throw new ServiceException("系统没有查找到相关的记录");
        //3.1 基于当前条件查询当前页记录数(pageSize先定义为3条) 应该前端传过来的
        int pageSize = 100;
        //3.2 计算startIndex
        int startIndex = (pageCurrent-1)*pageSize;
        //3.3 执行当前数据查询操作
        List<SysLog> pageObjects = sysLogDao.findPageObjects(username, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        // PageObject<SysLog> pageObject = new PageObject<>();
        //4.2)封装数据
        //pageObject.setRecords(pageObjects);
        //pageObject.setPageCurrent(pageCurrent);
        //pageObject.setPageSize(pageSize);
        //pageObject.setPageCount((rows-1)/pageSize+1);
        PageObject<SysLog> pageObject = new PageObject<>(pageCurrent,pageSize,rowCount,pageObjects);
        return pageObject;
    }
}
