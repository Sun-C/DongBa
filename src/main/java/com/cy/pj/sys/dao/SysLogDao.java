package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 日志模块数据接口层 : 定义数据访问规范
 */
public interface SysLogDao {
    /**
     * 基于客户端传来的id值参数来进行记录删除
     * @param ids 参数 数组集合
     * @return 删除了多少记录
     */
    int deleteSysLogByIds(Integer...ids);

    /**
     * 基于查询条件统计记录总数
     * @param username 查询条件
     * @return 查询到的记录数
     */
    //@Select("SELECT COUNT() FROM `sys_logs`")
    int getRowCount(@Param("username")String username);

    /**
     * 基于条件查询当前页的记录
     * @param username  查询条件
     * @param startIndex  起始位置(当前页的起始位置)
     * @param pageSize  查询记录数大小(每页最多显示多少条记录)
     * @return  返回查询到的日志记录
     */
    List<SysLog> findPageObjects(String username,
                                 Integer startIndex,
                                 Integer pageSize);

}
