package com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages;

public class UserRoleMessage {

    private UserRoleMessage() {

    }

    public static final String CREATE_DEFAULT_ROLE = "Default role created for user";
    public static final String CREATE_FAILURE_DEFAULT_ROLE = "Default role could not be created";
    public static final String FIND_DEFAULT_ROLE = "Default role fetched from db";
    public static final String FIND_FAILURE_DEFAULT_ROLE = "Default role could not be fetched";
    public static final String FIND_ALL_USER_ROLE = "User roles fetched";

}
