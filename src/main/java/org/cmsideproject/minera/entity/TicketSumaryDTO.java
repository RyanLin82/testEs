package org.cmsideproject.minera.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketSumaryDTO {


	@JsonProperty("BA Assignee")
	private String baAssignee;

	@JsonProperty("BA Group")
	private String baGroup;

	@JsonProperty("Component")
	private String component;

	@JsonProperty("DEV Assignee")
	private String devAssignee;

	@JsonProperty("DEV Group")
	private String devGroup;

	@JsonProperty("DEV Location")
	private String devLocation;

	@JsonProperty("Done Date")
	private Date doneDate;

	@JsonProperty("Exception #")
	private long Exception;

	@JsonProperty("Jira")
	private String jira;

	@JsonProperty("Keyword")
	private String keyword;

	@JsonProperty("Label")
	private String label;

	@JsonProperty("Need More Info")
	private long needMoreInfo;

	@JsonProperty("QA Assignee")
	private String qaAssignee;

	@JsonProperty("QA Group")
	private String qaGroup;

	@JsonProperty("Redo")
	private long redo;

	@JsonProperty("SLA-BA (days)")
	private double slaBa;

	@JsonProperty("SLA-BA(T/F)")
	private String slaBaTF;

	@JsonProperty("SLA-DEV")
	private String slaDev;

	@JsonProperty("SLA-DEV (days)")
	private double slaDevD;

	@JsonProperty("SLA-QA (days)")
	private double slaQaD;

	@JsonProperty("SLA-QA(T/F)")
	private String slaQaTF;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("Test Fail")
	private long testFail;

	@JsonProperty("Total BA In Progress Time (days)")
	private double totalBaInProgressTime;

	@JsonProperty("Total DEV Blocked")
	private long totalDevBlocked;

	@JsonProperty("Total DEV In Progress Time (days)")
	private double totalDevInProgressTime;

	@JsonProperty("Total Exception Time")
	private long totalExceptionTime;

	@JsonProperty("Total QA In Progress Time (days)")
	private double totalQAInProgressTime;

	@JsonProperty("Total Wait For DEV Time (days)")
	private double TotalWaitForDEVTime;

	@JsonProperty("Total Wait For QA Time (days)")
	private double TotalWaitForQATime;

	@JsonProperty("Type")
	private String type;


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

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
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

	public String getDevLocation() {
		return devLocation;
	}

	public void setDevLocation(String devLocation) {
		this.devLocation = devLocation;
	}

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	public long getException() {
		return Exception;
	}

	public void setException(long exception) {
		Exception = exception;
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

	public long getRedo() {
		return redo;
	}

	public void setRedo(long redo) {
		this.redo = redo;
	}

	public double getSlaBa() {
		return slaBa;
	}

	public void setSlaBa(double slaBa) {
		this.slaBa = slaBa;
	}

	public String getSlaBaTF() {
		return slaBaTF;
	}

	public void setSlaBaTF(String slaBaTF) {
		this.slaBaTF = slaBaTF;
	}

	public String getSlaDev() {
		return slaDev;
	}

	public void setSlaDev(String slaDev) {
		this.slaDev = slaDev;
	}

	public double getSlaDevD() {
		return slaDevD;
	}

	public void setSlaDevD(double slaDevD) {
		this.slaDevD = slaDevD;
	}

	public double getSlaQaD() {
		return slaQaD;
	}

	public void setSlaQaD(double slaQaD) {
		this.slaQaD = slaQaD;
	}

	public String getSlaQaTF() {
		return slaQaTF;
	}

	public void setSlaQaTF(String slaQaTF) {
		this.slaQaTF = slaQaTF;
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

	public double getTotalBaInProgressTime() {
		return totalBaInProgressTime;
	}

	public void setTotalBaInProgressTime(double totalBaInProgressTime) {
		this.totalBaInProgressTime = totalBaInProgressTime;
	}

	public long getTotalDevBlocked() {
		return totalDevBlocked;
	}

	public void setTotalDevBlocked(long totalDevBlocked) {
		this.totalDevBlocked = totalDevBlocked;
	}

	public double getTotalDevInProgressTime() {
		return totalDevInProgressTime;
	}

	public void setTotalDevInProgressTime(double totalDevInProgressTime) {
		this.totalDevInProgressTime = totalDevInProgressTime;
	}

	public long getTotalExceptionTime() {
		return totalExceptionTime;
	}

	public void setTotalExceptionTime(long totalExceptionTime) {
		this.totalExceptionTime = totalExceptionTime;
	}

	public double getTotalQAInProgressTime() {
		return totalQAInProgressTime;
	}

	public void setTotalQAInProgressTime(double totalQAInProgressTime) {
		this.totalQAInProgressTime = totalQAInProgressTime;
	}

	public double getTotalWaitForDEVTime() {
		return TotalWaitForDEVTime;
	}

	public void setTotalWaitForDEVTime(double totalWaitForDEVTime) {
		TotalWaitForDEVTime = totalWaitForDEVTime;
	}

	public double getTotalWaitForQATime() {
		return TotalWaitForQATime;
	}

	public void setTotalWaitForQATime(double totalWaitForQATime) {
		TotalWaitForQATime = totalWaitForQATime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
