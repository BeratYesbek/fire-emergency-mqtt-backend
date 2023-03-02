package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.GAS_SENSOR_LOG_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateDbGasSensorLogConstants.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = GAS_SENSOR_LOG_TABLE)
public class DbGasSensorLog extends DbEntity {

    @Column(name = COL_MODEL_NO, nullable = false)
    private String modelNo;

    @Column(name = COL_SENSOR_TYPE, nullable = false)
    private String sensorType;

    @Column(name = COL_DETECTION_GAS, nullable = false)
    private String detectionGas;

    @Column(name = COL_CONCENTRATION, nullable = false)
    private String concentration;

    @Column(name = COL_LOOP_VOLTAGE, nullable = false)
    private String loopVoltage;

    @Column(name = COL_HEATER_VOLTAGE, nullable = false)
    private String heaterVoltage;

    @Column(name = COL_LOAD_RESISTANCE, nullable = false)
    private String loadResistance;

    @Column(name = COL_HEATER_CONSUMPTION, nullable = false)
    private String heaterConsumption;

    @Column(name = COL_SENSING_RESISTANCE, nullable = false)
    private String sensingResistance;

    @Column(name = COL_SENSITIVITY, nullable = false)
    private String sensitivity;

    @Column(name = COL_SLOPE, nullable = false)
    private String slope;

    @Column(name = COL_TEM_HUMIDITY, nullable = false)
    private String temHumidity;

    @Column(name = COL_STANDARD_TEST_CIRCUIT, nullable = false)
    private String standardTestCircuit;

    @Column(name = COL_PREHEAT_TIME, nullable = false)
    private Date preheatTime;

    @Override
    public String toString() {
        return "DbGasSensorLog{" +
                "id=" + id +
                ", modelNo='" + modelNo + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", detectionGas='" + detectionGas + '\'' +
                ", concentration='" + concentration + '\'' +
                ", loopVoltage='" + loopVoltage + '\'' +
                ", heaterVoltage='" + heaterVoltage + '\'' +
                ", loadResistance='" + loadResistance + '\'' +
                ", heaterConsumption='" + heaterConsumption + '\'' +
                ", sensingResistance='" + sensingResistance + '\'' +
                ", sensitivity='" + sensitivity + '\'' +
                ", slope='" + slope + '\'' +
                ", temHumidity='" + temHumidity + '\'' +
                ", standardTestCircuit='" + standardTestCircuit + '\'' +
                ", preheatTime=" + preheatTime +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
