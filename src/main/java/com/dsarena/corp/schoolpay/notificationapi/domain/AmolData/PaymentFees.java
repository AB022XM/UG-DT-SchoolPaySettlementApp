package com.dsarena.corp.schoolpay.notificationapi.domain.AmolData;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "feeAmount", "feeGLAccount", "feeNarration", "transactionReferenceNumber" })
@Generated("jsonschema2pojo")
public class PaymentFees implements Serializable {

    @JsonProperty("feeAmount")
    private Integer feeAmount;

    @JsonProperty("feeGLAccount")
    private String feeGLAccount;

    @JsonProperty("feeNarration")
    private String feeNarration;

    @JsonProperty("transactionReferenceNumber")
    private String transactionReferenceNumber;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = 6570071682429663113L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentFees() {}

    /**
     *
     * @param feeAmount
     * @param transactionReferenceNumber
     * @param feeGLAccount
     * @param feeNarration
     */
    public PaymentFees(Integer feeAmount, String feeGLAccount, String feeNarration, String transactionReferenceNumber) {
        super();
        this.feeAmount = feeAmount;
        this.feeGLAccount = feeGLAccount;
        this.feeNarration = feeNarration;
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    @JsonProperty("feeAmount")
    public Integer getFeeAmount() {
        return feeAmount;
    }

    @JsonProperty("feeAmount")
    public void setFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
    }

    public PaymentFees withFeeAmount(Integer feeAmount) {
        this.feeAmount = feeAmount;
        return this;
    }

    @JsonProperty("feeGLAccount")
    public String getFeeGLAccount() {
        return feeGLAccount;
    }

    @JsonProperty("feeGLAccount")
    public void setFeeGLAccount(String feeGLAccount) {
        this.feeGLAccount = feeGLAccount;
    }

    public PaymentFees withFeeGLAccount(String feeGLAccount) {
        this.feeGLAccount = feeGLAccount;
        return this;
    }

    @JsonProperty("feeNarration")
    public String getFeeNarration() {
        return feeNarration;
    }

    @JsonProperty("feeNarration")
    public void setFeeNarration(String feeNarration) {
        this.feeNarration = feeNarration;
    }

    public PaymentFees withFeeNarration(String feeNarration) {
        this.feeNarration = feeNarration;
        return this;
    }

    @JsonProperty("transactionReferenceNumber")
    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    @JsonProperty("transactionReferenceNumber")
    public void setTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    public PaymentFees withTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PaymentFees withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentFees.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("feeAmount");
        sb.append('=');
        sb.append(((this.feeAmount == null) ? "<null>" : this.feeAmount));
        sb.append(',');
        sb.append("feeGLAccount");
        sb.append('=');
        sb.append(((this.feeGLAccount == null) ? "<null>" : this.feeGLAccount));
        sb.append(',');
        sb.append("feeNarration");
        sb.append('=');
        sb.append(((this.feeNarration == null) ? "<null>" : this.feeNarration));
        sb.append(',');
        sb.append("transactionReferenceNumber");
        sb.append('=');
        sb.append(((this.transactionReferenceNumber == null) ? "<null>" : this.transactionReferenceNumber));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.feeAmount == null) ? 0 : this.feeAmount.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.transactionReferenceNumber == null) ? 0 : this.transactionReferenceNumber.hashCode()));
        result = ((result * 31) + ((this.feeGLAccount == null) ? 0 : this.feeGLAccount.hashCode()));
        result = ((result * 31) + ((this.feeNarration == null) ? 0 : this.feeNarration.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentFees) == false) {
            return false;
        }
        PaymentFees rhs = ((PaymentFees) other);
        return (
            (
                (
                    (
                        ((this.feeAmount == rhs.feeAmount) || ((this.feeAmount != null) && this.feeAmount.equals(rhs.feeAmount))) &&
                        (
                            (this.additionalProperties == rhs.additionalProperties) ||
                            ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                        )
                    ) &&
                    (
                        (this.transactionReferenceNumber == rhs.transactionReferenceNumber) ||
                        (
                            (this.transactionReferenceNumber != null) &&
                            this.transactionReferenceNumber.equals(rhs.transactionReferenceNumber)
                        )
                    )
                ) &&
                ((this.feeGLAccount == rhs.feeGLAccount) || ((this.feeGLAccount != null) && this.feeGLAccount.equals(rhs.feeGLAccount)))
            ) &&
            ((this.feeNarration == rhs.feeNarration) || ((this.feeNarration != null) && this.feeNarration.equals(rhs.feeNarration)))
        );
    }
}
