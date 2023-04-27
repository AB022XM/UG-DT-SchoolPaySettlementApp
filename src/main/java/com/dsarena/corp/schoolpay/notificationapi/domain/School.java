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
 * A School.
 */
@Entity
@Table(name = "school")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Type(type = "uuid-char")
    @Column(name = "school_id", length = 36, nullable = false, unique = true)
    private UUID schoolId;

    @NotNull
    @Column(name = "school_code", nullable = false, unique = true)
    private String schoolCode;

    @NotNull
    @Column(name = "school_shortcode", nullable = false)
    private Integer schoolShortcode;

    @NotNull
    @Column(name = "phonenumber", nullable = false)
    private String phonenumber;

    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 3, max = 200)
    @Column(name = "school_name", length = 200, nullable = false)
    private String schoolName;

    @NotNull
    @Column(name = "registrationdate", nullable = false)
    private LocalDate registrationdate;

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

    @Column(name = "is_school_account_number_absa")
    private Boolean isSchoolAccountNumberABSA;

    @Column(name = "school_account_number")
    private Boolean schoolAccountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted")
    private DELFLAG isDeleted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public School id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSchoolId() {
        return this.schoolId;
    }

    public School schoolId(UUID schoolId) {
        this.setSchoolId(schoolId);
        return this;
    }

    public void setSchoolId(UUID schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public School schoolCode(String schoolCode) {
        this.setSchoolCode(schoolCode);
        return this;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public Integer getSchoolShortcode() {
        return this.schoolShortcode;
    }

    public School schoolShortcode(Integer schoolShortcode) {
        this.setSchoolShortcode(schoolShortcode);
        return this;
    }

    public void setSchoolShortcode(Integer schoolShortcode) {
        this.schoolShortcode = schoolShortcode;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public School phonenumber(String phonenumber) {
        this.setPhonenumber(phonenumber);
        return this;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return this.address;
    }

    public School address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public School schoolName(String schoolName) {
        this.setSchoolName(schoolName);
        return this;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDate getRegistrationdate() {
        return this.registrationdate;
    }

    public School registrationdate(LocalDate registrationdate) {
        this.setRegistrationdate(registrationdate);
        return this;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public RecordStatus getStatus() {
        return this.status;
    }

    public School status(RecordStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    public String getFreeField1() {
        return this.freeField1;
    }

    public School freeField1(String freeField1) {
        this.setFreeField1(freeField1);
        return this;
    }

    public void setFreeField1(String freeField1) {
        this.freeField1 = freeField1;
    }

    public String getFreeField2() {
        return this.freeField2;
    }

    public School freeField2(String freeField2) {
        this.setFreeField2(freeField2);
        return this;
    }

    public void setFreeField2(String freeField2) {
        this.freeField2 = freeField2;
    }

    public String getFreeField3() {
        return this.freeField3;
    }

    public School freeField3(String freeField3) {
        this.setFreeField3(freeField3);
        return this;
    }

    public void setFreeField3(String freeField3) {
        this.freeField3 = freeField3;
    }

    public Boolean getIsSchoolAccountNumberABSA() {
        return this.isSchoolAccountNumberABSA;
    }

    public School isSchoolAccountNumberABSA(Boolean isSchoolAccountNumberABSA) {
        this.setIsSchoolAccountNumberABSA(isSchoolAccountNumberABSA);
        return this;
    }

    public void setIsSchoolAccountNumberABSA(Boolean isSchoolAccountNumberABSA) {
        this.isSchoolAccountNumberABSA = isSchoolAccountNumberABSA;
    }

    public Boolean getSchoolAccountNumber() {
        return this.schoolAccountNumber;
    }

    public School schoolAccountNumber(Boolean schoolAccountNumber) {
        this.setSchoolAccountNumber(schoolAccountNumber);
        return this;
    }

    public void setSchoolAccountNumber(Boolean schoolAccountNumber) {
        this.schoolAccountNumber = schoolAccountNumber;
    }

    public DELFLAG getIsDeleted() {
        return this.isDeleted;
    }

    public School isDeleted(DELFLAG isDeleted) {
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
        if (!(o instanceof School)) {
            return false;
        }
        return id != null && id.equals(((School) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "School{" +
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
