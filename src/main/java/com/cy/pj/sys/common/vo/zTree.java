package com.cy.pj.sys.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class zTree implements Serializable {
    private static final long serialVersionUID = 2257227611314830651L;
    private Integer id;
    private String name;
    private Integer parentId;

}
