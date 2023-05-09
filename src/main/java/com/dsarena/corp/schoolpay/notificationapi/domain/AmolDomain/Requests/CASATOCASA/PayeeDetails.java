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
@JsonPropertyOrder({ "branchId", "cardNumber", "counterPartyName", "payeeProductInstanceReference", "productTypeCode" })
@Generated("jsonschema2pojo")
public class PayeeDetails implements Serializable {

    @JsonProperty("branchId")
    private Integer branchId;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("counterPartyName")
    private String counterPartyName;

    @JsonProperty("payeeProductInstanceReference")
    private String payeeProductInstanceReference;

    @JsonProperty("productTypeCode")
    private String productTypeCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = 4668498556116852470L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PayeeDetails() {}

    /**
     *
     * @param branchId
     * @param payeeProductInstanceReference
     * @param counterPartyName
     * @param cardNumber
     * @param productTypeCode
     */
    public PayeeDetails(
        Integer branchId,
        String cardNumber,
        String counterPartyName,
        String payeeProductInstanceReference,
        String productTypeCode
    ) {
        super();
        this.branchId = branchId;
        this.cardNumber = cardNumber;
        this.counterPartyName = counterPartyName;
        this.payeeProductInstanceReference = payeeProductInstanceReference;
        this.productTypeCode = productTypeCode;
    }

    @JsonProperty("branchId")
    public Integer getBranchId() {
        return branchId;
    }

    @JsonProperty("branchId")
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public PayeeDetails withBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public PayeeDetails withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @JsonProperty("counterPartyName")
    public String getCounterPartyName() {
        return counterPartyName;
    }

    @JsonProperty("counterPartyName")
    public void setCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
    }

    public PayeeDetails withCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
        return this;
    }

    @JsonProperty("payeeProductInstanceReference")
    public String getPayeeProductInstanceReference() {
        return payeeProductInstanceReference;
    }

    @JsonProperty("payeeProductInstanceReference")
    public void setPayeeProductInstanceReference(String payeeProductInstanceReference) {
        this.payeeProductInstanceReference = payeeProductInstanceReference;
    }

    public PayeeDetails withPayeeProductInstanceReference(String payeeProductInstanceReference) {
        this.payeeProductInstanceReference = payeeProductInstanceReference;
        return this;
    }

    @JsonProperty("productTypeCode")
    public String getProductTypeCode() {
        return productTypeCode;
    }

    @JsonProperty("productTypeCode")
    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public PayeeDetails withProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
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

    public PayeeDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayeeDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("branchId");
        sb.append('=');
        sb.append(((this.branchId == null) ? "<null>" : this.branchId));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null) ? "<null>" : this.cardNumber));
        sb.append(',');
        sb.append("counterPartyName");
        sb.append('=');
        sb.append(((this.counterPartyName == null) ? "<null>" : this.counterPartyName));
        sb.append(',');
        sb.append("payeeProductInstanceReference");
        sb.append('=');
        sb.append(((this.payeeProductInstanceReference == null) ? "<null>" : this.payeeProductInstanceReference));
        sb.append(',');
        sb.append("productTypeCode");
        sb.append('=');
        sb.append(((this.productTypeCode == null) ? "<null>" : this.productTypeCode));
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
        result = ((result * 31) + ((this.branchId == null) ? 0 : this.branchId.hashCode()));
        result = ((result * 31) + ((this.payeeProductInstanceReference == null) ? 0 : this.payeeProductInstanceReference.hashCode()));
        result = ((result * 31) + ((this.counterPartyName == null) ? 0 : this.counterPartyName.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.cardNumber == null) ? 0 : this.cardNumber.hashCode()));
        result = ((result * 31) + ((this.productTypeCode == null) ? 0 : this.productTypeCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PayeeDetails) == false) {
            return false;
        }
        PayeeDetails rhs = ((PayeeDetails) other);
        return (
            (
                (
                    (
                        (
                            ((this.branchId == rhs.branchId) || ((this.branchId != null) && this.branchId.equals(rhs.branchId))) &&
                            (
                                (this.payeeProductInstanceReference == rhs.payeeProductInstanceReference) ||
                                (
                                    (this.payeeProductInstanceReference != null) &&
                                    this.payeeProductInstanceReference.equals(rhs.payeeProductInstanceReference)
                                )
                            )
                        ) &&
                        (
                            (this.counterPartyName == rhs.counterPartyName) ||
                            ((this.counterPartyName != null) && this.counterPartyName.equals(rhs.counterPartyName))
                        )
                    ) &&
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    )
                ) &&
                ((this.cardNumber == rhs.cardNumber) || ((this.cardNumber != null) && this.cardNumber.equals(rhs.cardNumber)))
            ) &&
            (
                (this.productTypeCode == rhs.productTypeCode) ||
                ((this.productTypeCode != null) && this.productTypeCode.equals(rhs.productTypeCode))
            )
        );
    }
}
