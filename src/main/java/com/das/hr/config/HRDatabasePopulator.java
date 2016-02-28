package com.das.hr.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class HRDatabasePopulator implements InitializingBean {

    @Autowired
    JdbcTemplate template ;

    String dropTable ="DROP TABLE IF EXISTS company";
    String createTable ="create table company(" +
            "id BIGINT auto_increment," +
            "name VARCHAR(100)," +
            "PRIMARY KEY(id)" +
            ")";

    public void init() {
        System.out.print("Creating HR Tables ");
        template.execute(dropTable);
        template.execute(createTable);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
