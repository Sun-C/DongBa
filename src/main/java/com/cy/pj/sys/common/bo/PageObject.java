package com.cy.pj.sys.common.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 此对象为业务层向外输出的一个bo对象 用于封装业务执行的结果
 * 泛型: 类上定义泛型用于约束类中的属性和方法参数, 方法返回类型
 * @param <T>
 */
@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 7802766386718596695L;
    /**
     * 当前页的页码值
     */
    private Integer pageCurrent;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总行数(通过查询获得)
     */
    private Integer rowCount;
    /**
     * 总页数(通过计算获得)
     */
    private Integer pageCount;
    /**
     * 当前页对象记录
     */
    private List<T> records;

    public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
        super();
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.records = records;
        this.pageCount = (rowCount-1)/pageSize+1;
    }
}

