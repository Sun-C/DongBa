package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务实现类
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageObject<SysUser> doFindPageObject(Integer pageCurrent, String username) {
        if (pageCurrent==null || pageCurrent<1)throw new IllegalArgumentException("查询页码值无效");
        int rows = sysUserDao.getRowCount(username);
        if (rows<1)throw new ServiceException("没有查找到相关用户");
        int pageSize = 3;
        int startIndex = (pageCurrent-1)*pageSize;
        List<SysUser> list = sysUserDao.doFindPageObject(username,startIndex,pageSize);
        return new PageObject<>(pageCurrent,pageSize,rows,list);
    }

    /**
     * 根据用户id修改当前状态
     * @param id
     * @param valid
     * @return
     */
    @Override
    public int doValidById(Integer id, Integer valid) {
        //1.参数判断
        if(valid==0){
            valid=1;
        }else {
            valid=0;
        }
        int row = sysUserDao.doValidById(id,valid);
        if (row==0)throw new ServiceException("状态修改失败");
        return row;
    }

}
