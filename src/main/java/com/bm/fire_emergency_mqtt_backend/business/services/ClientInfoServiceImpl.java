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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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

    @Override
    public DataResult<DbClientInfo> findByUserId(int id) {
        List<DbClientInfo> dbClientInfoList = clientInfoDao.findByDbUserId(id);
        return new SuccessDataResult<>(dbClientInfoList.get(dbClientInfoList.size() - 1), LIST_CLIENT_INFO);
    }

}
