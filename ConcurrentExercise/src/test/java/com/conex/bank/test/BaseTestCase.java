package com.conex.bank.test;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BaseTestCase extends AbstractTransactionalJUnit4SpringContextTests  {
    
    @Inject
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;
    
    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(masterDataSource);
    }

}
