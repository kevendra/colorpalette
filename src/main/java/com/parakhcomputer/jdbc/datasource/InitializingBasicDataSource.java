package com.parakhcomputer.jdbc.datasource;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.parakhcomputer.jdbc.core.SqlScriptProcessor;


/**
 * Initializing version of <code>BasicDataSource</code>.
 * After the properties are set any database initialization scripts are run.
 * This is very useful for unit testing.
 * 
 * @author
 * 
 * @see org.apache.commons.dbcp.BasicDataSource
 * @see com.parakhcomputer.jdbc.core.SqlScriptProcessor
 */
public class InitializingBasicDataSource extends BasicDataSource 
        implements InitializingBean, DisposableBean {

    protected SqlScriptProcessor sqlScriptProcessor = null;

    /**
     * Sets SQL script processor.
     */
    public void setSqlScriptProcessor(SqlScriptProcessor sqlScriptProcessor) {
        this.sqlScriptProcessor = sqlScriptProcessor;
    }

    /**
     * Implementation of <code>InitializingBean</code>
     */
    public void afterPropertiesSet() throws Exception {
        if (sqlScriptProcessor != null) {
            sqlScriptProcessor.setDataSource(this);

            sqlScriptProcessor.process();
        }
    }

    /**
     * Implementation of <code>DisposableBean</code>
     */
    public void destroy() throws Exception {
        close();
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}