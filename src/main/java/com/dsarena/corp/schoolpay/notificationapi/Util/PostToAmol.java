package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.AmolPost;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.DateType;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PayeeDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PayerDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PaymentFees;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PaymentMechanism;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PaymentPurpose;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PaymentTax;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolData.PaymentTransaction;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolResponse;
import com.dsarena.corp.schoolpay.notificationapi.domain.NotifyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public class PostToAmol {

    public AmolResponse postOneTransaction(NotifyTransaction nt, String debitAccount)
        throws KeyManagementException, NoSuchAlgorithmException {
        if (Helper.isNullOREmptyORBlank(debitAccount)) {
            debitAccount = "6000086213";
        }
        String creditAccount = nt.getCreditAccount();
        if (Helper.isNullOREmptyORBlank(nt.getCreditAccount())) {
            creditAccount = "6000029414";
        }
        DateType dateType = new DateType("2023-03-28T12:06:46.000Z", "P");
        PayeeDetails pd = new PayeeDetails(38, "", nt.getStudentName(), nt.getCreditAccount(), "");
        PayerDetails ppayerd = new PayerDetails("", 38, "", "", nt.getStudentCode(), debitAccount, "");
        PaymentMechanism pm = new PaymentMechanism("LOCALDIRECTPAYT", "LOCAL");
        PaymentTax pt = new PaymentTax(0, "", "not applicable");
        PaymentFees pf = new PaymentFees(0, "", "Amt: " + nt.getCreditAccount() + " " + nt.getRecordId(), nt.getTransactionUId());
        PaymentPurpose pp = new PaymentPurpose(null, nt.getStudentName(), nt.getStudentCode());
        Double dAmount = Double.parseDouble(nt.getAmount() + "");
        PaymentTransaction paymentTran = new PaymentTransaction(
            dAmount,
            nt.getAmount() + "",
            "UGX",
            "UGX",
            dateType,
            "0.0",
            pd,
            ppayerd,
            pf,
            pm,
            pp,
            pt
        );
        String customerReference = NotifyTransaction.generateUniqueRefString();

        AmolPost amolPost = new AmolPost(customerReference, paymentTran, "IT");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(amolPost);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //  List<NotifyTransaction> notifyTransactionList = getNotPostedTransaction();
        //  for (NotifyTransaction notifyTransaction : notifyTransactionList) {
        //      if (!notifyTransaction.getFcrTransactionStatus().equals("PENDING")) {
        //          log.info("Not posted transaction: " + notifyTransaction.toString());
        //          return null;
        //      }
        //  }
        RestTemplate restTemplate = new RestTemplate();
        SSLUtils.turnOffSslChecking();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        // interceptors.add(new LoggingRequestInterceptor());
        // restTemplate.setInterceptors(interceptors);
        String AMOL_POST_URL =
            "https://payment-initiation-domain-v2-cit-ug.amol-api.roanprd-openshift.intra.absa.co.za/v2/payment-initiation/payment-initiation-transaction/fund-transfers/domestic/initiation";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Business-Id", " UGBRB");
        headers.add("System-Id", " WUG");
        headers.add("Correlation-Id", " 05047554-e601-40bd-9674-e6d3d8e00c3f");
        headers.add("ConsumerUniqueReference-Id", " 345638326326524");
        headers.add("Staff-Id", " IFE");
        headers.add("Country-Code", " UG");
        HttpEntity<String> request = new HttpEntity<String>(json, headers);

        ResponseEntity<AmolResponse> response = restTemplate.postForEntity(AMOL_POST_URL, request, AmolResponse.class);

        return response.getBody();
    }
}
