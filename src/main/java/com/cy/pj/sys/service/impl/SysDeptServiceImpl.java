package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.sys.dao.SysDeptDao;
import com.cy.pj.sys.entity.SysDept;
import com.cy.pj.sys.service.SysDeptService;

@Service
public class SysDeptServiceImpl implements SysDeptService {
	
	@Autowired
	private SysDeptDao sysDeptDao;

	@Override
	public List<SysDept> doFindZTreeNodes() {
		return sysDeptDao.doFindZTreeNodes();
	}
	
	
}
