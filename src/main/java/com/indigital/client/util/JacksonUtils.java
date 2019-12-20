package com.indigital.client.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JacksonUtils {
    public static String getObjectAsString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (IOException e) {
            log.error("can't convert object to string: " + e.getMessage(), e);
            return null;
        }
    }

}
