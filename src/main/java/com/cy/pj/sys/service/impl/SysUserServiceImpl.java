package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.bo.SysUserDeptBo;
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
    public SysUser doFinObjectById(Integer id) {
    	if(id==null || id<1)throw new IllegalArgumentException("修改用户信息id异常");
    	SysUser user = sysUserDao.doFindObjectById(id);
    	if(user==null)throw new ServiceException("当前用户可能不存在了");
    	return user;
    }
    @Override
    public PageObject<SysUserDeptBo> doFindPageObject(Integer pageCurrent, String username) {
        if (pageCurrent==null || pageCurrent<1)throw new IllegalArgumentException("查询页码值无效");
        int rows = sysUserDao.getRowCount(username);
        if (rows<1)throw new ServiceException("没有查找到相关用户");
        int pageSize = 3;
        int startIndex = (pageCurrent-1)*pageSize;
        List<SysUserDeptBo> list = sysUserDao.doFindPageObject(username,startIndex,pageSize);
        return new PageObject<>(pageCurrent,pageSize,rows,list);
    }

    /**
     * 根据用户id修改当前状态
     * @param id
     * @param valid
     * @return
     */
    @Override
    public String doValidById(Integer id, Integer valid,String modifiedUser) {
        //1.参数判断
    	String msg;
        if(valid==0){
            valid=1;
            msg = "禁用成功";
        }else {
            valid=0;
            msg = "启用成功";
        }
        modifiedUser = "admin";
        int row = sysUserDao.doValidById(id,valid,modifiedUser);
        if (row==0)throw new ServiceException("状态修改失败");
        return msg;
    }

}
