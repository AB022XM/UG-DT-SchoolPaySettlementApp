package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PayerDetails {
    public String payerProductInstanceReference;


    public PayerDetails() {
    }

    public PayerDetails(String debitAccount) {
    }


    public String payerProductInstanceReference() {
        return this.payerProductInstanceReference;
    }

    public void payerProductInstanceReference(String payerProductInstanceReference) {
        this.payerProductInstanceReference = payerProductInstanceReference;
    }


   @Override
    public String toString() {
        return "PayerDetails{" +
                "payerProductInstanceReference='" + payerProductInstanceReference + '\'' +
                '}';
    }
}
