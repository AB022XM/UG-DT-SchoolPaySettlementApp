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
@JsonPropertyOrder(
    {
        "debitAmount",
        "creditAmount",
        "debitCurrency",
        "creditCurrency",
        "dateType",
        "fxRate",
        "payeeDetails",
        "payerDetails",
        "paymentFees",
        "paymentMechanism",
        "paymentPurpose",
        "paymentTax",
    }
)
@Generated("jsonschema2pojo")
public class PaymentTransaction implements Serializable {

    @JsonProperty("debitAmount")
    private Double debitAmount;

    @JsonProperty("creditAmount")
    private String creditAmount;

    @JsonProperty("debitCurrency")
    private String debitCurrency;

    @JsonProperty("creditCurrency")
    private String creditCurrency;

    @JsonProperty("dateType")
    private DateType dateType;

    @JsonProperty("fxRate")
    private String fxRate;

    @JsonProperty("payeeDetails")
    private PayeeDetails payeeDetails;

    @JsonProperty("payerDetails")
    private PayerDetails payerDetails;

    @JsonProperty("paymentFees")
    private PaymentFees paymentFees;

    @JsonProperty("paymentMechanism")
    private PaymentMechanism paymentMechanism;

    @JsonProperty("paymentPurpose")
    private PaymentPurpose paymentPurpose;

    @JsonProperty("paymentTax")
    private PaymentTax paymentTax;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = 7033061611926861876L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentTransaction() {}

    /**
     *
     * @param payerDetails
     * @param fxRate
     * @param dateType
     * @param debitCurrency
     * @param payeeDetails
     * @param paymentTax
     * @param paymentFees
     * @param debitAmount
     * @param creditCurrency
     * @param paymentPurpose
     * @param creditAmount
     * @param paymentMechanism
     */
    public PaymentTransaction(
        Double debitAmount,
        String creditAmount,
        String debitCurrency,
        String creditCurrency,
        DateType dateType,
        String fxRate,
        PayeeDetails payeeDetails,
        PayerDetails payerDetails,
        PaymentFees paymentFees,
        PaymentMechanism paymentMechanism,
        PaymentPurpose paymentPurpose,
        PaymentTax paymentTax
    ) {
        super();
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.debitCurrency = debitCurrency;
        this.creditCurrency = creditCurrency;
        this.dateType = dateType;
        this.fxRate = fxRate;
        this.payeeDetails = payeeDetails;
        this.payerDetails = payerDetails;
        this.paymentFees = paymentFees;
        this.paymentMechanism = paymentMechanism;
        this.paymentPurpose = paymentPurpose;
        this.paymentTax = paymentTax;
    }

    @JsonProperty("debitAmount")
    public Double getDebitAmount() {
        return debitAmount;
    }

    @JsonProperty("debitAmount")
    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public PaymentTransaction withDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
        return this;
    }

    @JsonProperty("creditAmount")
    public String getCreditAmount() {
        return creditAmount;
    }

    @JsonProperty("creditAmount")
    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public PaymentTransaction withCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
        return this;
    }

    @JsonProperty("debitCurrency")
    public String getDebitCurrency() {
        return debitCurrency;
    }

    @JsonProperty("debitCurrency")
    public void setDebitCurrency(String debitCurrency) {
        this.debitCurrency = debitCurrency;
    }

    public PaymentTransaction withDebitCurrency(String debitCurrency) {
        this.debitCurrency = debitCurrency;
        return this;
    }

    @JsonProperty("creditCurrency")
    public String getCreditCurrency() {
        return creditCurrency;
    }

    @JsonProperty("creditCurrency")
    public void setCreditCurrency(String creditCurrency) {
        this.creditCurrency = creditCurrency;
    }

    public PaymentTransaction withCreditCurrency(String creditCurrency) {
        this.creditCurrency = creditCurrency;
        return this;
    }

    @JsonProperty("dateType")
    public DateType getDateType() {
        return dateType;
    }

    @JsonProperty("dateType")
    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    public PaymentTransaction withDateType(DateType dateType) {
        this.dateType = dateType;
        return this;
    }

    @JsonProperty("fxRate")
    public String getFxRate() {
        return fxRate;
    }

    @JsonProperty("fxRate")
    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public PaymentTransaction withFxRate(String fxRate) {
        this.fxRate = fxRate;
        return this;
    }

    @JsonProperty("payeeDetails")
    public PayeeDetails getPayeeDetails() {
        return payeeDetails;
    }

    @JsonProperty("payeeDetails")
    public void setPayeeDetails(PayeeDetails payeeDetails) {
        this.payeeDetails = payeeDetails;
    }

    public PaymentTransaction withPayeeDetails(PayeeDetails payeeDetails) {
        this.payeeDetails = payeeDetails;
        return this;
    }

    @JsonProperty("payerDetails")
    public PayerDetails getPayerDetails() {
        return payerDetails;
    }

    @JsonProperty("payerDetails")
    public void setPayerDetails(PayerDetails payerDetails) {
        this.payerDetails = payerDetails;
    }

    public PaymentTransaction withPayerDetails(PayerDetails payerDetails) {
        this.payerDetails = payerDetails;
        return this;
    }

    @JsonProperty("paymentFees")
    public PaymentFees getPaymentFees() {
        return paymentFees;
    }

    @JsonProperty("paymentFees")
    public void setPaymentFees(PaymentFees paymentFees) {
        this.paymentFees = paymentFees;
    }

    public PaymentTransaction withPaymentFees(PaymentFees paymentFees) {
        this.paymentFees = paymentFees;
        return this;
    }

    @JsonProperty("paymentMechanism")
    public PaymentMechanism getPaymentMechanism() {
        return paymentMechanism;
    }

    @JsonProperty("paymentMechanism")
    public void setPaymentMechanism(PaymentMechanism paymentMechanism) {
        this.paymentMechanism = paymentMechanism;
    }

    public PaymentTransaction withPaymentMechanism(PaymentMechanism paymentMechanism) {
        this.paymentMechanism = paymentMechanism;
        return this;
    }

    @JsonProperty("paymentPurpose")
    public PaymentPurpose getPaymentPurpose() {
        return paymentPurpose;
    }

    @JsonProperty("paymentPurpose")
    public void setPaymentPurpose(PaymentPurpose paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public PaymentTransaction withPaymentPurpose(PaymentPurpose paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
        return this;
    }

    @JsonProperty("paymentTax")
    public PaymentTax getPaymentTax() {
        return paymentTax;
    }

    @JsonProperty("paymentTax")
    public void setPaymentTax(PaymentTax paymentTax) {
        this.paymentTax = paymentTax;
    }

    public PaymentTransaction withPaymentTax(PaymentTax paymentTax) {
        this.paymentTax = paymentTax;
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

    public PaymentTransaction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentTransaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("debitAmount");
        sb.append('=');
        sb.append(((this.debitAmount == null) ? "<null>" : this.debitAmount));
        sb.append(',');
        sb.append("creditAmount");
        sb.append('=');
        sb.append(((this.creditAmount == null) ? "<null>" : this.creditAmount));
        sb.append(',');
        sb.append("debitCurrency");
        sb.append('=');
        sb.append(((this.debitCurrency == null) ? "<null>" : this.debitCurrency));
        sb.append(',');
        sb.append("creditCurrency");
        sb.append('=');
        sb.append(((this.creditCurrency == null) ? "<null>" : this.creditCurrency));
        sb.append(',');
        sb.append("dateType");
        sb.append('=');
        sb.append(((this.dateType == null) ? "<null>" : this.dateType));
        sb.append(',');
        sb.append("fxRate");
        sb.append('=');
        sb.append(((this.fxRate == null) ? "<null>" : this.fxRate));
        sb.append(',');
        sb.append("payeeDetails");
        sb.append('=');
        sb.append(((this.payeeDetails == null) ? "<null>" : this.payeeDetails));
        sb.append(',');
        sb.append("payerDetails");
        sb.append('=');
        sb.append(((this.payerDetails == null) ? "<null>" : this.payerDetails));
        sb.append(',');
        sb.append("paymentFees");
        sb.append('=');
        sb.append(((this.paymentFees == null) ? "<null>" : this.paymentFees));
        sb.append(',');
        sb.append("paymentMechanism");
        sb.append('=');
        sb.append(((this.paymentMechanism == null) ? "<null>" : this.paymentMechanism));
        sb.append(',');
        sb.append("paymentPurpose");
        sb.append('=');
        sb.append(((this.paymentPurpose == null) ? "<null>" : this.paymentPurpose));
        sb.append(',');
        sb.append("paymentTax");
        sb.append('=');
        sb.append(((this.paymentTax == null) ? "<null>" : this.paymentTax));
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
        result = ((result * 31) + ((this.payerDetails == null) ? 0 : this.payerDetails.hashCode()));
        result = ((result * 31) + ((this.fxRate == null) ? 0 : this.fxRate.hashCode()));
        result = ((result * 31) + ((this.debitCurrency == null) ? 0 : this.debitCurrency.hashCode()));
        result = ((result * 31) + ((this.payeeDetails == null) ? 0 : this.payeeDetails.hashCode()));
        result = ((result * 31) + ((this.paymentTax == null) ? 0 : this.paymentTax.hashCode()));
        result = ((result * 31) + ((this.debitAmount == null) ? 0 : this.debitAmount.hashCode()));
        result = ((result * 31) + ((this.dateType == null) ? 0 : this.dateType.hashCode()));
        result = ((result * 31) + ((this.paymentFees == null) ? 0 : this.paymentFees.hashCode()));
        result = ((result * 31) + ((this.creditCurrency == null) ? 0 : this.creditCurrency.hashCode()));
        result = ((result * 31) + ((this.paymentPurpose == null) ? 0 : this.paymentPurpose.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.creditAmount == null) ? 0 : this.creditAmount.hashCode()));
        result = ((result * 31) + ((this.paymentMechanism == null) ? 0 : this.paymentMechanism.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentTransaction) == false) {
            return false;
        }
        PaymentTransaction rhs = ((PaymentTransaction) other);
        return (
            (
                (
                    (
                        (
                            (
                                (
                                    (
                                        (
                                            (
                                                (
                                                    (
                                                        (
                                                            (this.payerDetails == rhs.payerDetails) ||
                                                            ((this.payerDetails != null) && this.payerDetails.equals(rhs.payerDetails))
                                                        ) &&
                                                        (
                                                            (this.fxRate == rhs.fxRate) ||
                                                            ((this.fxRate != null) && this.fxRate.equals(rhs.fxRate))
                                                        )
                                                    ) &&
                                                    (
                                                        (this.debitCurrency == rhs.debitCurrency) ||
                                                        ((this.debitCurrency != null) && this.debitCurrency.equals(rhs.debitCurrency))
                                                    )
                                                ) &&
                                                (
                                                    (this.payeeDetails == rhs.payeeDetails) ||
                                                    ((this.payeeDetails != null) && this.payeeDetails.equals(rhs.payeeDetails))
                                                )
                                            ) &&
                                            (
                                                (this.paymentTax == rhs.paymentTax) ||
                                                ((this.paymentTax != null) && this.paymentTax.equals(rhs.paymentTax))
                                            )
                                        ) &&
                                        (
                                            (this.debitAmount == rhs.debitAmount) ||
                                            ((this.debitAmount != null) && this.debitAmount.equals(rhs.debitAmount))
                                        )
                                    ) &&
                                    ((this.dateType == rhs.dateType) || ((this.dateType != null) && this.dateType.equals(rhs.dateType)))
                                ) &&
                                (
                                    (this.paymentFees == rhs.paymentFees) ||
                                    ((this.paymentFees != null) && this.paymentFees.equals(rhs.paymentFees))
                                )
                            ) &&
                            (
                                (this.creditCurrency == rhs.creditCurrency) ||
                                ((this.creditCurrency != null) && this.creditCurrency.equals(rhs.creditCurrency))
                            )
                        ) &&
                        (
                            (this.paymentPurpose == rhs.paymentPurpose) ||
                            ((this.paymentPurpose != null) && this.paymentPurpose.equals(rhs.paymentPurpose))
                        )
                    ) &&
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    )
                ) &&
                ((this.creditAmount == rhs.creditAmount) || ((this.creditAmount != null) && this.creditAmount.equals(rhs.creditAmount)))
            ) &&
            (
                (this.paymentMechanism == rhs.paymentMechanism) ||
                ((this.paymentMechanism != null) && this.paymentMechanism.equals(rhs.paymentMechanism))
            )
        );
    }
}
