package com.bm.fire_emergency_mqtt_backend.services;

import java.util.List;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientInfoService {
    DataResult<DbClientInfo> create(DbClientInfo clientInfo);

    Result delete(int id);

    DataResult<Page<DbClientInfo>> findAll(Pageable pageable);
}
