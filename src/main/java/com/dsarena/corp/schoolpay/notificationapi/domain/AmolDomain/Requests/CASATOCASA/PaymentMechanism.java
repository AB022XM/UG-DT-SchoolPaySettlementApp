package com.dsarena.corp.schoolpay.notificationapi.domain.AmolDomain.Requests.CASATOCASA;

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
@JsonPropertyOrder({ "subCategoryCode", "transactionCategoryCode" })
@Generated("jsonschema2pojo")
public class PaymentMechanism implements Serializable {

    @JsonProperty("subCategoryCode")
    private String subCategoryCode;

    @JsonProperty("transactionCategoryCode")
    private String transactionCategoryCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = -6887252055399596446L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentMechanism() {}

    /**
     *
     * @param transactionCategoryCode
     * @param subCategoryCode
     */
    public PaymentMechanism(String subCategoryCode, String transactionCategoryCode) {
        super();
        this.subCategoryCode = subCategoryCode;
        this.transactionCategoryCode = transactionCategoryCode;
    }

    @JsonProperty("subCategoryCode")
    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    @JsonProperty("subCategoryCode")
    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public PaymentMechanism withSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
        return this;
    }

    @JsonProperty("transactionCategoryCode")
    public String getTransactionCategoryCode() {
        return transactionCategoryCode;
    }

    @JsonProperty("transactionCategoryCode")
    public void setTransactionCategoryCode(String transactionCategoryCode) {
        this.transactionCategoryCode = transactionCategoryCode;
    }

    public PaymentMechanism withTransactionCategoryCode(String transactionCategoryCode) {
        this.transactionCategoryCode = transactionCategoryCode;
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

    public PaymentMechanism withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentMechanism.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subCategoryCode");
        sb.append('=');
        sb.append(((this.subCategoryCode == null) ? "<null>" : this.subCategoryCode));
        sb.append(',');
        sb.append("transactionCategoryCode");
        sb.append('=');
        sb.append(((this.transactionCategoryCode == null) ? "<null>" : this.transactionCategoryCode));
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
        result = ((result * 31) + ((this.transactionCategoryCode == null) ? 0 : this.transactionCategoryCode.hashCode()));
        result = ((result * 31) + ((this.subCategoryCode == null) ? 0 : this.subCategoryCode.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentMechanism) == false) {
            return false;
        }
        PaymentMechanism rhs = ((PaymentMechanism) other);
        return (
            (
                (
                    (this.transactionCategoryCode == rhs.transactionCategoryCode) ||
                    ((this.transactionCategoryCode != null) && this.transactionCategoryCode.equals(rhs.transactionCategoryCode))
                ) &&
                (
                    (this.subCategoryCode == rhs.subCategoryCode) ||
                    ((this.subCategoryCode != null) && this.subCategoryCode.equals(rhs.subCategoryCode))
                )
            ) &&
            (
                (this.additionalProperties == rhs.additionalProperties) ||
                ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
            )
        );
    }
}
