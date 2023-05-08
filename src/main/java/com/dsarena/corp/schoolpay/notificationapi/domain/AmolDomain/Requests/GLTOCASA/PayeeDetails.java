package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PayeeDetails {

    public String payeeProductInstanceReference;


    public PayeeDetails(String creditAccount) {
    }

    public PayeeDetails() {
    }

    public String getPayeeProductInstanceReference() {
        return payeeProductInstanceReference;
    }

    public void setPayeeProductInstanceReference(String payeeProductInstanceReference) {
        this.payeeProductInstanceReference = payeeProductInstanceReference;
    }


}
