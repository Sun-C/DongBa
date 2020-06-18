package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.sys.entity.SysDept;
/**
 * 
 * @author 李晓阳
 *
 */
public interface SysDeptService {
	/**
	 * 查询部门集合数据
	 * @return
	 */
	List<SysDept> doFindZTreeNodes();

}
