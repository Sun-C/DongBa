package com.cy.pj.sys.dao;

import com.cy.pj.sys.common.vo.zTree;
import com.cy.pj.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuDao {

    /**
     * 查询菜单表中所有的菜单记录
     * 一行记录被映射为
     * @return
     */
    List<Map<String,Object>> findMenus();

    /**
     * 根据id查询是否有子菜单id存在
     * @param id
     * @return
     */
    int getMenuRows(Integer id);

    /**
     * 根据id删除菜单信息
     * @param id
     * @return
     */
    int deleteSysMenu(Integer id);

    /**
     * 查询菜单节点数据
     * @return
     */
    List<zTree> doFindZtreeMenuNodes();

    /**
     * 新增菜单或按钮信息
     * @param entity
     * @return
     */
    int doSaveObject(SysMenu entity);

    /**
     * 修改菜单按钮等信息
     * @param entity
     * @return
     */
    int doUpdateObject(SysMenu entity);
}
