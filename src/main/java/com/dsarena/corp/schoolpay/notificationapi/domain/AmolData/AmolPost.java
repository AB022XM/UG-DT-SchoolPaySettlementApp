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
@JsonPropertyOrder({ "customerReference", "paymentTransaction", "paymentTransactionType" })
@Generated("jsonschema2pojo")
public class AmolPost implements Serializable {

    @JsonProperty("customerReference")
    private String customerReference;

    @JsonProperty("paymentTransaction")
    private PaymentTransaction paymentTransaction;

    @JsonProperty("paymentTransactionType")
    private String paymentTransactionType;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = -8292878823003838906L;

    /**
     *
     * @param customerReference
     * @param paymentTransaction
     * @param paymentTransactionType
     */
    public AmolPost(String customerReference, PaymentTransaction paymentTransaction, String paymentTransactionType) {
        super();
        this.customerReference = customerReference;
        this.paymentTransaction = paymentTransaction;
        this.paymentTransactionType = paymentTransactionType;
    }

    @JsonProperty("customerReference")
    public String getCustomerReference() {
        return customerReference;
    }

    @JsonProperty("customerReference")
    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public AmolPost withCustomerReference(String customerReference) {
        this.customerReference = customerReference;
        return this;
    }

    @JsonProperty("paymentTransaction")
    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    @JsonProperty("paymentTransaction")
    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public AmolPost withPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
        return this;
    }

    @JsonProperty("paymentTransactionType")
    public String getPaymentTransactionType() {
        return paymentTransactionType;
    }

    @JsonProperty("paymentTransactionType")
    public void setPaymentTransactionType(String paymentTransactionType) {
        this.paymentTransactionType = paymentTransactionType;
    }

    public AmolPost withPaymentTransactionType(String paymentTransactionType) {
        this.paymentTransactionType = paymentTransactionType;
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

    public AmolPost withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AmolPost.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customerReference");
        sb.append('=');
        sb.append(((this.customerReference == null) ? "<null>" : this.customerReference));
        sb.append(',');
        sb.append("paymentTransaction");
        sb.append('=');
        sb.append(((this.paymentTransaction == null) ? "<null>" : this.paymentTransaction));
        sb.append(',');
        sb.append("paymentTransactionType");
        sb.append('=');
        sb.append(((this.paymentTransactionType == null) ? "<null>" : this.paymentTransactionType));
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
        result = ((result * 31) + ((this.paymentTransaction == null) ? 0 : this.paymentTransaction.hashCode()));
        result = ((result * 31) + ((this.paymentTransactionType == null) ? 0 : this.paymentTransactionType.hashCode()));
        result = ((result * 31) + ((this.customerReference == null) ? 0 : this.customerReference.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AmolPost) == false) {
            return false;
        }
        AmolPost rhs = ((AmolPost) other);
        return (
            (
                (
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    ) &&
                    (
                        (this.paymentTransaction == rhs.paymentTransaction) ||
                        ((this.paymentTransaction != null) && this.paymentTransaction.equals(rhs.paymentTransaction))
                    )
                ) &&
                (
                    (this.paymentTransactionType == rhs.paymentTransactionType) ||
                    ((this.paymentTransactionType != null) && this.paymentTransactionType.equals(rhs.paymentTransactionType))
                )
            ) &&
            (
                (this.customerReference == rhs.customerReference) ||
                ((this.customerReference != null) && this.customerReference.equals(rhs.customerReference))
            )
        );
    }
}
