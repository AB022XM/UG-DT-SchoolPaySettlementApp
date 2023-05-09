package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Responses.GLTOCASA;

public class Data {
    public String transferId;
    public String transferStatus;

    public String getTransferId() {
        return transferId;
    }
    public void setTransferId(String transferId) {
        this.transferId = transferId;

    }

    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return "Data [transferId=" + transferId + ", transferStatus=" + transferStatus + "]";
    }
}
