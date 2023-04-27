package com.dsarena.corp.schoolpay.notificationapi.service.dto;

import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.dsarena.corp.schoolpay.notificationapi.domain.NotifyTransaction} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NotifyTransactionDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer transactionUId;

    @NotNull
    private Integer recordId;

    @NotNull
    private String customerPaymentCode;

    @NotNull
    private String schoolName;

    @NotNull
    private String sourcePaymentChannelCode;

    @NotNull
    private String schoolpayReceiptNumber;

    @NotNull
    private Integer amount;

    private String schoolCode;

    @NotNull
    private String partnerCode;

    @NotNull
    private LocalDate dateCreated;

    @NotNull
    private Integer sourceTransactionId;

    @NotNull
    private Integer studentCode;

    @NotNull
    private String studentName;

    private Integer charges;

    @NotNull
    private LocalDate timestamp;

    @NotNull
    private String narration;

    @NotNull
    private Integer currency;

    @NotNull
    private Integer debitAccount;

    @NotNull
    private Integer creditAccount;

    private ProccesingStatus proccessingStatus;

    private ProccesingStatus fcrTransactionStatus;

    private String fcrTransactionId;

    private String fcrTransactionReference;

    private String freeField1;

    private String freeField2;

    private String freeField3;

    @Max(value = 5)
    private Integer retries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTransactionUId() {
        return transactionUId;
    }

    public void setTransactionUId(Integer transactionUId) {
        this.transactionUId = transactionUId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCustomerPaymentCode() {
        return customerPaymentCode;
    }

    public void setCustomerPaymentCode(String customerPaymentCode) {
        this.customerPaymentCode = customerPaymentCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSourcePaymentChannelCode() {
        return sourcePaymentChannelCode;
    }

    public void setSourcePaymentChannelCode(String sourcePaymentChannelCode) {
        this.sourcePaymentChannelCode = sourcePaymentChannelCode;
    }

    public String getSchoolpayReceiptNumber() {
        return schoolpayReceiptNumber;
    }

    public void setSchoolpayReceiptNumber(String schoolpayReceiptNumber) {
        this.schoolpayReceiptNumber = schoolpayReceiptNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getSourceTransactionId() {
        return sourceTransactionId;
    }

    public void setSourceTransactionId(Integer sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public Integer getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(Integer debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Integer getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Integer creditAccount) {
        this.creditAccount = creditAccount;
    }

    public ProccesingStatus getProccessingStatus() {
        return proccessingStatus;
    }

    public void setProccessingStatus(ProccesingStatus proccessingStatus) {
        this.proccessingStatus = proccessingStatus;
    }

    public ProccesingStatus getFcrTransactionStatus() {
        return fcrTransactionStatus;
    }

    public void setFcrTransactionStatus(ProccesingStatus fcrTransactionStatus) {
        this.fcrTransactionStatus = fcrTransactionStatus;
    }

    public String getFcrTransactionId() {
        return fcrTransactionId;
    }

    public void setFcrTransactionId(String fcrTransactionId) {
        this.fcrTransactionId = fcrTransactionId;
    }

    public String getFcrTransactionReference() {
        return fcrTransactionReference;
    }

    public void setFcrTransactionReference(String fcrTransactionReference) {
        this.fcrTransactionReference = fcrTransactionReference;
    }

    public String getFreeField1() {
        return freeField1;
    }

    public void setFreeField1(String freeField1) {
        this.freeField1 = freeField1;
    }

    public String getFreeField2() {
        return freeField2;
    }

    public void setFreeField2(String freeField2) {
        this.freeField2 = freeField2;
    }

    public String getFreeField3() {
        return freeField3;
    }

    public void setFreeField3(String freeField3) {
        this.freeField3 = freeField3;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NotifyTransactionDTO)) {
            return false;
        }

        NotifyTransactionDTO notifyTransactionDTO = (NotifyTransactionDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, notifyTransactionDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NotifyTransactionDTO{" +
            "id=" + getId() +
            ", transactionUId=" + getTransactionUId() +
            ", recordId=" + getRecordId() +
            ", customerPaymentCode='" + getCustomerPaymentCode() + "'" +
            ", schoolName='" + getSchoolName() + "'" +
            ", sourcePaymentChannelCode='" + getSourcePaymentChannelCode() + "'" +
            ", schoolpayReceiptNumber='" + getSchoolpayReceiptNumber() + "'" +
            ", amount=" + getAmount() +
            ", schoolCode='" + getSchoolCode() + "'" +
            ", partnerCode='" + getPartnerCode() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", sourceTransactionId=" + getSourceTransactionId() +
            ", studentCode=" + getStudentCode() +
            ", studentName='" + getStudentName() + "'" +
            ", charges=" + getCharges() +
            ", timestamp='" + getTimestamp() + "'" +
            ", narration='" + getNarration() + "'" +
            ", currency=" + getCurrency() +
            ", debitAccount=" + getDebitAccount() +
            ", creditAccount=" + getCreditAccount() +
            ", proccessingStatus='" + getProccessingStatus() + "'" +
            ", fcrTransactionStatus='" + getFcrTransactionStatus() + "'" +
            ", fcrTransactionId='" + getFcrTransactionId() + "'" +
            ", fcrTransactionReference='" + getFcrTransactionReference() + "'" +
            ", freeField1='" + getFreeField1() + "'" +
            ", freeField2='" + getFreeField2() + "'" +
            ", freeField3='" + getFreeField3() + "'" +
            ", retries=" + getRetries() +
            "}";
    }
}
