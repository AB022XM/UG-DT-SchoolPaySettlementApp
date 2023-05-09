package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PaymentTransaction {

    public int creditAmount;
    public String creditCurrency;
    public PayeeDetails payeeDetails;
    public PayerDetails payerDetails;
    public PaymentMechanism paymentMechanism;
    public PaymentPurpose paymentPurpose;

    public PaymentTransaction() {}

    /**
     * get field
     *
     * @return creditAmount
     */
    public int getCreditAmount() {
        return this.creditAmount;
    }

    /**
     * set field
     *
     * @param creditAmount
     */
    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * get field
     *
     * @return creditCurrency
     */
    public String getCreditCurrency() {
        return this.creditCurrency;
    }

    /**
     * set field
     *
     * @param creditCurrency
     */
    public void setCreditCurrency(String creditCurrency) {
        this.creditCurrency = creditCurrency;
    }

    /**
     * get field
     *
     * @return payeeDetails
     */
    public PayeeDetails getPayeeDetails() {
        return this.payeeDetails;
    }

    /**
     * set field
     *
     * @param payeeDetails
     */
    public void setPayeeDetails(PayeeDetails payeeDetails) {
        this.payeeDetails = payeeDetails;
    }

    /**
     * get field
     *
     * @return payerDetails
     */
    public PayerDetails getPayerDetails() {
        return this.payerDetails;
    }

    /**
     * set field
     *
     * @param payerDetails
     */
    public void setPayerDetails(PayerDetails payerDetails) {
        this.payerDetails = payerDetails;
    }

    /**
     * get field
     *
     * @return paymentMechanism
     */
    public PaymentMechanism getPaymentMechanism() {
        return this.paymentMechanism;
    }

    /**
     * set field
     *
     * @param paymentMechanism
     */
    public void setPaymentMechanism(PaymentMechanism paymentMechanism) {
        this.paymentMechanism = paymentMechanism;
    }

    /**
     * get field
     *
     * @return paymentPurpose
     */
    public PaymentPurpose getPaymentPurpose() {
        return this.paymentPurpose;
    }

    /**
     * set field
     *
     * @param paymentPurpose
     */
    public void setPaymentPurpose(PaymentPurpose paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }
}
