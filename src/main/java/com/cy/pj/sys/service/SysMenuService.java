package com.cy.pj.sys.service;

import com.cy.pj.sys.common.vo.zTree;
import com.cy.pj.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * 定义菜单操作模块接口
 */
public interface SysMenuService {
    /**
     * 获取菜单数据接口
     * @return
     */
    List<Map<String,Object>> doFindObjects();

    /**
     * 删除菜单信息接口
     * @param id
     * @return
     */
    int doDeleteObject(Integer id);

    /**
     * 查询菜单节点
     * @return
     */
    List<zTree> doFindZtreeMenuNodes();

    /**
     * 新增菜单或按钮信息
     * @param entity
     * @return
     */
    int doSaveObject(SysMenu entity);


    int doUpdateObject(SysMenu entity);
}
