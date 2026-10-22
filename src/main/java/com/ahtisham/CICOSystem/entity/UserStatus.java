package com.ahtisham.CICOSystem.entity;


import com.ahtisham.CICOSystem.exception.IllegalEnumException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.STRING, with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public enum UserStatus {
    DAY_SCHOLAR,
    HOSTELLER,
    GRADUATED,
    ALUMNI,
    EMPLOYEE,
    FACULTY,
    VISITOR;

    @JsonCreator
    public static UserStatus fromString(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return UserStatus.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalEnumException(value + " is not accepted. Allowed: " +
                    Arrays.toString(UserStatus.values()), UserStatus.class.getSimpleName());
        }
    }
}
