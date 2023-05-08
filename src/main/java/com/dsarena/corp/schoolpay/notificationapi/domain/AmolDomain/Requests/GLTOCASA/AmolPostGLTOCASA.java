package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class AmolPostGLTOCASA {

    public PaymentTransaction paymentTransaction;

    public AmolPostGLTOCASA(PaymentTransaction paymentTransaction) {
        super();
    }


    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }


}
