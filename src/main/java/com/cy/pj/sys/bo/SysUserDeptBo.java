package com.cy.pj.sys.bo;

import java.io.Serializable;
import java.util.Date;

import com.cy.pj.sys.entity.SysDept;

import lombok.Data;

@Data
public class SysUserDeptBo implements Serializable{

	private static final long serialVersionUID = -7903932387393553306L;
	private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid;
    private SysDept sysDept;
    //private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
	
	
}
