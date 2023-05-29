package com.dsarena.corp.schoolpay.notificationapi.Util;

import static com.dsarena.corp.schoolpay.notificationapi.Util.Constants.SALTCHARS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;

public class Helper {

    public static String TranIdGen() {
        Long randpmNum = generateRandomLong(5);
        long time = System.currentTimeMillis() / 1000;

        return (randpmNum + time) + "";
    }

    public static Boolean isNullOREmptyORBlank(String stringText) {
        try {
            if (
                stringText.isBlank() || stringText.isEmpty() || stringText.equals(null) || stringText == "" || stringText.equals("")
            ) return true; else return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static String truncate(String str, int len) {
        if (str == null) return "";

        String crop = str;
        int slen = 0;
        int blen = 0;
        char c;

        try {
            while (blen + 1 <= len) {
                c = crop.charAt(slen);
                blen++;
                slen++;
                if (c > 127) blen++; //2-byte character..
            }
            crop = crop.substring(0, slen);
        } catch (Exception e) {
            //           logger.error("StringTool.cropByte() :::"+ e.toString());
        }

        return crop;
    }

    public static long generateRandomLong(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
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
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());

            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static String Object2String(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(obj);
    }
}
