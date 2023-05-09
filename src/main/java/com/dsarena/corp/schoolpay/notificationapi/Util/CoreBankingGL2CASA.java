package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.*;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CoreBankingGL2CASA {

    public static String generateAmolRequestGL2CASA(NotifyTransaction nt, String debitAccount) throws JsonProcessingException {
        String narrative = nt.getSourcePaymentChannelCode() + " | " + nt.getRecordId() + " | " + nt.getStudentCode();

        PaymentPurpose pp = new PaymentPurpose(narrative, 0);
        PayeeDetails pd = new PayeeDetails(nt.getCreditAccount());
        PayerDetails payer = new PayerDetails(debitAccount);
        PaymentMechanism pm = new PaymentMechanism(Constants.GLTOCASA, Constants.LOCAL);

        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setCreditCurrency(Constants.UGX);
        paymentTransaction.setCreditAmount(nt.getAmount());
        paymentTransaction.setPayeeDetails(pd);
        paymentTransaction.setPayerDetails(payer);
        paymentTransaction.setPaymentMechanism(pm);
        paymentTransaction.setPaymentPurpose(pp);
        AmolPostGLTOCASA amolPost = new AmolPostGLTOCASA();
        amolPost.setPaymentTransaction(paymentTransaction);

        return Helper.Object2String(amolPost);
    }

    public static HttpHeaders generateAmolHeaderGL2CASA(NotifyTransaction nt) {
        String CorrectionId = UUIDUtil.generationUUID(
            String.valueOf(nt.getRecordId()) + nt.getTransactionUId() + String.valueOf(nt.getAmount()) + nt.getTransactionUId()
        );
        String customerUniqueReference = Helper.generateRandomNumber(11);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Business-Id", "UGBRB");
        headers.add("System-Id", "WUG");
        headers.add("Correlation-Id", " 05047554-e601-40bd-9674-e6d3d8e00c3f");
        headers.add("ConsumerUniqueReference-Id", "345638326326524");
        headers.add("Staff-Id", "IFE");
        headers.add("Country-Code", "UG");
        return headers;
    }
}
