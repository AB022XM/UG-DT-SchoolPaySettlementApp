package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

import static com.dsarena.corp.schoolpay.notificationapi.Util.Constants.SALTCHARS;

public class Helper {

    public static Boolean isNullOREmptyORBlank(String stringText) {
        try {
            if (
                stringText.isBlank() || stringText.isEmpty() || stringText.equals(null) || stringText == "" || stringText.equals("")
            ) return true; else return false;
        } catch (Exception e) {
            // TODO: handle exception
            return true;
        }
    }

    public static String limitString(String text, int limit) {
        if (text.length() > limit) return text.substring(0, limit - 1); else return text;
    }

    public static String generationUUID(String params) {
        return null;
    }

    public static String generateRandomString(int length) {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {

            int index = (int) (rnd.nextFloat() * SALTCHARS.length());

            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static String generateRandomNumber(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {

            int index = (int) (rnd.nextFloat() * SALTCHARS.length());

            salt.append(SALTCHARS.charAt(index));
              }
        return salt.toString();
    }

    public static String generateRandomNumber(int length, int min, int max) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {

            int index = (int) (rnd.nextFloat() * SALTCHARS.length());

            salt.append(SALTCHARS.charAt(index));

        }
        return salt.toString();
    }


    public static String Object2String(Object obj) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(obj);

    }


}
