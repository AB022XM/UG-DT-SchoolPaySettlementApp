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
@JsonPropertyOrder(
    { "bankCode", "branchId", "cardExpiryDate", "cardNumber", "originatorName", "payerProductInstanceReference", "productTypeCode" }
)
@Generated("jsonschema2pojo")
public class PayerDetails implements Serializable {

    @JsonProperty("bankCode")
    private String bankCode;

    @JsonProperty("branchId")
    private Integer branchId;

    @JsonProperty("cardExpiryDate")
    private String cardExpiryDate;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("originatorName")
    private String originatorName;

    @JsonProperty("payerProductInstanceReference")
    private String payerProductInstanceReference;

    @JsonProperty("productTypeCode")
    private String productTypeCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = -2226585102756309046L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PayerDetails() {}

    /**
     *
     * @param bankCode
     * @param branchId
     * @param payerProductInstanceReference
     * @param originatorName
     * @param cardExpiryDate
     * @param cardNumber
     * @param productTypeCode
     */
    public PayerDetails(
        String bankCode,
        Integer branchId,
        String cardExpiryDate,
        String cardNumber,
        String originatorName,
        String payerProductInstanceReference,
        String productTypeCode
    ) {
        super();
        this.bankCode = bankCode;
        this.branchId = branchId;
        this.cardExpiryDate = cardExpiryDate;
        this.cardNumber = cardNumber;
        this.originatorName = originatorName;
        this.payerProductInstanceReference = payerProductInstanceReference;
        this.productTypeCode = productTypeCode;
    }

    @JsonProperty("bankCode")
    public String getBankCode() {
        return bankCode;
    }

    @JsonProperty("bankCode")
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public PayerDetails withBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    @JsonProperty("branchId")
    public Integer getBranchId() {
        return branchId;
    }

    @JsonProperty("branchId")
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public PayerDetails withBranchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    @JsonProperty("cardExpiryDate")
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    @JsonProperty("cardExpiryDate")
    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public PayerDetails withCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
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

    public PayerDetails withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @JsonProperty("originatorName")
    public String getOriginatorName() {
        return originatorName;
    }

    @JsonProperty("originatorName")
    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    public PayerDetails withOriginatorName(String originatorName) {
        this.originatorName = originatorName;
        return this;
    }

    @JsonProperty("payerProductInstanceReference")
    public String getPayerProductInstanceReference() {
        return payerProductInstanceReference;
    }

    @JsonProperty("payerProductInstanceReference")
    public void setPayerProductInstanceReference(String payerProductInstanceReference) {
        this.payerProductInstanceReference = payerProductInstanceReference;
    }

    public PayerDetails withPayerProductInstanceReference(String payerProductInstanceReference) {
        this.payerProductInstanceReference = payerProductInstanceReference;
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

    public PayerDetails withProductTypeCode(String productTypeCode) {
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

    public PayerDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayerDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bankCode");
        sb.append('=');
        sb.append(((this.bankCode == null) ? "<null>" : this.bankCode));
        sb.append(',');
        sb.append("branchId");
        sb.append('=');
        sb.append(((this.branchId == null) ? "<null>" : this.branchId));
        sb.append(',');
        sb.append("cardExpiryDate");
        sb.append('=');
        sb.append(((this.cardExpiryDate == null) ? "<null>" : this.cardExpiryDate));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null) ? "<null>" : this.cardNumber));
        sb.append(',');
        sb.append("originatorName");
        sb.append('=');
        sb.append(((this.originatorName == null) ? "<null>" : this.originatorName));
        sb.append(',');
        sb.append("payerProductInstanceReference");
        sb.append('=');
        sb.append(((this.payerProductInstanceReference == null) ? "<null>" : this.payerProductInstanceReference));
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
        result = ((result * 31) + ((this.bankCode == null) ? 0 : this.bankCode.hashCode()));
        result = ((result * 31) + ((this.branchId == null) ? 0 : this.branchId.hashCode()));
        result = ((result * 31) + ((this.payerProductInstanceReference == null) ? 0 : this.payerProductInstanceReference.hashCode()));
        result = ((result * 31) + ((this.originatorName == null) ? 0 : this.originatorName.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.cardExpiryDate == null) ? 0 : this.cardExpiryDate.hashCode()));
        result = ((result * 31) + ((this.cardNumber == null) ? 0 : this.cardNumber.hashCode()));
        result = ((result * 31) + ((this.productTypeCode == null) ? 0 : this.productTypeCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PayerDetails) == false) {
            return false;
        }
        PayerDetails rhs = ((PayerDetails) other);
        return (
            (
                (
                    (
                        (
                            (
                                (
                                    ((this.bankCode == rhs.bankCode) || ((this.bankCode != null) && this.bankCode.equals(rhs.bankCode))) &&
                                    ((this.branchId == rhs.branchId) || ((this.branchId != null) && this.branchId.equals(rhs.branchId)))
                                ) &&
                                (
                                    (this.payerProductInstanceReference == rhs.payerProductInstanceReference) ||
                                    (
                                        (this.payerProductInstanceReference != null) &&
                                        this.payerProductInstanceReference.equals(rhs.payerProductInstanceReference)
                                    )
                                )
                            ) &&
                            (
                                (this.originatorName == rhs.originatorName) ||
                                ((this.originatorName != null) && this.originatorName.equals(rhs.originatorName))
                            )
                        ) &&
                        (
                            (this.additionalProperties == rhs.additionalProperties) ||
                            ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                        )
                    ) &&
                    (
                        (this.cardExpiryDate == rhs.cardExpiryDate) ||
                        ((this.cardExpiryDate != null) && this.cardExpiryDate.equals(rhs.cardExpiryDate))
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
