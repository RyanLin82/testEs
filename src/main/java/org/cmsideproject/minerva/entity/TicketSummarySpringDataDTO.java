package org.cmsideproject.minerva.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "ryan_springdata_sum_201809")
public class TicketSummarySpringDataDTO {

	@Id
    private String id;
	
	@JsonProperty("BA_Assignee")
	@Field(type = FieldType.Text, store = true, fielddata = true)
	private String baAssignee;

	@JsonProperty("BA_Group")
	@Field(type = FieldType.Text, store = true)
	private String baGroup;

	@JsonProperty("BA_Excluded")
	@Field(type = FieldType.Text, store = true)
	private String baExcluded;

	@JsonProperty("BA_Location")
	@Field(type = FieldType.Text, store = true)
	private String baLocation;

	@JsonProperty("BA_SLA_Days")
	@Field(type = FieldType.Text, store = true)
	private String baSlaDays;

	@JsonProperty("BA_SLA_Passed")
	@Field(type = FieldType.Text, store = true)
	private String baSlaPassed;

	@JsonProperty("BA_Total_In_Progress_Time")
	@Field(type = FieldType.Text, store = true)
	private String baTotalInProgressTime;

	@JsonProperty("Component")
	@Field(type = FieldType.Text, store = true)
	private String component;

	@JsonProperty("Comment")
	@Field(type = FieldType.Text, store = true)
	private String comment;

	@JsonProperty("DEV_Assignee")
	@Field(type = FieldType.Text, store = true)
	private String devAssignee;

	@JsonProperty("DEV_Group")
	@Field(type = FieldType.Text, store = true)
	private String devGroup;

	@JsonProperty("DEV_Excluded")
	@Field(type = FieldType.Text, store = true)
	private String devExcluded;

	@JsonProperty("DEV_Location")
	@Field(type = FieldType.Text, store = true)
	private String devLocation;

	@JsonProperty("DEV_SLA_Days")
	@Field(type = FieldType.Text, store = true)
	private String devSlaDays;

	@JsonProperty("DEV_SLA_Passed")
	@Field(type = FieldType.Text, store = true)
	private String devSlaPassed;

	@JsonProperty("DEV_Total_In_Progress_Time")
	@Field(type = FieldType.Text, store = true)
	private String devTotalInProgressTime;

	@JsonProperty("DEV_Total_Blocked_Time")
	@Field(type = FieldType.Text, store = true)
	private String devTotalBlockedTime;

	@JsonProperty("DEV_Total_Waiting_Time")
	@Field(type = FieldType.Text, store = true)
	private String devTotalWaitingTime;

	@JsonProperty("Done_Date")
	@Field(type = FieldType.Text, store = true)
	private String doneDate;

	@JsonProperty("Exception")
	@Field(type = FieldType.Text, store = true)
	private String exception;

	@JsonProperty("Exception_Total_Time")
	@Field(type = FieldType.Text, store = true)
	private String exceptionTotalTime;

	@JsonProperty("Jira")
	@Field(type = FieldType.Text, store = true)
	private String jira;

	@JsonProperty("Keyword")
	@Field(type = FieldType.Text, store = true)
	private String keyword;

	@JsonProperty("Label")
	@Field(type = FieldType.Text, store = true)
	private String label;

	@JsonProperty("Need_More_Info")
	@Field(type = FieldType.Text, store = true)
	private String needMoreInfo;

	@JsonProperty("QA_Assignee")
	@Field(type = FieldType.Text, store = true)
	private String qaAssignee;

	@JsonProperty("QA_Group")
	@Field(type = FieldType.Text, store = true)
	private String qaGroup;

	@JsonProperty("QA_Excluded")
	@Field(type = FieldType.Text, store = true)
	private String qaExcluded;

	@JsonProperty("QA_Location")
	@Field(type = FieldType.Text, store = true)
	private String qaLocation;

	@JsonProperty("QA_SLA_Days")
	@Field(type = FieldType.Text, store = true)
	private String qaSlaDays;

	@JsonProperty("QA_SLA_Passed")
	@Field(type = FieldType.Text, store = true)
	private String qaSlaPassed;

	@JsonProperty("QA_Total_In_Progress_Time")
	@Field(type = FieldType.Text, store = true)
	private String qaTotalInProgressTime;

	@JsonProperty("QA_Total_Blocked_Time")
	@Field(type = FieldType.Text, store = true)
	private String qaTotalBlockedTime;

	@JsonProperty("QA_Total_Waiting_Time")
	@Field(type = FieldType.Text, store = true)
	private String qaTotalWaitingTime;

	@JsonProperty("Redo")
	@Field(type = FieldType.Text, store = true)
	private String redo;

	@JsonProperty("Status")
	@Field(type = FieldType.Text, store = true)
	private String status;

	@JsonProperty("Test_Fail")
	@Field(type = FieldType.Text, store = true)
	private String testFail;

	@JsonProperty("Type")
	@Field(type = FieldType.Text, store = true)
	private String type;

	@JsonProperty("Summary")
	@Field(type = FieldType.Text, store = true)
	private String summary;

	public String getBaAssignee() {
		return baAssignee;
	}

	public void setBaAssignee(String baAssignee) {
		this.baAssignee = baAssignee;
	}

	public String getBaGroup() {
		return baGroup;
	}

	public void setBaGroup(String baGroup) {
		this.baGroup = baGroup;
	}

	public String getBaExcluded() {
		return baExcluded;
	}

	public void setBaExcluded(String baExcluded) {
		this.baExcluded = baExcluded;
	}

	public String getBaLocation() {
		return baLocation;
	}

	public void setBaLocation(String baLocation) {
		this.baLocation = baLocation;
	}

	public String getBaSlaDays() {
		return baSlaDays;
	}

	public void setBaSlaDays(String baSlaDays) {
		this.baSlaDays = baSlaDays;
	}

	public String getBaSlaPassed() {
		return baSlaPassed;
	}

	public void setBaSlaPassed(String baSlaPassed) {
		this.baSlaPassed = baSlaPassed;
	}

	public String getBaTotalInProgressTime() {
		return baTotalInProgressTime;
	}

	public void setBaTotalInProgressTime(String baTotalInProgressTime) {
		this.baTotalInProgressTime = baTotalInProgressTime;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDevAssignee() {
		return devAssignee;
	}

	public void setDevAssignee(String devAssignee) {
		this.devAssignee = devAssignee;
	}

	public String getDevGroup() {
		return devGroup;
	}

	public void setDevGroup(String devGroup) {
		this.devGroup = devGroup;
	}

	public String getDevExcluded() {
		return devExcluded;
	}

	public void setDevExcluded(String devExcluded) {
		this.devExcluded = devExcluded;
	}

	public String getDevLocation() {
		return devLocation;
	}

	public void setDevLocation(String devLocation) {
		this.devLocation = devLocation;
	}

	public String getDevSlaDays() {
		return devSlaDays;
	}

	public void setDevSlaDays(String devSlaDays) {
		this.devSlaDays = devSlaDays;
	}

	public String getDevSlaPassed() {
		return devSlaPassed;
	}

	public void setDevSlaPassed(String devSlaPassed) {
		this.devSlaPassed = devSlaPassed;
	}

	public String getDevTotalInProgressTime() {
		return devTotalInProgressTime;
	}

	public void setDevTotalInProgressTime(String devTotalInProgressTime) {
		this.devTotalInProgressTime = devTotalInProgressTime;
	}

	public String getDevTotalBlockedTime() {
		return devTotalBlockedTime;
	}

	public void setDevTotalBlockedTime(String devTotalBlockedTime) {
		this.devTotalBlockedTime = devTotalBlockedTime;
	}

	public String getDevTotalWaitingTime() {
		return devTotalWaitingTime;
	}

	public void setDevTotalWaitingTime(String devTotalWaitingTime) {
		this.devTotalWaitingTime = devTotalWaitingTime;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getExceptionTotalTime() {
		return exceptionTotalTime;
	}

	public void setExceptionTotalTime(String exceptionTotalTime) {
		this.exceptionTotalTime = exceptionTotalTime;
	}

	public String getJira() {
		return jira;
	}

	public void setJira(String jira) {
		this.jira = jira;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNeedMoreInfo() {
		return needMoreInfo;
	}

	public void setNeedMoreInfo(String needMoreInfo) {
		this.needMoreInfo = needMoreInfo;
	}

	public String getQaAssignee() {
		return qaAssignee;
	}

	public void setQaAssignee(String qaAssignee) {
		this.qaAssignee = qaAssignee;
	}

	public String getQaGroup() {
		return qaGroup;
	}

	public void setQaGroup(String qaGroup) {
		this.qaGroup = qaGroup;
	}

	public String getQaExcluded() {
		return qaExcluded;
	}

	public void setQaExcluded(String qaExcluded) {
		this.qaExcluded = qaExcluded;
	}

	public String getQaLocation() {
		return qaLocation;
	}

	public void setQaLocation(String qaLocation) {
		this.qaLocation = qaLocation;
	}

	public String getQaSlaDays() {
		return qaSlaDays;
	}

	public void setQaSlaDays(String qaSlaDays) {
		this.qaSlaDays = qaSlaDays;
	}

	public String getQaSlaPassed() {
		return qaSlaPassed;
	}

	public void setQaSlaPassed(String qaSlaPassed) {
		this.qaSlaPassed = qaSlaPassed;
	}

	public String getQaTotalInProgressTime() {
		return qaTotalInProgressTime;
	}

	public void setQaTotalInProgressTime(String qaTotalInProgressTime) {
		this.qaTotalInProgressTime = qaTotalInProgressTime;
	}

	public String getQaTotalBlockedTime() {
		return qaTotalBlockedTime;
	}

	public void setQaTotalBlockedTime(String qaTotalBlockedTime) {
		this.qaTotalBlockedTime = qaTotalBlockedTime;
	}

	public String getQaTotalWaitingTime() {
		return qaTotalWaitingTime;
	}

	public void setQaTotalWaitingTime(String qaTotalWaitingTime) {
		this.qaTotalWaitingTime = qaTotalWaitingTime;
	}

	public String getRedo() {
		return redo;
	}

	public void setRedo(String redo) {
		this.redo = redo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestFail() {
		return testFail;
	}

	public void setTestFail(String testFail) {
		this.testFail = testFail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	
	
}
