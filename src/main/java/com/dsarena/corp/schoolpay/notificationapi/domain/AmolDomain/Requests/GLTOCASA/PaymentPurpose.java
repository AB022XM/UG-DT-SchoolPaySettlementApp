package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PaymentPurpose {

    public String narrative;
    public int transactionType;

    public PaymentPurpose(String narrative, int transactionType) {
        this.narrative = narrative;
        this.transactionType = transactionType;
    }


    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }


    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "PaymentPurpose [narrative=" + narrative + ", transactionType=" + transactionType + "]";
    }
}
