package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA.ResponseDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Responses.CASATOCASA.AmolResponse;
import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class PostToAmol {


    public ResponseDetails postTransaction(NotifyTransaction nt, String debitAccount)
            throws KeyManagementException, NoSuchAlgorithmException, JsonProcessingException {


        RestTemplate  restTemplate = new RestTemplate();
        SSLUtils.turnOffSslChecking();

        HttpHeaders headers = CoreBankingGL2CASA.generateAmolHeaderGL2CASA(nt);
        String json= CoreBankingGL2CASA.generateAmolRequestGL2CASA(nt,debitAccount);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<AmolResponse> response = restTemplate.postForEntity(Constants.AMOL_POST_URL, request, AmolResponse.class);

        return new ResponseDetails(response.getBody(),request);
    }

    public ResponseDetails postTransactionGLCASA(NotifyTransaction nt, String debitAccount)
            throws KeyManagementException, NoSuchAlgorithmException, JsonProcessingException {


        RestTemplate  restTemplate = new RestTemplate();
        SSLUtils.turnOffSslChecking();

        HttpHeaders headers = CoreBankingGL2CASA.generateAmolHeaderGL2CASA(nt);
        String json= CoreBankingGL2CASA.generateAmolRequestGL2CASA(nt,debitAccount);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<AmolResponse> response = restTemplate.postForEntity(Constants.AMOL_POST_URL, request, AmolResponse.class);

        return new ResponseDetails(response.getBody(),request);
    }



/*    public  void  postTransactionToAmol(NotifyTransaction savedNotifyTransaction, School school) throws NoSuchAlgorithmException, KeyManagementException {

        ResponseDetails amolRespDetails = new PostToAmol().postOneTransaction(savedNotifyTransaction, school.getSchoolAccountNumber());
        AmolResponse amolResp = amolRespDetails.getAmolResponse();
        HttpEntity<String> request= amolRespDetails.getRequest();
        if (amolResp != null) {
            if (amolResp.getStatus().equalsIgnoreCase(ProccesingStatus.SUCCESS.name())) {
                savedNotifyTransaction.setFcrTransactionStatus(ProccesingStatus.SUCCESS);

            } else {
                savedNotifyTransaction.fcrTransactionStatus(ProccesingStatus.FAILED);
            }

            if(amolResp.getData() != null)
            {
                savedNotifyTransaction.setFcrTransactionId(amolResp.getData().getTransferReferenceId());
                savedNotifyTransaction.setTransactionUId(amolResp.getData().getTransferId());
            }
            savedNotifyTransaction.setFreeField2(Objects.requireNonNull(request.getHeaders().get("Correlation-Id" +
                    " " + request.getHeaders().get("ConsumerUniqueReference-Id"))).toString());
        }
    }*/
}
