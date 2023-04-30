package com.dsarena.corp.schoolpay.notificationapi.domain.Responses;

public class NotificationResponse {

    public String amountSettled;
    public int recordId;
    public String settlementReference;
    public String settlementResultMessage;
    public boolean settlementSuccessful;

    public NotificationResponse(
        String amountSettled,
        int recordId,
        String settlementReference,
        String settlementResultMessage,
        boolean settlementSuccessful
    ) {
        this.amountSettled = amountSettled;
        this.recordId = recordId;
        this.settlementReference = settlementReference;
        this.settlementResultMessage = settlementResultMessage;
        this.settlementSuccessful = settlementSuccessful;
    }

    public String getAmountSettled() {
        return amountSettled;
    }

    public void setAmountSettled(String amountSettled) {
        this.amountSettled = amountSettled;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getSettlementReference() {
        return settlementReference;
    }

    public void setSettlementReference(String settlementReference) {
        this.settlementReference = settlementReference;
    }

    public String getSettlementResultMessage() {
        return settlementResultMessage;
    }

    public void setSettlementResultMessage(String settlementResultMessage) {
        this.settlementResultMessage = settlementResultMessage;
    }

    public boolean isSettlementSuccessful() {
        return settlementSuccessful;
    }

    public void setSettlementSuccessful(boolean settlementSuccessful) {
        this.settlementSuccessful = settlementSuccessful;
    }

    @Override
    public String toString() {
        return (
            "NotificationResponse{" +
            "amountSettled='" +
            amountSettled +
            '\'' +
            ", recordId=" +
            recordId +
            ", settlementReference='" +
            settlementReference +
            '\'' +
            ", settlementResultMessage='" +
            settlementResultMessage +
            '\'' +
            ", settlementSuccessful=" +
            settlementSuccessful +
            '}'
        );
    }
}
