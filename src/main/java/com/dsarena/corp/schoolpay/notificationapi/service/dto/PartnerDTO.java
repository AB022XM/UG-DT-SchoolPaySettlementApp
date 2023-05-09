package com.dsarena.corp.schoolpay.notificationapi.service.dto;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.Partner;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.DELFLAG;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.RecordStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link Partner} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PartnerDTO implements Serializable {

    private Long id;

    @NotNull
    private UUID partnerId;

    @NotNull
    private Integer partnerCode;

    private Integer partnerShortcode;

    private String phonenumber;

    private String address;

    @NotNull
    @Size(min = 3, max = 100)
    private String partnerName;

    private LocalDate registrationdate;

    private Boolean isAbsaPartner;

    @NotNull
    private RecordStatus status;

    private String freeField1;

    private String freeField2;

    private String freeField3;

    private Boolean provideDebitAccount;

    private Boolean provideCreditAccount;

    @NotNull
    private DELFLAG isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(Integer partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPartnerShortcode() {
        return partnerShortcode;
    }

    public void setPartnerShortcode(Integer partnerShortcode) {
        this.partnerShortcode = partnerShortcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Boolean getIsAbsaPartner() {
        return isAbsaPartner;
    }

    public void setIsAbsaPartner(Boolean isAbsaPartner) {
        this.isAbsaPartner = isAbsaPartner;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
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

    public Boolean getProvideDebitAccount() {
        return provideDebitAccount;
    }

    public void setProvideDebitAccount(Boolean provideDebitAccount) {
        this.provideDebitAccount = provideDebitAccount;
    }

    public Boolean getProvideCreditAccount() {
        return provideCreditAccount;
    }

    public void setProvideCreditAccount(Boolean provideCreditAccount) {
        this.provideCreditAccount = provideCreditAccount;
    }

    public DELFLAG getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(DELFLAG isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PartnerDTO)) {
            return false;
        }

        PartnerDTO partnerDTO = (PartnerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, partnerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PartnerDTO{" +
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
