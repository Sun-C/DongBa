package com.cy.pj.sys.service;

import com.cy.pj.sys.bo.SysUserDeptBo;
import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.entity.SysUser;

public interface SysUserService {
    /**
     * 初始化加载 用户信息
     * @param pageCurrent
     * @param username
     * @return
     */
    PageObject<SysUserDeptBo> doFindPageObject(Integer pageCurrent, String username);

    /**
     * 根据用户id修改用户状态
     * @param id
     * @param valid
     * @return
     */
    String doValidById(Integer id, Integer valid,String modifiedUser);
    /**
     * 修改用户信息
     * @param id
     * @return
     */

	SysUser doFinObjectById(Integer id);
	
}
