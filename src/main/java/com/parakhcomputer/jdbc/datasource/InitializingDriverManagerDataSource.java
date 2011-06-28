package com.parakhcomputer.jdbc.datasource;

import java.sql.Driver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import com.parakhcomputer.jdbc.core.SqlScriptProcessor;


/**
 * Initializing version of <code>DriverManagerDataSource</code>.
 * After the properties are set any database initialization scripts are run.
 * This is very useful for unit testing.
 * 
 * @author 
 * 
 * @see org.springframework.jdbc.datasource.SimpleDriverDataSource
 * @see com.parakhcomputer.jdbc.core.SqlScriptProcessor
 */
public class InitializingDriverManagerDataSource extends SimpleDriverDataSource 
        implements InitializingBean {

    protected String driverClassName = null;
    protected SqlScriptProcessor sqlScriptProcessor = null;

    /**
     * Sets driver class name.  The class should implement 
     * <code>java.sql.Driver</code>.  This is a shortcut for 
     * calling <code>setDriver(Driver driver)</code> on the parent class.
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * Sets SQL script processor.
     */
    public void setSqlScriptProcessor(SqlScriptProcessor sqlScriptProcessor) {
        this.sqlScriptProcessor = sqlScriptProcessor;
    }

    /**
     * Implementation of <code>InitializingBean</code>
     */
    @SuppressWarnings("unchecked")
    public void afterPropertiesSet() throws Exception {
        // if driver class name isn't blank, set 
        // driver class on SimpleDriverDataSource.
        if (getDriver() == null && StringUtils.hasText(driverClassName)) {
            setDriverClass((Class<? extends Driver>) ClassUtils.forName(driverClassName, ClassUtils.getDefaultClassLoader()));
        }
        
        if (sqlScriptProcessor != null) {
            sqlScriptProcessor.setDataSource(this);

            sqlScriptProcessor.process();
        }
    }

}