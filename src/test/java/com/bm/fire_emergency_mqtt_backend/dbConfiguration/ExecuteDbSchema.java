package com.bm.fire_emergency_mqtt_backend.dbConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@TestConfiguration
public class ExecuteDbSchema {

    @Autowired
    private DataSource database;

    private static boolean dataLoaded = false;

    @Bean
    public void setup() throws SQLException {
        if (!dataLoaded) {
            try (Connection con = database.getConnection()) {
                ScriptUtils.executeSqlScript(con, new ClassPathResource("test/schema/schema.sql"));
                ScriptUtils.executeSqlScript(con, new ClassPathResource("test/user.sql"));
                ScriptUtils.executeSqlScript(con, new ClassPathResource("test/client-info.sql"));
                ScriptUtils.executeSqlScript(con, new ClassPathResource("test/electronic-card-user.sql"));


                dataLoaded = true;
            }
        }
    }
}
