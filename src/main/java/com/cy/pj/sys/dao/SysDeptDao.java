package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysDept;

public interface SysDeptDao {
	@Select("SELECT * FROM sys_depts WHERE id = #{id}")
	SysDept doFindObject(Integer id);
	
	@Select("SELECT * FROM sys_depts")
	List<SysDept> doFindZTreeNodes();
}
