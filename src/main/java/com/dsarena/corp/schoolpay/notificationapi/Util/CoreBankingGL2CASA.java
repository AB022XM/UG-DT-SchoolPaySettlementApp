package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.AmolPostGLTOCASA;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.PayeeDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.PayerDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.PaymentMechanism;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.PaymentPurpose;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA.PaymentTransaction;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.NotifyTransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CoreBankingGL2CASA {

    private static final Logger log = LoggerFactory.getLogger(CoreBankingGL2CASA.class);

    public static String generateAmolRequestGL2CASA(NotifyTransactionDTO nt) throws JsonProcessingException {
        String narrative = nt.getRecordId() + "| " + nt.getStudentCode() + "| " + nt.getStudentName();

        AmolPostGLTOCASA amolPost = new AmolPostGLTOCASA();
        PaymentTransaction paymentTransaction = new PaymentTransaction();

        PaymentPurpose pp = new PaymentPurpose(Helper.truncate(narrative, 40), 0);
        PayeeDetails pd = new PayeeDetails();
        pd.setPayeeProductInstanceReference(nt.getCreditAccount());
        PayerDetails payer = new PayerDetails();
        payer.setPayerProductInstanceReference(nt.getDebitAccount());
        PaymentMechanism pm = new PaymentMechanism(Constants.GLTOCASA, Constants.LOCAL);

        paymentTransaction.setCreditCurrency(Constants.UGX);
        paymentTransaction.setCreditAmount(nt.getAmount());
        paymentTransaction.setPayeeDetails(pd);
        paymentTransaction.setPayerDetails(payer);
        paymentTransaction.setPaymentMechanism(pm);
        paymentTransaction.setPaymentPurpose(pp);
        amolPost.setPaymentTransaction(paymentTransaction);

        return Helper.Object2String(amolPost);
    }

    public static HttpHeaders generateAmolHeaderGL2CASA(NotifyTransactionDTO nt) {
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
