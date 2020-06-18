package com.cy.pj.sys.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装 修改菜单的信息
 */
@Data
public class SysRoleMenuBo implements Serializable {

    private static final long serialVersionUID = -2467844051576531102L;
    private Integer id;
    private String name;
    private String note;
    private List<Integer> menuIds;
}
