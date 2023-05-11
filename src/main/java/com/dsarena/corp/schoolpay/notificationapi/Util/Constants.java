package com.dsarena.corp.schoolpay.notificationapi.Util;

public class Constants {

    public static final String AMOL_POST_URL =
        "https://payment-initiation-domain-v2-cit-ug.amol-api.roanprd-openshift.intra.absa.co.za/v2/payment-initiation/payment-initiation-transaction/fund-transfers/domestic/initiation";

    public static String UGX = "UGX";

    public static String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String LOCAL = "LOCAL";

    public static String LOCALDIRECTPAYT = "LOCALDIRECTPAYT";

    public static String GLTOCASA = "GLTOCASA";

    public static String SUCCESS = "Success";

    public static String FAILED = "Failed";

    public static String LOCAL_DATE_TIME_FORMART_AMOL = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]Z";
    public static final String LOCAL_DATE_TIME_FORMART[] = { "yyyy-MM-dd'T'HH:mm:ss" };
}
