package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA;

import com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Responses.CASATOCASA.AmolResponse;
import org.springframework.http.HttpEntity;

public class ResponseDetails {
    AmolResponse amolResponse;
   HttpEntity<String> request;

   public ResponseDetails(AmolResponse amolResponse,HttpEntity<String> request){
       this.amolResponse = amolResponse;
       this.request = request;
   }

   public AmolResponse getAmolResponse(){
       return amolResponse;
   }

   public HttpEntity<String> getRequest(){
       return request;
   }

   public void setAmolResponse(AmolResponse amolResponse){
       this.amolResponse = amolResponse;
   }

   public void setRequest(HttpEntity<String> request){
       this.request = request;


   }



}
