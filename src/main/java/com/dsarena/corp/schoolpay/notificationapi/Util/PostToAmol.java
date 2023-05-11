package com.dsarena.corp.schoolpay.notificationapi.Util;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA.ResponseDetails;
import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Responses.CASATOCASA.AmolResponse;
import com.dsarena.corp.schoolpay.notificationapi.service.dto.NotifyTransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostToAmol {

    private final Logger log = LoggerFactory.getLogger(PostToAmol.class);

    public ResponseDetails postTransaction(NotifyTransactionDTO nt, String debitAccount)
        throws KeyManagementException, NoSuchAlgorithmException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        SSLUtils.turnOffSslChecking();

        HttpHeaders headers = CoreBankingGL2CASA.generateAmolHeaderGL2CASA(nt);
        String json = CoreBankingGL2CASA.generateAmolRequestGL2CASA(nt);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        ResponseEntity<AmolResponse> response = restTemplate.postForEntity(Constants.AMOL_POST_URL, request, AmolResponse.class);

        return new ResponseDetails(response.getBody(), request);
    }

    public ResponseDetails postTransactionGLCASA(NotifyTransactionDTO nt)
        throws KeyManagementException, NoSuchAlgorithmException, JsonProcessingException {
        log.debug("+++++++++++++++++++++++++++++ NEW TRANSACTION TO FCR start++++++++++++++++++");
        log.debug(nt.toString());
        log.debug("+++++++++++++++++++++++++++++ NEW TRANSACTION TO FCR end++++++++++++++++++");

        RestTemplate restTemplate = new RestTemplate();
        SSLUtils.turnOffSslChecking();
        HttpHeaders headers = CoreBankingGL2CASA.generateAmolHeaderGL2CASA(nt);
        String json = CoreBankingGL2CASA.generateAmolRequestGL2CASA(nt);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        log.debug("+++++++++++++++++++++++++++++ NEW REQUEST TO FCR++++++++++++++++++");
        log.debug("REQUEST BODY: \n" + json);
        log.debug("REQUEST BODY ENDS \n");
        log.debug("REQUEST HEADER : \n " + headers.toString() + "\n ENDS");
        log.debug("+++++++++++++++++++++++++++++ NEW REQUEST TO FCR++++++++++++++++++");

        log.debug("\n RECORDID: " + nt.getRecordId() + " TRANSACTIONID " + nt.getTransactionUId() + "\n ###AUTO ID### : " + nt.getId());
        ResponseEntity<AmolResponse> response = restTemplate.postForEntity(Constants.AMOL_POST_URL, request, AmolResponse.class);
        log.debug("+++++++++++++++++++++++++++++ NEW TRANSACTION TO FCR end++++++++++++++++++");

        return new ResponseDetails(response.getBody(), request);
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
