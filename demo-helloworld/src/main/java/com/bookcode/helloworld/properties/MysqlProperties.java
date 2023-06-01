package com.bookcode.helloworld.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 从application.properties文件中读取自定义的配置信息
 */
@Component
@ConfigurationProperties(prefix = "mysql")
public class MysqlProperties {
    public String username;
    public String password;
    public String jdbcName;
    public String dbUrl;

    @Override
    public String toString() {
        return "MysqlProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcName='" + jdbcName + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
}
