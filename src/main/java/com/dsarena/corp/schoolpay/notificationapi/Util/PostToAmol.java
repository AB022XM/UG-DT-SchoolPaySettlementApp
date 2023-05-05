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
        PayeeDetails pd = new PayeeDetails("null", "", nt.getStudentName(), nt.getCreditAccount(), "");
        PayerDetails ppayerd = new PayerDetails("", null, "", "", nt.getStudentCode(), debitAccount, "");
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
        String customerReference = nt.getTransactionUId() + nt.getRecordId();
        AmolPost amolPost = new AmolPost(customerReference.substring(11, 0), paymentTran, "IT");

        //     "400 Bad Request: \"{\"code\":\"400\",\"data\":null,\"message\":\"branchId must have minimum 1 and maximum 3 digits,payerProductInstanceReference cannot be null or empty,customerReference cannot be less than 9 characters and more than 12 characters,branchId must be numeric,payeeProductInstanceReference must be numeric\",\"sourceInfo\":null,\"status\":\"Failure\"}\"",
        //    // String,nt.getTransactionUId(),nt.getAmount(),
        //  nt.getAmount(),debitAccount,creditAccount,nt.getStudentName(),debitAccount,narration,nt.getTransactionUId(),narration,narration,nt.getStudentName() );
        //  String json = "{\"customerReference"+":\"87654345678\"+",\"paymentTransaction\":{\"debitAmount\":8654.0,\"creditAmount\":\"6000\",\"debitCurrency\":\"UGX\",\"creditCurrency\":\"UGX\",\"dateType\":{\"date\":\"2023-03-28T12:06:46.000Z\",\"type\":\"P\"},\"fxRate\":\"0\",\"payeeDetails\":{\"branchId\":\"\",\"cardNumber\":\"\",\"counterPartyName\":\"NTINDA\",\"payeeProductInstanceReference\":\"6000029414\",\"productTypeCode\":\"\"},\"payerDetails\":{\"bankCode\":\"\",\"branchId\":\"\",\"cardExpiryDate\":\"\",\"cardNumber\":\"\",\"originatorName\":\"NTINDA\",\"payerProductInstanceReference\":\"6000086213\",\"productTypeCode\":\"\"},\"paymentFees\":{\"feeAmount\":0,\"feeGLAccount\":\"\",\"feeNarration\":\"AIRTELUG NTINDA  6000 34365432\",\"transactionReferenceNumber\":\"34365432\"},\"paymentMechanism\":{\"subCategoryCode\":\"LOCALDIRECTPAYT\",\"transactionCategoryCode\":\"LOCAL\"},\"paymentPurpose\":{\"checkerId\":null,\"narrative\":\"AIRTELUG NTINDA  6000 34365432\",\"remittanceInformation\":\"NTINDA\"},\"paymentTax\":{\"taxAmount\":0,\"taxGLAccount\":\"\",\"taxNarration\":\"\"}},\"paymentTransactionType\":\"IT\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(amolPost);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
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
