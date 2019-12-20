package com.indigital.client.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class WiremockUtil {

    public static String obtainResource(String resource) {
        InputStream inputStream = WiremockUtil.class.getClassLoader().getResourceAsStream(resource);
        try {
            return IOUtils.toString(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertResponseTo(String response, Class<T> t) {
        T result;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.readValue(response, t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
