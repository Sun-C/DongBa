package com.cy.log;

import com.cy.pj.sys.common.bo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LogTest {
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private SysLogService sysLogService;

    @Test
    public void testDeleteSysLogById(){
        int i = sysLogDao.deleteSysLogByIds(12);
        System.out.println("删除了"+i+"条记录");
    }
    @Test
    public void testLogService(){
        PageObject<SysLog> pageObjects = sysLogService.findPageObjects(null, 10);
        System.out.println(pageObjects);
    }


    @Test
    public void testLogRowCount(){
        int rows = sysLogDao.getRowCount("");
        System.out.println("rows="+rows);
        List<SysLog> admin = sysLogDao.findPageObjects("", 0, 10);
        for (SysLog a:admin) {
            System.out.println(a);
        }
    }
}
