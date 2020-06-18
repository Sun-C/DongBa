package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;

public interface SysUserRolesDao {
    @Delete("DELETE FROM sys_user_roles WHERE role_id = #{id}")
    int doDeleteObject(Integer id);
}
