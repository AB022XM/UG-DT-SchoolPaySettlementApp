package com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain;

import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.ProccesingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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
    @JsonIgnore
    private Long id;

    @Nullable
    @Column(name = "transaction_u_id", nullable = true)
    private String transactionUId;

    @Column(name = "record_id", unique = true)
    private Integer recordId;

    @Nullable
    @Column(name = "customer_payment_code", nullable = true)
    @JsonIgnore
    private String customerPaymentCode;

    @Nullable
    @Column(name = "school_name", nullable = true)
    private String schoolName;

    @NotNull
    @Column(name = "source_payment_channel_code", nullable = false)
    private String sourcePaymentChannelCode;

    @NotNull
    @Column(name = "schoolpay_receipt_number", nullable = false)
    private String schoolpayReceiptNumber;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "school_code")
    private String schoolCode;

    @Nullable
    @Column(name = "partner_code", nullable = true)
    @JsonIgnore
    @JsonIgnoreProperties(value = { "partnerCode" }, allowGetters = true)
    private String partnerCode;

    @Nullable
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @Nullable
    @Column(name = "source_transaction_id", nullable = false)
    private String sourceTransactionId;

    @Nullable
    @Column(name = "student_code", nullable = false)
    private String studentCode;

    @Nullable
    @Column(name = "student_name", nullable = true)
    private String studentName;

    @Nullable
    @Column(name = "charges")
    @JsonIgnore
    private Integer charges = 0;

    @Nullable
    @Column(name = "timestamp", nullable = true)
    @JsonIgnore
    private LocalDate timestamp;

    @Nullable
    @JsonIgnore
    @Column(name = "narration", nullable = true)
    private String narration;

    @Nullable
    @JsonIgnore
    @Column(name = "currency", nullable = true)
    private String currency = "UGX";

    @Nullable
    @Column(name = "debit_account", nullable = true)
    private String debitAccount;

    @Nullable
    @Column(name = "credit_account", nullable = true)
    private String creditAccount;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    @Column(name = "proccessing_status")
    private ProccesingStatus proccessingStatus;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    @Column(name = "fcr_transaction_status")
    private ProccesingStatus fcrTransactionStatus;

    @Column(name = "fcr_transaction_id", nullable = true)
    @JsonIgnore
    private String fcrTransactionId;

    @Column(name = "fcr_transaction_reference", nullable = true)
    @JsonIgnore
    private String fcrTransactionReference;

    @Column(name = "free_field_1")
    @JsonIgnore
    private String freeField1;

    @Column(name = "free_field_2")
    @JsonIgnore
    private String freeField2;

    @Column(name = "free_field_3")
    @JsonIgnore
    private String freeField3;

    @Max(value = 5)
    @Column(name = "retries")
    @JsonIgnore
    private Integer retries = 0;

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

    public String getTransactionUId() {
        return this.transactionUId;
    }

    public NotifyTransaction transactionUId(String transactionUId) {
        this.setTransactionUId(transactionUId);
        return this;
    }

    public void setTransactionUId(String transactionUId) {
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

    public String getSourceTransactionId() {
        return this.sourceTransactionId;
    }

    public NotifyTransaction sourceTransactionId(String sourceTransactionId) {
        this.setSourceTransactionId(sourceTransactionId);
        return this;
    }

    public void setSourceTransactionId(String sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public NotifyTransaction studentCode(String studentCode) {
        this.setStudentCode(studentCode);
        return this;
    }

    public void setStudentCode(String studentCode) {
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

    public String getCurrency() {
        return this.currency;
    }

    public NotifyTransaction currency(String currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDebitAccount() {
        return this.debitAccount;
    }

    public NotifyTransaction debitAccount(String debitAccount) {
        this.setDebitAccount(debitAccount);
        return this;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public String getCreditAccount() {
        return this.creditAccount;
    }

    public NotifyTransaction creditAccount(String creditAccount) {
        this.setCreditAccount(creditAccount);
        return this;
    }

    public void setCreditAccount(String creditAccount) {
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

    public static Integer generateUniqueRef() {
        int length = 7;
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Integer.parseInt(new String(digits));
    }

    public static String generateUniqueRefString() {
        int length = 10;
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }
    // public static String generaneeratSTimeStampString() {

    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //         //generate  date
    //         return LocalDate.now().format(formatter);
    // }

    // public static LocalDate generateTimeStampLocal() {

    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    //         //generate  date
    //         String date = LocalDate.now().format(formatter);
    //         //date format
    //         //format date
    //         return LocalDate.parse(date, formatter);
    // }
}
