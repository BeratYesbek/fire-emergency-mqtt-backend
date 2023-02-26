package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ClientInfoDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages.*;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    private final ClientInfoDao clientInfoDao;

    public ClientInfoServiceImpl(ClientInfoDao clientInfoDao) {
        this.clientInfoDao = clientInfoDao;
    }

    @Override
    public DataResult<DbClientInfo> create(DbClientInfo dbClientInfo) {
        DbClientInfo addedDdClientInfo = clientInfoDao.save(dbClientInfo);
        return new SuccessDataResult<>(addedDdClientInfo, CREATE_CLIENT_INFO);
    }

    @Override
    public Result delete(int id) {
        clientInfoDao.deleteById(id);
        return new SuccessResult(DELETE_CLIENT_INFO);
    }

    @Override
    public DataResult<Page<DbClientInfo>> findAll(Pageable pageable) {
        return new SuccessDataResult<>(clientInfoDao.findAll(pageable), LIST_CLIENT_INFO);
    }

}
