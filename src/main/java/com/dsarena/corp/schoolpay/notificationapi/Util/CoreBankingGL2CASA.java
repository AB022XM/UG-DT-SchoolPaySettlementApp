package com.dsarena.corp.schoolpay.notificationapi.Util;


import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.*;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CoreBankingGL2CASA {

    public static String generateAmolRequestGL2CASA(NotifyTransaction nt, String debitAccount) throws JsonProcessingException {
        PaymentTransaction paymentTransaction= new PaymentTransaction();

        PayeeDetails pd = new PayeeDetails(nt.getCreditAccount());
        PayerDetails payer = new PayerDetails(debitAccount);
        PaymentMechanism pm = new PaymentMechanism(Constants.LOCALDIRECTPAYT, Constants.LOCAL);
        String narrative=nt.getSchoolCode()+nt.getRecordId()+nt.getAmount()+nt.getTransactionUId();
        paymentTransaction.setPayeeDetails(pd);
        paymentTransaction.setPayerDetails(payer);
        paymentTransaction.setPaymentMechanism(pm);
        paymentTransaction.setCreditAmount(nt.getAmount());
        PaymentPurpose pp = new PaymentPurpose(narrative,0);
        paymentTransaction.setPaymentPurpose(pp);
        AmolPostGLTOCASA amolPost = new AmolPostGLTOCASA(paymentTransaction);


        return Helper.Object2String(amolPost);
    }


    public static HttpHeaders generateAmolHeaderGL2CASA(NotifyTransaction nt ) {
        String CorrectionId=UUIDUtil.generationUUID(nt.getRecordId() +
                nt.getTransactionUId() + nt.getAmount() + nt.getTransactionUId());
        String customerUniqueReference=Helper.generateRandomNumber(11);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Business-Id", "UGBRB");
        headers.add("System-Id", "WUG");
        headers.add("Correlation-Id", CorrectionId);
        headers.add("ConsumerUniqueReference-Id", customerUniqueReference);
        headers.add("Staff-Id", "IFE");
        headers.add("Country-Code", "UG");
        return headers;
    }

}
