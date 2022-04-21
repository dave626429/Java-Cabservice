package com.thinkifylab.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class ConnectionCheck {
    public static final Logger logger = LoggerFactory.getLogger(ConnectionCheck.class);
    
    // No Application level use, only for connection check
    // logging.level.com.zaxxer.hikari=INFO,DEBUG
    public ConnectionCheck(DataSource dataSource) throws SQLException {
        logger.info("Database connection valid = {}",dataSource.getConnection().isValid(1000));
    }
}