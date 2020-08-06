/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.Advice;

import com.fo.vendingmachine.dao.VendingMachineAuditDao;
import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author TheFemiFactor
 */
public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println
                    ("ERROR: Could not create audit entry in LoggingAdvice");
        }
    }
    
    public void createAuditExceptionEntry(JoinPoint jp, Exception ex) {

              
        String auditEntry = ex.getMessage() + " |";
        Object[] args = jp.getArgs();
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println
                    ("ERROR: Could not create audit entry in LoggingAdvice");
        }
        
       
    }
}
