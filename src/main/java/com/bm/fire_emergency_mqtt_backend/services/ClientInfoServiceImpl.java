package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dataAccess.abstracts.ClientInfoDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    private final ClientInfoDao clientInfoDao;

    public ClientInfoServiceImpl(ClientInfoDao clientInfoDao) {
        this.clientInfoDao = clientInfoDao;
    }

    @Override
    public DataResult<DbClientInfo> create(DbClientInfo entity) {
        DbClientInfo dbClientInfo = clientInfoDao.save(entity);
        return new SuccessDataResult<>(dbClientInfo, ClientInfoMessages.CREATE_CLIENT_INFO);
    }

    @SneakyThrows
    @Override
    public DataResult<DbClientInfo> update(DbClientInfo entity, int id)  {
        throw new Exception("method unimplemented");
    }

    @SneakyThrows
    @Override
    public Result delete(int id) {
        throw new Exception("method unimplemented");
    }
}
