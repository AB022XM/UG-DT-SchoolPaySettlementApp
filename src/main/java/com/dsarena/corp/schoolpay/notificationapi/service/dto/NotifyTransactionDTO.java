package com.dsarena.corp.schoolpay.notificationapi.service.dto;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.NotifyTransaction;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * A DTO for the {@link NotifyTransaction} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NotifyTransactionDTO implements Serializable {

    @JsonIgnore
    private Long id;

    @Nullable
    private String transactionUId;

    private Integer recordId;

    @Nullable
    @JsonIgnore
    private String customerPaymentCode;

    @Nullable
    private String schoolName;

    @Nullable
    private String sourcePaymentChannelCode;

    @NotNull
    private String schoolpayReceiptNumber;

    @NotNull
    private Integer amount;

    @Nullable
    private String schoolCode;

    @Nullable
    @JsonIgnore
    private String partnerCode;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")

    @NotNull
    private LocalDate dateCreated;

    @NotNull
    private String sourceTransactionId;

    @NotNull
    private String studentCode;

    @NotNull
    private String studentName;

    @Nullable
    @JsonIgnore
    private Integer charges = 0;

    @Nullable
    @JsonIgnore
    private LocalDateTime timestamp;

    @Nullable
    @JsonIgnore
    private String narration;

    @Nullable
    private String currency;

    @Nullable
    private String debitAccount;

    @Nullable
    private String creditAccount;

    private ProccesingStatus proccessingStatus;

    private ProccesingStatus fcrTransactionStatus;

    private String fcrTransactionId;

    private String fcrTransactionReference;

    private String freeField1;

    private String freeField2;

    private String freeField3;

    @Max(value = 5)
    private Integer retries = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionUId() {
        return transactionUId;
    }

    public void setTransactionUId(String transactionUId) {
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

    public LocalDateTime getDateCreated() {
        return LocalDateTime.now();
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSourceTransactionId() {
        return sourceTransactionId;
    }

    public void setSourceTransactionId(String sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
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

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = "UGX";
    }

    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
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
