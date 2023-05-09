package com.dsarena.corp.schoolpay.notificationapi.Util;


import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA.*;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class CoreBankingCASA2CASA {



    public static String generateAmolRequestCASA2CASA(NotifyTransaction nt, String debitAccount)
            throws KeyManagementException, NoSuchAlgorithmException {
        DateType dateType = new DateType("2023-03-28T12:06:46.000Z", "P");
        PayeeDetails pd = new PayeeDetails(38, "", nt.getStudentName(), nt.getCreditAccount(), "");
        PayerDetails payer = new PayerDetails("", 38, "", "", nt.getStudentCode(), debitAccount, "");
        PaymentMechanism pm = new PaymentMechanism("LOCALDIRECTPAYT", "LOCAL");
        PaymentTax pt = new PaymentTax(0, "", "not applicable");
        PaymentFees pf = new PaymentFees(0, "", "Amt: " + nt.getCreditAccount() + " " + nt.getRecordId(), nt.getTransactionUId());
        PaymentPurpose pp = new PaymentPurpose(null, nt.getStudentName(), nt.getStudentCode());
        Double dAmount = Double.parseDouble(String.valueOf(nt.getAmount()));
        PaymentTransaction paymentTran = new PaymentTransaction(
                dAmount,
                String.valueOf(nt.getAmount()),
                "UGX",
                "UGX",
                dateType,
                "0.0",
                pd,
                payer,
                pf,
                pm,
                pp,
                pt
        );
        String customerReference = NotifyTransaction.generateUniqueRefString();

        AmolPostCASATOCASA amolPost = new AmolPostCASATOCASA(customerReference, paymentTran, "IT");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(amolPost);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }




}
