package com.bm.fire_emergency_mqtt_backend.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PageDto<T> {
    private List<T> content;
    private int totalPage;
    private int page;
    private int size;
    private long total;

}
