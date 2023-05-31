package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.NotificationDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbNotification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class
NotificationServiceImpl implements NotificationService {

    private NotificationDao notificationDao;

    public NotificationServiceImpl(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public DataResult<DbNotification> add(DbNotification dbNotification) {
        ;
        return new SuccessDataResult<>(
                notificationDao.save(dbNotification),
                ""
        );
    }

    @Override
    public DataResult<List<DbNotification>> findAllByUserId(int userId) {
        return null;
    }

    @Override
    public DataResult<List<DbNotification>> findAllByCardId(int cardId) {
        return null;
    }
}
