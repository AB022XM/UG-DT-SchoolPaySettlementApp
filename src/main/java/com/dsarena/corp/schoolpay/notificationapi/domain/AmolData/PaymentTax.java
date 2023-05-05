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
@JsonPropertyOrder({ "taxAmount", "taxGLAccount", "taxNarration" })
@Generated("jsonschema2pojo")
public class PaymentTax implements Serializable {

    @JsonProperty("taxAmount")
    private Integer taxAmount;

    @JsonProperty("taxGLAccount")
    private String taxGLAccount;

    @JsonProperty("taxNarration")
    private String taxNarration;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = -156592296702096934L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentTax() {}

    /**
     *
     * @param taxAmount
     * @param taxNarration
     * @param taxGLAccount
     */
    public PaymentTax(Integer taxAmount, String taxGLAccount, String taxNarration) {
        super();
        this.taxAmount = taxAmount;
        this.taxGLAccount = taxGLAccount;
        this.taxNarration = taxNarration;
    }

    @JsonProperty("taxAmount")
    public Integer getTaxAmount() {
        return taxAmount;
    }

    @JsonProperty("taxAmount")
    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    public PaymentTax withTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    @JsonProperty("taxGLAccount")
    public String getTaxGLAccount() {
        return taxGLAccount;
    }

    @JsonProperty("taxGLAccount")
    public void setTaxGLAccount(String taxGLAccount) {
        this.taxGLAccount = taxGLAccount;
    }

    public PaymentTax withTaxGLAccount(String taxGLAccount) {
        this.taxGLAccount = taxGLAccount;
        return this;
    }

    @JsonProperty("taxNarration")
    public String getTaxNarration() {
        return taxNarration;
    }

    @JsonProperty("taxNarration")
    public void setTaxNarration(String taxNarration) {
        this.taxNarration = taxNarration;
    }

    public PaymentTax withTaxNarration(String taxNarration) {
        this.taxNarration = taxNarration;
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

    public PaymentTax withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentTax.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("taxAmount");
        sb.append('=');
        sb.append(((this.taxAmount == null) ? "<null>" : this.taxAmount));
        sb.append(',');
        sb.append("taxGLAccount");
        sb.append('=');
        sb.append(((this.taxGLAccount == null) ? "<null>" : this.taxGLAccount));
        sb.append(',');
        sb.append("taxNarration");
        sb.append('=');
        sb.append(((this.taxNarration == null) ? "<null>" : this.taxNarration));
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
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.taxAmount == null) ? 0 : this.taxAmount.hashCode()));
        result = ((result * 31) + ((this.taxNarration == null) ? 0 : this.taxNarration.hashCode()));
        result = ((result * 31) + ((this.taxGLAccount == null) ? 0 : this.taxGLAccount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentTax) == false) {
            return false;
        }
        PaymentTax rhs = ((PaymentTax) other);
        return (
            (
                (
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    ) &&
                    ((this.taxAmount == rhs.taxAmount) || ((this.taxAmount != null) && this.taxAmount.equals(rhs.taxAmount)))
                ) &&
                ((this.taxNarration == rhs.taxNarration) || ((this.taxNarration != null) && this.taxNarration.equals(rhs.taxNarration)))
            ) &&
            ((this.taxGLAccount == rhs.taxGLAccount) || ((this.taxGLAccount != null) && this.taxGLAccount.equals(rhs.taxGLAccount)))
        );
    }
}
