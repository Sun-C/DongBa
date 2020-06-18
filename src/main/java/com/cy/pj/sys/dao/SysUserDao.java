package com.cy.pj.sys.dao;

import com.cy.pj.sys.bo.SysUserDeptBo;
import com.cy.pj.sys.entity.SysUser;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserDao {

    /**
     * 获取用户总记录
     * @param username
     * @return
     */
    int getRowCount(String username);

    /**
     * 分页查询用户信息
     * @return
     */
    List<SysUserDeptBo> doFindPageObject(String username,Integer startIndex,Integer pageSize);

    /**
     * 根据用户id修改用户状态信息
     * @param id
     * @param valid
     * @return
     */
    @Update("UPDATE sys_users SET valid = #{valid},modifiedUser=#{modifiedUser},modifiedTime=now() WHERE id=#{id}")
    int doValidById(Integer id, Integer valid,String modifiedUser);
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("SELECT id,username,email,mobile FROM sys_users WHERE id = #{id}")
	SysUser doFindObjectById(Integer id);
}
