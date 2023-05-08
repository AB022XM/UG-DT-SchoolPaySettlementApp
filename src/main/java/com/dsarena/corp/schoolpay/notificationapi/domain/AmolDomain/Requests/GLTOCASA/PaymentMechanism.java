package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.GLTOCASA;

public class PaymentMechanism {
    public String subCategoryCode;
    public String transactionCategoryCode;

    public PaymentMechanism(String subCategoryCode, String transactionCategoryCode) {
        this.subCategoryCode = subCategoryCode;
        this.transactionCategoryCode = transactionCategoryCode;
    }



    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }


    public String getTransactionCategoryCode() {
        return transactionCategoryCode;
    }

    public void setTransactionCategoryCode(String transactionCategoryCode) {
        this.transactionCategoryCode = transactionCategoryCode;
    }

    @Override
    public String toString() {
        return "PaymentMechanism{" +
                "subCategoryCode='" + subCategoryCode + '\'' +
                ", transactionCategoryCode='" + transactionCategoryCode + '\'' +
                '}';
    }

}
