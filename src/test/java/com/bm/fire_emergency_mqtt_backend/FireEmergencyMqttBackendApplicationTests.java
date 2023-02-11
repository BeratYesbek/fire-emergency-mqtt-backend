package com.bm.fire_emergency_mqtt_backend;

import com.bm.fire_emergency_mqtt_backend.DbConfiguration.DbConf;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class FireEmergencyMqttBackendApplicationTests {



}
