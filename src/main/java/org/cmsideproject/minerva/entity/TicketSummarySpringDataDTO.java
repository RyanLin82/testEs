package org.cmsideproject.minerva.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "ryan_springdata_sum_201809", type = "_doc", createIndex = true)
public class TicketSummarySpringDataDTO {

	@Id
	@JsonProperty("id")
    private String id;
	
	@JsonProperty("BA_Assignee")
	private String baAssignee;

	@JsonProperty("BA_Group")
	private String baGroup;

	@JsonProperty("BA_Excluded")
	private String baExcluded;

	@JsonProperty("BA_Location")
	private String baLocation;

	@JsonProperty("BA_SLA_Days")
	private double baSlaDays;

	@JsonProperty("BA_SLA_Passed")
	private String baSlaPassed;

	@JsonProperty("BA_Total_In_Progress_Time")
	private double baTotalInProgressTime;

	@JsonProperty("Component")
	private String component;

	@JsonProperty("Comment")
	private String comment;

	@JsonProperty("DEV_Assignee")
	private String devAssignee;

	@JsonProperty("DEV_Group")
	private String devGroup;

	@JsonProperty("DEV_Excluded")
	private String devExcluded;

	@JsonProperty("DEV_Location")
	private String devLocation;

	@JsonProperty("DEV_SLA_Days")
	private double devSlaDays;

	@JsonProperty("DEV_SLA_Passed")
	private String devSlaPassed;

	@JsonProperty("DEV_Total_In_Progress_Time")
	private double devTotalInProgressTime;

	@JsonProperty("DEV_Total_Blocked_Time")
	private long devTotalBlockedTime;

	@JsonProperty("DEV_Total_Waiting_Time")
	private double devTotalWaitingTime;

	@JsonProperty("Done_Date")
	private String doneDate;

	@JsonProperty("Exception")
	private long exception;

	@JsonProperty("Exception_Total_Time")
	private double exceptionTotalTime;

	@JsonProperty("Jira")
	private String jira;

	@JsonProperty("Keyword")
	private String keyword;

	@JsonProperty("Label")
	private String label;

	@JsonProperty("Need_More_Info")
	private long needMoreInfo;

	@JsonProperty("QA_Assignee")
	private String qaAssignee;

	@JsonProperty("QA_Group")
	private String qaGroup;

	@JsonProperty("QA_Excluded")
	private String qaExcluded;

	@JsonProperty("QA_Location")
	private String qaLocation;

	@JsonProperty("QA_SLA_Days")
	private double qaSlaDays;

	@JsonProperty("QA_SLA_Passed")
	private String qaSlaPassed;

	@JsonProperty("QA_Total_In_Progress_Time")
	private double qaTotalInProgressTime;

	@JsonProperty("QA_Total_Blocked_Time")
	private double qaTotalBlockedTime;

	@JsonProperty("QA_Total_Waiting_Time")
	private double qaTotalWaitingTime;

	@JsonProperty("Redo")
	private long redo;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("Test_Fail")
	private long testFail;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Summary")
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

	public double getBaSlaDays() {
		return baSlaDays;
	}

	public void setBaSlaDays(double baSlaDays) {
		this.baSlaDays = baSlaDays;
	}

	public String getBaSlaPassed() {
		return baSlaPassed;
	}

	public void setBaSlaPassed(String baSlaPassed) {
		this.baSlaPassed = baSlaPassed;
	}

	public double getBaTotalInProgressTime() {
		return baTotalInProgressTime;
	}

	public void setBaTotalInProgressTime(double baTotalInProgressTime) {
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

	public double getDevSlaDays() {
		return devSlaDays;
	}

	public void setDevSlaDays(double devSlaDays) {
		this.devSlaDays = devSlaDays;
	}

	public String getDevSlaPassed() {
		return devSlaPassed;
	}

	public void setDevSlaPassed(String devSlaPassed) {
		this.devSlaPassed = devSlaPassed;
	}

	public double getDevTotalInProgressTime() {
		return devTotalInProgressTime;
	}

	public void setDevTotalInProgressTime(double devTotalInProgressTime) {
		this.devTotalInProgressTime = devTotalInProgressTime;
	}

	public long getDevTotalBlockedTime() {
		return devTotalBlockedTime;
	}

	public void setDevTotalBlockedTime(long devTotalBlockedTime) {
		this.devTotalBlockedTime = devTotalBlockedTime;
	}

	public double getDevTotalWaitingTime() {
		return devTotalWaitingTime;
	}

	public void setDevTotalWaitingTime(double devTotalWaitingTime) {
		this.devTotalWaitingTime = devTotalWaitingTime;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public long getException() {
		return exception;
	}

	public void setException(long exception) {
		this.exception = exception;
	}

	public double getExceptionTotalTime() {
		return exceptionTotalTime;
	}

	public void setExceptionTotalTime(double exceptionTotalTime) {
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

	public long getNeedMoreInfo() {
		return needMoreInfo;
	}

	public void setNeedMoreInfo(long needMoreInfo) {
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

	public double getQaSlaDays() {
		return qaSlaDays;
	}

	public void setQaSlaDays(double qaSlaDays) {
		this.qaSlaDays = qaSlaDays;
	}

	public String getQaSlaPassed() {
		return qaSlaPassed;
	}

	public void setQaSlaPassed(String qaSlaPassed) {
		this.qaSlaPassed = qaSlaPassed;
	}

	public double getQaTotalInProgressTime() {
		return qaTotalInProgressTime;
	}

	public void setQaTotalInProgressTime(double qaTotalInProgressTime) {
		this.qaTotalInProgressTime = qaTotalInProgressTime;
	}

	public double getQaTotalBlockedTime() {
		return qaTotalBlockedTime;
	}

	public void setQaTotalBlockedTime(double qaTotalBlockedTime) {
		this.qaTotalBlockedTime = qaTotalBlockedTime;
	}

	public double getQaTotalWaitingTime() {
		return qaTotalWaitingTime;
	}

	public void setQaTotalWaitingTime(double qaTotalWaitingTime) {
		this.qaTotalWaitingTime = qaTotalWaitingTime;
	}

	public long getRedo() {
		return redo;
	}

	public void setRedo(long redo) {
		this.redo = redo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTestFail() {
		return testFail;
	}

	public void setTestFail(long testFail) {
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

	public boolean isEmpty() {
		return StringUtils.isEmpty(jira) || StringUtils.isEmpty(baAssignee) || StringUtils.isEmpty(devAssignee)
				|| StringUtils.isEmpty(qaAssignee);
	}
}
