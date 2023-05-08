package com.dsarena.corp.schoolpay.notificationapi.domain;

import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.DELFLAG;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.RecordStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * A Partner.
 */
@Entity
@Table(name = "partner")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Type(type = "uuid-char")
    @Column(name = "partner_id", length = 36, nullable = false, unique = true)
    private UUID partnerId;

    @NotNull
    @Column(name = "partner_code", nullable = false)
    private Integer partnerCode;

    @Column(name = "partner_shortcode")
    private Integer partnerShortcode;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "partner_name", length = 100, nullable = false)
    private String partnerName;

    @Column(name = "registrationdate")
    private LocalDate registrationdate;

    @Column(name = "is_absa_partner")
    private Boolean isAbsaPartner;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RecordStatus status;

    @Column(name = "free_field_1")
    private String freeField1;

    @Column(name = "free_field_2")
    private String freeField2;

    @Column(name = "free_field_3")
    private String freeField3;

    @Column(name = "provide_debit_account")
    private Boolean provideDebitAccount;

    @Column(name = "provide_credit_account")
    private Boolean provideCreditAccount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted", nullable = false)
    private DELFLAG isDeleted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Partner id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPartnerId() {
        return this.partnerId;
    }

    public Partner partnerId(UUID partnerId) {
        this.setPartnerId(partnerId);
        return this;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getPartnerCode() {
        return this.partnerCode;
    }

    public Partner partnerCode(Integer partnerCode) {
        this.setPartnerCode(partnerCode);
        return this;
    }

    public void setPartnerCode(Integer partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPartnerShortcode() {
        return this.partnerShortcode;
    }

    public Partner partnerShortcode(Integer partnerShortcode) {
        this.setPartnerShortcode(partnerShortcode);
        return this;
    }

    public void setPartnerShortcode(Integer partnerShortcode) {
        this.partnerShortcode = partnerShortcode;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public Partner phonenumber(String phonenumber) {
        this.setPhonenumber(phonenumber);
        return this;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return this.address;
    }

    public Partner address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPartnerName() {
        return this.partnerName;
    }

    public Partner partnerName(String partnerName) {
        this.setPartnerName(partnerName);
        return this;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public LocalDate getRegistrationdate() {
        return this.registrationdate;
    }

    public Partner registrationdate(LocalDate registrationdate) {
        this.setRegistrationdate(registrationdate);
        return this;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Boolean getIsAbsaPartner() {
        return this.isAbsaPartner;
    }

    public Partner isAbsaPartner(Boolean isAbsaPartner) {
        this.setIsAbsaPartner(isAbsaPartner);
        return this;
    }

    public void setIsAbsaPartner(Boolean isAbsaPartner) {
        this.isAbsaPartner = isAbsaPartner;
    }

    public RecordStatus getStatus() {
        return this.status;
    }

    public Partner status(RecordStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    public String getFreeField1() {
        return this.freeField1;
    }

    public Partner freeField1(String freeField1) {
        this.setFreeField1(freeField1);
        return this;
    }

    public void setFreeField1(String freeField1) {
        this.freeField1 = freeField1;
    }

    public String getFreeField2() {
        return this.freeField2;
    }

    public Partner freeField2(String freeField2) {
        this.setFreeField2(freeField2);
        return this;
    }

    public void setFreeField2(String freeField2) {
        this.freeField2 = freeField2;
    }

    public String getFreeField3() {
        return this.freeField3;
    }

    public Partner freeField3(String freeField3) {
        this.setFreeField3(freeField3);
        return this;
    }

    public void setFreeField3(String freeField3) {
        this.freeField3 = freeField3;
    }

    public Boolean getProvideDebitAccount() {
        return this.provideDebitAccount;
    }

    public Partner provideDebitAccount(Boolean provideDebitAccount) {
        this.setProvideDebitAccount(provideDebitAccount);
        return this;
    }

    public void setProvideDebitAccount(Boolean provideDebitAccount) {
        this.provideDebitAccount = provideDebitAccount;
    }

    public Boolean getProvideCreditAccount() {
        return this.provideCreditAccount;
    }

    public Partner provideCreditAccount(Boolean provideCreditAccount) {
        this.setProvideCreditAccount(provideCreditAccount);
        return this;
    }

    public void setProvideCreditAccount(Boolean provideCreditAccount) {
        this.provideCreditAccount = provideCreditAccount;
    }

    public DELFLAG getIsDeleted() {
        return this.isDeleted;
    }

    public Partner isDeleted(DELFLAG isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(DELFLAG isDeleted) {
        this.isDeleted = isDeleted;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Partner)) {
            return false;
        }
        return id != null && id.equals(((Partner) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Partner{" +
            "id=" + getId() +
            ", partnerId='" + getPartnerId() + "'" +
            ", partnerCode=" + getPartnerCode() +
            ", partnerShortcode=" + getPartnerShortcode() +
            ", phonenumber='" + getPhonenumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", partnerName='" + getPartnerName() + "'" +
            ", registrationdate='" + getRegistrationdate() + "'" +
            ", isAbsaPartner='" + getIsAbsaPartner() + "'" +
            ", status='" + getStatus() + "'" +
            ", freeField1='" + getFreeField1() + "'" +
            ", freeField2='" + getFreeField2() + "'" +
            ", freeField3='" + getFreeField3() + "'" +
            ", provideDebitAccount='" + getProvideDebitAccount() + "'" +
            ", provideCreditAccount='" + getProvideCreditAccount() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            "}";
    }
}
