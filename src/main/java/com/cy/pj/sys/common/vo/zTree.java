package com.cy.pj.sys.common.vo;

import lombok.Data;

import java.io.Serializable;
/**
 * 这个是菜单树结构vo对象
 * @author tarena
 *
 */
@Data
public class zTree implements Serializable {
    private static final long serialVersionUID = 2257227611314830651L;
    private Integer id;
    private String name;
    private Integer parentId;
 
}
