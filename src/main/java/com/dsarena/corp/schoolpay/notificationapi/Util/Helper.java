package com.dsarena.corp.schoolpay.notificationapi.Util;

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
}
