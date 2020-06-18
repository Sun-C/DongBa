package com.cy.pj.sys.dao;

import com.cy.pj.sys.bo.SysRoleMenuBo;
import com.cy.pj.sys.entity.SysRole;
import org.apache.ibatis.annotations.Delete;

import java.util.List;
import java.util.Map;

/**
 * 角色操作信息
 */
public interface SysRoleDao {
    /**
     * 查询初始化角色信息
     * @return
     */
    List<SysRole> doFindPageObjects(String name,Integer startIndex,Integer pageSize);

    /**
     * 获取角色行数统计
     * @param name
     * @return
     */
    int getRowCount(String name);

    /**
     * 基于角色id删除角色自身信息
     */
    @Delete("DELETE FROM sys_roles WHERE id=#{id}")
    int doDeleteRoleById(Integer id);
    /**
     * 添加角色信息
     * @param entity
     * @return
     */
    int doSaveObject(SysRole entity);

    /**
     * 基于id关联查询 角色信息和菜单信息
     * @param id
     * @return
     */
    SysRoleMenuBo doFindRoleMenuId(Integer id);

    /**
     * 修改角色菜单信息
     * @param entity
     * @return
     */
    int doUpdataObject(SysRole entity);
}
