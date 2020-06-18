package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 菜单和角色的关系维护层
 */
public interface SysRoleMenusDao {
    /**
     * 根据菜单id删除对应的 关联角色表信息
     * @param id
     * @return
     */
    int deleteObjectsByMenuId(Integer id);

    /**
     * 基于id角色id删除对应的菜单关联表信息
     */
    @Delete("DELETE FROM sys_role_menus WHERE role_id = #{id}")
    int deleteObjectByRoleId(Integer id);

    /**
     * 新增 角色菜单关系数据
     * @param roleId
     * @param menuIds
     * @return
     */
    int insertRoleMenus(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

    /**
     * 基于角色id查询两表关联数据
     * @param id
     * @return
     */
    @Select("SELECT menu_id FROM sys_role_menus WHERE role_id = #{id}")
    List<Integer> doFindRoleMenu(Integer id);
}
