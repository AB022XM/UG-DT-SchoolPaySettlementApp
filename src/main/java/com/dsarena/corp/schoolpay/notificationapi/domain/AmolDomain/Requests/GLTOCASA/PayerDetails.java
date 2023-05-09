package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PayerDetails {
    public String payerProductInstanceReference;


    public PayerDetails() {
    }

    public PayerDetails(String debitAccount) {
    }



   @Override
    public String toString() {
        return "PayerDetails{" +
                "payerProductInstanceReference='" + payerProductInstanceReference + '\'' +
                '}';
    }

public String getPayerProductInstanceReference() {
    return payerProductInstanceReference;
}

public void setPayerProductInstanceReference(String payerProductInstanceReference) {
    this.payerProductInstanceReference = payerProductInstanceReference;
}
}
