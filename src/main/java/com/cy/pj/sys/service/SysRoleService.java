package com.cy.pj.sys.service;

import com.cy.pj.sys.bo.SysRoleMenuBo;
import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleService {

    /**
     * 初始化加载角色信息
     * @return
     */
    public PageObject<SysRole> doFindPageObjects(String name, Integer pageCurrent);

    /**
     * 根据id删除角色以及相关关联表信息
     */
    public int doDeleteObject(Integer id);
    /**
     *
     * @param entiey
     * @return
     */
    int doSaveObject(SysRole entiey,Integer...menuIds);

    /**
     * 基于角色id查询角色自身信息和对应的菜单id
     * @param id
     * @return
     */
    SysRoleMenuBo doFindObjectById(Integer id);
    /**
     * 修改角色信息
     */
    int doUpdateObject(SysRole entiey,Integer...menuIds);
    /**
     * 查询角色id name
     * @return
     */
	List<SysRole> doFindRoles();
}
