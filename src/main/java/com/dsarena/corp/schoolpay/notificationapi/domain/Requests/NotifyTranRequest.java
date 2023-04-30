package com.dsarena.corp.schoolpay.notificationapi.domain.Requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    {
        "dateCreated",
        "recordId",
        "schoolcode",
        "schoolname",
        "schoolpayReceiptNumber",
        "sourcePaymentChannelCode",
        "sourceTransactionId",
        "studentCode",
        "studentName",
    }
)
@Generated("jsonschema2pojo")
public class NotifyTranRequest {

    @JsonProperty("dateCreated")
    private String dateCreated;

    @JsonProperty("recordId")
    private Integer recordId;

    @JsonProperty("schoolcode")
    private Integer schoolcode;

    @JsonProperty("schoolname")
    private String schoolname;

    @JsonProperty("schoolpayReceiptNumber")
    private Integer schoolpayReceiptNumber;

    @JsonProperty("sourcePaymentChannelCode")
    private String sourcePaymentChannelCode;

    @JsonProperty("sourceTransactionId")
    private Long sourceTransactionId;

    @JsonProperty("studentCode")
    private String studentCode;

    @JsonProperty("studentName")
    private String studentName;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("dateCreated")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("dateCreated")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("recordId")
    public Integer getRecordId() {
        return recordId;
    }

    @JsonProperty("recordId")
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @JsonProperty("schoolcode")
    public Integer getSchoolcode() {
        return schoolcode;
    }

    @JsonProperty("schoolcode")
    public void setSchoolcode(Integer schoolcode) {
        this.schoolcode = schoolcode;
    }

    @JsonProperty("schoolname")
    public String getSchoolname() {
        return schoolname;
    }

    @JsonProperty("schoolname")
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @JsonProperty("schoolpayReceiptNumber")
    public Integer getSchoolpayReceiptNumber() {
        return schoolpayReceiptNumber;
    }

    @JsonProperty("schoolpayReceiptNumber")
    public void setSchoolpayReceiptNumber(Integer schoolpayReceiptNumber) {
        this.schoolpayReceiptNumber = schoolpayReceiptNumber;
    }

    @JsonProperty("sourcePaymentChannelCode")
    public String getSourcePaymentChannelCode() {
        return sourcePaymentChannelCode;
    }

    @JsonProperty("sourcePaymentChannelCode")
    public void setSourcePaymentChannelCode(String sourcePaymentChannelCode) {
        this.sourcePaymentChannelCode = sourcePaymentChannelCode;
    }

    @JsonProperty("sourceTransactionId")
    public Long getSourceTransactionId() {
        return sourceTransactionId;
    }

    @JsonProperty("sourceTransactionId")
    public void setSourceTransactionId(Long sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    @JsonProperty("studentCode")
    public String getStudentCode() {
        return studentCode;
    }

    @JsonProperty("studentCode")
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @JsonProperty("studentName")
    public String getStudentName() {
        return studentName;
    }

    @JsonProperty("studentName")
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyTranRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dateCreated");
        sb.append('=');
        sb.append(((this.dateCreated == null) ? "<null>" : this.dateCreated));
        sb.append(',');
        sb.append("recordId");
        sb.append('=');
        sb.append(((this.recordId == null) ? "<null>" : this.recordId));
        sb.append(',');
        sb.append("schoolcode");
        sb.append('=');
        sb.append(((this.schoolcode == null) ? "<null>" : this.schoolcode));
        sb.append(',');
        sb.append("schoolname");
        sb.append('=');
        sb.append(((this.schoolname == null) ? "<null>" : this.schoolname));
        sb.append(',');
        sb.append("schoolpayReceiptNumber");
        sb.append('=');
        sb.append(((this.schoolpayReceiptNumber == null) ? "<null>" : this.schoolpayReceiptNumber));
        sb.append(',');
        sb.append("sourcePaymentChannelCode");
        sb.append('=');
        sb.append(((this.sourcePaymentChannelCode == null) ? "<null>" : this.sourcePaymentChannelCode));
        sb.append(',');
        sb.append("sourceTransactionId");
        sb.append('=');
        sb.append(((this.sourceTransactionId == null) ? "<null>" : this.sourceTransactionId));
        sb.append(',');
        sb.append("studentCode");
        sb.append('=');
        sb.append(((this.studentCode == null) ? "<null>" : this.studentCode));
        sb.append(',');
        sb.append("studentName");
        sb.append('=');
        sb.append(((this.studentName == null) ? "<null>" : this.studentName));
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
}
