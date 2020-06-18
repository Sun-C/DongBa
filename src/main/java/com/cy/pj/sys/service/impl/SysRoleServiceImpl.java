package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.bo.SysRoleMenuBo;
import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenusDao;
import com.cy.pj.sys.dao.SysUserRolesDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.image.AffineTransformOp;
import java.util.Arrays;
import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenusDao sysRoleMenusDao;
    @Autowired
    private SysUserRolesDao sysUserRolesDao;
    @Override
    public PageObject<SysRole> doFindPageObjects(String name,Integer pageCurrent) {
        int rowCount = sysRoleDao.getRowCount(name);
        if (rowCount<=0)throw new ServiceException("没有角色信息");
        int pageSize = 3;
        int startIndex = (pageCurrent-1)*pageSize;
        List<SysRole> list = sysRoleDao.doFindPageObjects(name,startIndex,pageSize);
        return new PageObject<SysRole>(pageCurrent,pageSize,rowCount,list);
    }
    /**
     * 根据id删除角色以及相关关联表信息
     */
    @Override
    public int doDeleteObject(Integer id) {
        if (id==null || id<1) throw new IllegalArgumentException("请选中要删除的角色");
        int rRow;
        try {
            int row = sysRoleMenusDao.deleteObjectByRoleId(id);
            int uRow = sysUserRolesDao.doDeleteObject(id);
            rRow = sysRoleDao.doDeleteRoleById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("删除失败");
        }
        return rRow;
    }

    /**
     * 新增角色信息 和菜单关联信息
     * @param entity
     * @param menuIds
     * @return
     */
    @Override
    public int doSaveObject(SysRole entity,Integer...menuIds) {
        System.out.println(entity+"========="+ Arrays.toString(menuIds));
        if (entity==null)throw new IllegalArgumentException("请完整填写角色信息");
        if (StringUtils.isEmpty(entity.getName()))throw new IllegalArgumentException("角色名不能为空");
        if (menuIds ==null || menuIds.length<1)throw new IllegalArgumentException("请选择角色的权限");
        int rows = sysRoleDao.doSaveObject(entity);
        int rmRows = sysRoleMenusDao.insertRoleMenus(entity.getId(),menuIds);
        if (rows<=0)throw new ServiceException("添加失败");
        if (rmRows<=0)throw new ServiceException("添加角色菜单信息失败");
        return rows;
    }

    /**
     * 基于id查询修改角色的信息
     * @param id
     * @return
     */
    @Override
    public SysRoleMenuBo doFindObjectById(Integer id) {
        //1.参数校验
        if (id==null || id<1)throw new IllegalArgumentException("修改用户的id无效");
        //2.基于id查询 名字 和 note 信息
        SysRoleMenuBo rmBO = sysRoleDao.doFindRoleMenuId(id);
        List<Integer> menuIds = sysRoleMenusDao.doFindRoleMenu(id);
        rmBO.setMenuIds(menuIds);
        return rmBO;
    }

    /**
     * 修改角色信息
     * @param entity
     * @param menuIds
     * @return
     */
    @Override
    public int doUpdateObject(SysRole entity, Integer... menuIds) {
        //1.参数校验
        if (entity==null)throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getName()))throw new IllegalArgumentException("角色名不能为空");
        if (menuIds==null || menuIds.length<1)throw new IllegalArgumentException("请为角色赋予权限");
        //2.执行更新操作
        int rRow = sysRoleDao.doUpdataObject(entity);
        int dRow = sysRoleMenusDao.deleteObjectByRoleId(entity.getId());
        int rmRow = sysRoleMenusDao.insertRoleMenus(entity.getId(), menuIds);
        System.out.println(rmRow+","+rRow);
        return rRow;
    }
}
