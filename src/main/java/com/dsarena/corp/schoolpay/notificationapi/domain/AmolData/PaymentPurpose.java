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
@JsonPropertyOrder({ "checkerId", "narrative", "remittanceInformation" })
@Generated("jsonschema2pojo")
public class PaymentPurpose implements Serializable {

    @JsonProperty("checkerId")
    private Object checkerId;

    @JsonProperty("narrative")
    private String narrative;

    @JsonProperty("remittanceInformation")
    private String remittanceInformation;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static final long serialVersionUID = -5237049918425383163L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentPurpose() {}

    /**
     *
     * @param remittanceInformation
     * @param narrative
     * @param checkerId
     */
    public PaymentPurpose(Object checkerId, String narrative, String remittanceInformation) {
        super();
        this.checkerId = checkerId;
        this.narrative = narrative;
        this.remittanceInformation = remittanceInformation;
    }

    @JsonProperty("checkerId")
    public Object getCheckerId() {
        return checkerId;
    }

    @JsonProperty("checkerId")
    public void setCheckerId(Object checkerId) {
        this.checkerId = checkerId;
    }

    public PaymentPurpose withCheckerId(Object checkerId) {
        this.checkerId = checkerId;
        return this;
    }

    @JsonProperty("narrative")
    public String getNarrative() {
        return narrative;
    }

    @JsonProperty("narrative")
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public PaymentPurpose withNarrative(String narrative) {
        this.narrative = narrative;
        return this;
    }

    @JsonProperty("remittanceInformation")
    public String getRemittanceInformation() {
        return remittanceInformation;
    }

    @JsonProperty("remittanceInformation")
    public void setRemittanceInformation(String remittanceInformation) {
        this.remittanceInformation = remittanceInformation;
    }

    public PaymentPurpose withRemittanceInformation(String remittanceInformation) {
        this.remittanceInformation = remittanceInformation;
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

    public PaymentPurpose withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentPurpose.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("checkerId");
        sb.append('=');
        sb.append(((this.checkerId == null) ? "<null>" : this.checkerId));
        sb.append(',');
        sb.append("narrative");
        sb.append('=');
        sb.append(((this.narrative == null) ? "<null>" : this.narrative));
        sb.append(',');
        sb.append("remittanceInformation");
        sb.append('=');
        sb.append(((this.remittanceInformation == null) ? "<null>" : this.remittanceInformation));
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
        result = ((result * 31) + ((this.checkerId == null) ? 0 : this.checkerId.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.remittanceInformation == null) ? 0 : this.remittanceInformation.hashCode()));
        result = ((result * 31) + ((this.narrative == null) ? 0 : this.narrative.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentPurpose) == false) {
            return false;
        }
        PaymentPurpose rhs = ((PaymentPurpose) other);
        return (
            (
                (
                    ((this.checkerId == rhs.checkerId) || ((this.checkerId != null) && this.checkerId.equals(rhs.checkerId))) &&
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    )
                ) &&
                (
                    (this.remittanceInformation == rhs.remittanceInformation) ||
                    ((this.remittanceInformation != null) && this.remittanceInformation.equals(rhs.remittanceInformation))
                )
            ) &&
            ((this.narrative == rhs.narrative) || ((this.narrative != null) && this.narrative.equals(rhs.narrative)))
        );
    }
}
