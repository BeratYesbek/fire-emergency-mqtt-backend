package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import com.bm.fire_emergency_mqtt_backend.business.services.GasSensorLogService;
import com.bm.fire_emergency_mqtt_backend.core.annotations.MqttListener;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import static com.bm.fire_emergency_mqtt_backend.mqtt.constants.MqttConstants.LOG;

@MqttListener(name = "LogListener")
public class MqttLogListener extends AbstractMqttListener {

    private final IMqttClient mqttClient;
    private final GasSensorLogService gasSensorLogService;

    public MqttLogListener(IMqttClient mqttClient, GasSensorLogService gasSensorLogService) {
        super(mqttClient);
        this.mqttClient = mqttClient;
        this.gasSensorLogService = gasSensorLogService;
        CompletableFuture.runAsync(this::listener);
    }

    @Override
    protected void listener() {
        try {
            mqttClient.subscribe(LOG, ((topic, message) -> {
                System.out.println("----------> Log listener is working");
                DbGasSensorLog dbGasSensorLog = setData(message);
               addLog(dbGasSensorLog);
            }));
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }

        super.listener();
    }

    private void addLog(DbGasSensorLog dbGasSensorLog) {
        gasSensorLogService.create(dbGasSensorLog);
    }

    private DbGasSensorLog setData(MqttMessage jsonData) throws JSONException, ParseException {
        JSONObject jsonObject = new JSONObject(new String(jsonData.getPayload()));
 //       String cardUUID = jsonObject.get("cardUUID").toString();
 //        String urgentLevel = jsonObject.get("urgentLevel").toString();
        String sensorType = jsonObject.get("sensorType").toString();
        String detectionGas = jsonObject.get("detectionGas").toString();
        String modelNo = jsonObject.get("modelNo").toString();
        String concentration = jsonObject.get("concentration").toString();
        String loopVoltage = jsonObject.get("loopVoltage").toString();
        String heaterVoltage = jsonObject.get("heaterVoltage").toString();
        String loadResistance = jsonObject.get("loadResistance").toString();
        String heaterConsumption = jsonObject.get("heaterConsumption").toString();
        String sensingResistance = jsonObject.get("sensingResistance").toString();
        String sensitivity = jsonObject.get("sensitivity").toString();
        String slope = jsonObject.get("slope").toString();
        String temHumidity = jsonObject.get("temHumidity").toString();
        String standardTestCircut = jsonObject.get("standardTestCircuit").toString();
        Date preheatTimeDate = new Date();
        return DbGasSensorLog.builder().detectionGas(detectionGas).concentration(concentration).heaterVoltage(heaterVoltage).loadResistance(loadResistance).loopVoltage(loopVoltage).modelNo(modelNo).preheatTime(preheatTimeDate).heaterConsumption(heaterConsumption).sensitivity(sensitivity).sensingResistance(sensingResistance).sensorType(sensorType).standardTestCircuit(standardTestCircut).temHumidity(temHumidity).slope(slope).detectionGas(detectionGas).build();
    }
}
