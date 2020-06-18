package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.common.exception.ServiceException;
import com.cy.pj.sys.common.vo.zTree;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenusDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleMenusDao sysRoleMenusDao;

    /**
     * 基于id删除菜单信息
     * @return
     */
    @Override
    public int doDeleteObject(Integer id) {
        if (id == null||id<=0)throw new IllegalArgumentException("请选中后删除");
        int count = sysMenuDao.getMenuRows(id);
        if(count>0)throw new ServiceException("请先删除子菜单");
        //3.删除角色,菜单关系数据
        sysRoleMenusDao.deleteObjectsByMenuId(id);
        //4.删除菜单元素
        int rows = sysMenuDao.deleteSysMenu(id);
        if (rows<=0)throw new ServiceException("该菜单可能已经不存在");
        return 0;
    }

    /**
     * 查询 菜单的树结构信息
     * @return
     */
    @Override
    public List<zTree> doFindZtreeMenuNodes() {
        List<zTree> data = sysMenuDao.doFindZtreeMenuNodes();
        return data;
    }

    /**
     * 添加菜单信息
     * @param entity
     * @return
     */
    @Override
    public int doSaveObject(SysMenu entity) {
        //1.校验参数的合法性
        if (entity==null)throw new IllegalArgumentException("添加菜单信息不能为空");
        if (StringUtils.isEmpty(entity.getName()))throw new IllegalArgumentException("菜单名不能为空");
        //2.执行添加操作
        int rows;
        try {
            rows =  sysMenuDao.doSaveObject(entity);
        }catch (Exception e){
        e.printStackTrace();
        throw new ServiceException("保存失败!");
        }
        return rows;
    }

    /**
     * 修改菜单信息
     * @param entity
     * @return
     */
    @Override
    public int doUpdateObject(SysMenu entity) {
        //1.验证参数的合法性
        if (entity == null)throw new ServiceException("请先选择要修改的内容");
        if(StringUtils.isEmpty(entity.getName()))throw new IllegalArgumentException("菜单名字不能为空");
        //2.执行更新操作
        int rows = sysMenuDao.doUpdateObject(entity);
        if (rows==0)throw new ServiceException("该记录可能已经不存在!");
        return rows;
    }

    /**
     * 初始化菜单信息
     * @return
     */
    @Override
    public List<Map<String, Object>> doFindObjects() {
        List<Map<String, Object>> menus = sysMenuDao.findMenus();
        if (menus == null || menus.size()<=0)throw new ServiceException("没有菜单相关信息");
        return menus;
    }
}

