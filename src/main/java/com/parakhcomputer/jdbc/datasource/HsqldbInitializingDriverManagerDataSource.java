package com.parakhcomputer.jdbc.datasource;

import java.sql.Driver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;


/**
 * <p>HSQL DB specific initializing <code>DriverManagerDataSource</code>.
 * If values aren't set for driver class name, url, username, or password 
 * defaults for an in memory HSQL DB are used.</p>
 * 
 * <p>After the properties are set any database initialization scripts are run.
 * This is very useful for unit testing.</p>
 * 
 * @author 
 * 
 * @see org.springframework.jdbc.datasource.SimpleDriverDataSource
 */
public class HsqldbInitializingDriverManagerDataSource extends InitializingDriverManagerDataSource 
        implements InitializingBean {

    protected static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    protected static String URL = "jdbc:mysql://localhost:3306/colorpalette";
    protected static String USERNAME = "root";
    protected static String PASSWORD = "rootlamp";
/*
    
    protected static String DRIVER_CLASS_NAME = "org.hsqldb.jdbcDriver";
    protected static String URL = "jdbc:hsqldb:mem:Test";
    protected static String USERNAME = "sa";
    protected static String PASSWORD = "";



 */
    /**
     * Implementation of <code>InitializingBean</code>
     */
    @SuppressWarnings("unchecked")
    public void afterPropertiesSet() throws Exception {
        if (getDriver() == null && !StringUtils.hasText(driverClassName)) {
            setDriverClass((Class<? extends Driver>) ClassUtils.forName(DRIVER_CLASS_NAME, ClassUtils.getDefaultClassLoader()));
        }

        if (!StringUtils.hasText(getUrl())) {
            setUrl(URL);
        }

        if (!StringUtils.hasText(getUsername())) {
            setUsername(USERNAME);
        }

        if (!StringUtils.hasText(getPassword())) {
            setPassword(PASSWORD);
        }
        
        super.afterPropertiesSet();
    }

}