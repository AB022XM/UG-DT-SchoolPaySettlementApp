package com.dsarena.corp.schoolpay.notificationapi.service.dto;

import com.dsarena.corp.schoolpay.notificationapi.domain.SchoolDomain.School;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.DELFLAG;
import com.dsarena.corp.schoolpay.notificationapi.domain.enumeration.RecordStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link School} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SchoolDTO implements Serializable {

    private Long id;

    @NotNull
    private UUID schoolId;

    @NotNull
    private String schoolCode;

    @NotNull
    private Integer schoolShortcode;

    @NotNull
    private String phonenumber;

    private String address;

    @NotNull
    @Size(min = 3, max = 200)
    private String schoolName;

    @NotNull
    private LocalDate registrationdate;

    @NotNull
    private RecordStatus status;

    private String freeField1;

    private String freeField2;

    private String freeField3;

    private Boolean isSchoolAccountNumberABSA;

    private String schoolAccountNumber;

    private DELFLAG isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(UUID schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public Integer getSchoolShortcode() {
        return schoolShortcode;
    }

    public void setSchoolShortcode(Integer schoolShortcode) {
        this.schoolShortcode = schoolShortcode;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
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

    public Boolean getIsSchoolAccountNumberABSA() {
        return isSchoolAccountNumberABSA;
    }

    public void setIsSchoolAccountNumberABSA(Boolean isSchoolAccountNumberABSA) {
        this.isSchoolAccountNumberABSA = isSchoolAccountNumberABSA;
    }

    public String getSchoolAccountNumber() {
        return schoolAccountNumber;
    }

    public void setSchoolAccountNumber(String schoolAccountNumber) {
        this.schoolAccountNumber = schoolAccountNumber;
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
        if (!(o instanceof SchoolDTO)) {
            return false;
        }

        SchoolDTO schoolDTO = (SchoolDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, schoolDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SchoolDTO{" +
            "id=" + getId() +
            ", schoolId='" + getSchoolId() + "'" +
            ", schoolCode='" + getSchoolCode() + "'" +
            ", schoolShortcode=" + getSchoolShortcode() +
            ", phonenumber='" + getPhonenumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", schoolName='" + getSchoolName() + "'" +
            ", registrationdate='" + getRegistrationdate() + "'" +
            ", status='" + getStatus() + "'" +
            ", freeField1='" + getFreeField1() + "'" +
            ", freeField2='" + getFreeField2() + "'" +
            ", freeField3='" + getFreeField3() + "'" +
            ", isSchoolAccountNumberABSA='" + getIsSchoolAccountNumberABSA() + "'" +
            ", schoolAccountNumber='" + getSchoolAccountNumber() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            "}";
    }
}
