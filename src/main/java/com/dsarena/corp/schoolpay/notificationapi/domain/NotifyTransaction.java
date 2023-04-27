package com.dsarena.corp.schoolpay.notificationapi.domain;

import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A NotifyTransaction.
 */
@Entity
@Table(name = "notify_transaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NotifyTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "transaction_u_id", nullable = false, unique = true)
    private Integer transactionUId;

    @NotNull
    @Column(name = "record_id", nullable = false, unique = true)
    private Integer recordId;

    @NotNull
    @Column(name = "customer_payment_code", nullable = false)
    private String customerPaymentCode;

    @NotNull
    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @NotNull
    @Column(name = "source_payment_channel_code", nullable = false)
    private String sourcePaymentChannelCode;

    @NotNull
    @Column(name = "schoolpay_receipt_number", nullable = false)
    private String schoolpayReceiptNumber;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "school_code")
    private String schoolCode;

    @NotNull
    @Column(name = "partner_code", nullable = false)
    private String partnerCode;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @NotNull
    @Column(name = "source_transaction_id", nullable = false)
    private Integer sourceTransactionId;

    @NotNull
    @Column(name = "student_code", nullable = false)
    private Integer studentCode;

    @NotNull
    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "charges")
    private Integer charges;

    @NotNull
    @Column(name = "timestamp", nullable = false)
    private LocalDate timestamp;

    @NotNull
    @Column(name = "narration", nullable = false)
    private String narration;

    @NotNull
    @Column(name = "currency", nullable = false)
    private Integer currency;

    @NotNull
    @Column(name = "debit_account", nullable = false)
    private Integer debitAccount;

    @NotNull
    @Column(name = "credit_account", nullable = false)
    private Integer creditAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "proccessing_status")
    private ProccesingStatus proccessingStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "fcr_transaction_status")
    private ProccesingStatus fcrTransactionStatus;

    @Column(name = "fcr_transaction_id")
    private String fcrTransactionId;

    @Column(name = "fcr_transaction_reference")
    private String fcrTransactionReference;

    @Column(name = "free_field_1")
    private String freeField1;

    @Column(name = "free_field_2")
    private String freeField2;

    @Column(name = "free_field_3")
    private String freeField3;

    @Max(value = 5)
    @Column(name = "retries")
    private Integer retries;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public NotifyTransaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTransactionUId() {
        return this.transactionUId;
    }

    public NotifyTransaction transactionUId(Integer transactionUId) {
        this.setTransactionUId(transactionUId);
        return this;
    }

    public void setTransactionUId(Integer transactionUId) {
        this.transactionUId = transactionUId;
    }

    public Integer getRecordId() {
        return this.recordId;
    }

    public NotifyTransaction recordId(Integer recordId) {
        this.setRecordId(recordId);
        return this;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCustomerPaymentCode() {
        return this.customerPaymentCode;
    }

    public NotifyTransaction customerPaymentCode(String customerPaymentCode) {
        this.setCustomerPaymentCode(customerPaymentCode);
        return this;
    }

    public void setCustomerPaymentCode(String customerPaymentCode) {
        this.customerPaymentCode = customerPaymentCode;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public NotifyTransaction schoolName(String schoolName) {
        this.setSchoolName(schoolName);
        return this;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSourcePaymentChannelCode() {
        return this.sourcePaymentChannelCode;
    }

    public NotifyTransaction sourcePaymentChannelCode(String sourcePaymentChannelCode) {
        this.setSourcePaymentChannelCode(sourcePaymentChannelCode);
        return this;
    }

    public void setSourcePaymentChannelCode(String sourcePaymentChannelCode) {
        this.sourcePaymentChannelCode = sourcePaymentChannelCode;
    }

    public String getSchoolpayReceiptNumber() {
        return this.schoolpayReceiptNumber;
    }

    public NotifyTransaction schoolpayReceiptNumber(String schoolpayReceiptNumber) {
        this.setSchoolpayReceiptNumber(schoolpayReceiptNumber);
        return this;
    }

    public void setSchoolpayReceiptNumber(String schoolpayReceiptNumber) {
        this.schoolpayReceiptNumber = schoolpayReceiptNumber;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public NotifyTransaction amount(Integer amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public NotifyTransaction schoolCode(String schoolCode) {
        this.setSchoolCode(schoolCode);
        return this;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getPartnerCode() {
        return this.partnerCode;
    }

    public NotifyTransaction partnerCode(String partnerCode) {
        this.setPartnerCode(partnerCode);
        return this;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public NotifyTransaction dateCreated(LocalDate dateCreated) {
        this.setDateCreated(dateCreated);
        return this;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getSourceTransactionId() {
        return this.sourceTransactionId;
    }

    public NotifyTransaction sourceTransactionId(Integer sourceTransactionId) {
        this.setSourceTransactionId(sourceTransactionId);
        return this;
    }

    public void setSourceTransactionId(Integer sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public Integer getStudentCode() {
        return this.studentCode;
    }

    public NotifyTransaction studentCode(Integer studentCode) {
        this.setStudentCode(studentCode);
        return this;
    }

    public void setStudentCode(Integer studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public NotifyTransaction studentName(String studentName) {
        this.setStudentName(studentName);
        return this;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getCharges() {
        return this.charges;
    }

    public NotifyTransaction charges(Integer charges) {
        this.setCharges(charges);
        return this;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

    public LocalDate getTimestamp() {
        return this.timestamp;
    }

    public NotifyTransaction timestamp(LocalDate timestamp) {
        this.setTimestamp(timestamp);
        return this;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getNarration() {
        return this.narration;
    }

    public NotifyTransaction narration(String narration) {
        this.setNarration(narration);
        return this;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Integer getCurrency() {
        return this.currency;
    }

    public NotifyTransaction currency(Integer currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getDebitAccount() {
        return this.debitAccount;
    }

    public NotifyTransaction debitAccount(Integer debitAccount) {
        this.setDebitAccount(debitAccount);
        return this;
    }

    public void setDebitAccount(Integer debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Integer getCreditAccount() {
        return this.creditAccount;
    }

    public NotifyTransaction creditAccount(Integer creditAccount) {
        this.setCreditAccount(creditAccount);
        return this;
    }

    public void setCreditAccount(Integer creditAccount) {
        this.creditAccount = creditAccount;
    }

    public ProccesingStatus getProccessingStatus() {
        return this.proccessingStatus;
    }

    public NotifyTransaction proccessingStatus(ProccesingStatus proccessingStatus) {
        this.setProccessingStatus(proccessingStatus);
        return this;
    }

    public void setProccessingStatus(ProccesingStatus proccessingStatus) {
        this.proccessingStatus = proccessingStatus;
    }

    public ProccesingStatus getFcrTransactionStatus() {
        return this.fcrTransactionStatus;
    }

    public NotifyTransaction fcrTransactionStatus(ProccesingStatus fcrTransactionStatus) {
        this.setFcrTransactionStatus(fcrTransactionStatus);
        return this;
    }

    public void setFcrTransactionStatus(ProccesingStatus fcrTransactionStatus) {
        this.fcrTransactionStatus = fcrTransactionStatus;
    }

    public String getFcrTransactionId() {
        return this.fcrTransactionId;
    }

    public NotifyTransaction fcrTransactionId(String fcrTransactionId) {
        this.setFcrTransactionId(fcrTransactionId);
        return this;
    }

    public void setFcrTransactionId(String fcrTransactionId) {
        this.fcrTransactionId = fcrTransactionId;
    }

    public String getFcrTransactionReference() {
        return this.fcrTransactionReference;
    }

    public NotifyTransaction fcrTransactionReference(String fcrTransactionReference) {
        this.setFcrTransactionReference(fcrTransactionReference);
        return this;
    }

    public void setFcrTransactionReference(String fcrTransactionReference) {
        this.fcrTransactionReference = fcrTransactionReference;
    }

    public String getFreeField1() {
        return this.freeField1;
    }

    public NotifyTransaction freeField1(String freeField1) {
        this.setFreeField1(freeField1);
        return this;
    }

    public void setFreeField1(String freeField1) {
        this.freeField1 = freeField1;
    }

    public String getFreeField2() {
        return this.freeField2;
    }

    public NotifyTransaction freeField2(String freeField2) {
        this.setFreeField2(freeField2);
        return this;
    }

    public void setFreeField2(String freeField2) {
        this.freeField2 = freeField2;
    }

    public String getFreeField3() {
        return this.freeField3;
    }

    public NotifyTransaction freeField3(String freeField3) {
        this.setFreeField3(freeField3);
        return this;
    }

    public void setFreeField3(String freeField3) {
        this.freeField3 = freeField3;
    }

    public Integer getRetries() {
        return this.retries;
    }

    public NotifyTransaction retries(Integer retries) {
        this.setRetries(retries);
        return this;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NotifyTransaction)) {
            return false;
        }
        return id != null && id.equals(((NotifyTransaction) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NotifyTransaction{" +
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
