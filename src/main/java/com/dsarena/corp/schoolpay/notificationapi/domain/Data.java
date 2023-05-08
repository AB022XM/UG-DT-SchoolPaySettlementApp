package com.dsarena.corp.schoolpay.notificationapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("transferId")
    public String getTransferId() {
        return this.transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    String transferId;

    @JsonProperty("transferReferenceId")
    public String getTransferReferenceId() {
        return this.transferReferenceId;
    }

    public void setTransferReferenceId(String transferReferenceId) {
        this.transferReferenceId = transferReferenceId;
    }

    String transferReferenceId;

    @JsonProperty("transferStatus")
    public String getTransferStatus() {
        return this.transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    String transferStatus;
}
