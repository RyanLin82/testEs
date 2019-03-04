package org.cmsideproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "sum_201808", type="_doc", createIndex = true)
public class TicketSumaryDTO {

	@Id
    private String id;
	
//	@Column(name = "BA Assignee")
	private String baAssignee;

//	@Column(name = "BA Group")
	private String baGroup;

//	@Column(name = "Component")
	private String component;

//	@Column(name = "DEV Assignee")
	private String devAssignee;

//	@Column(name = "DEV Group")
	private String devGroup;

//	@Column(name = "DEV Location")
	private String devLocation;

//	@Column(name = "Done String")
	private String doneDate;

//	@Column(name = "Exception #")
	private long Exception;

	private String jira;

//	@Column(name = "Keyword")
	private String keyword;

//	@Column(name ="Label")
	private String Label;

//	@Column(name = "Need More Info")
	private long needMoreInfo;

//	@Column(name = "QA Assignee")
	private String qaAssignee;

//	@Column(name = "QA Group")
	private String qaGroup;

//	@Column(name = "Redo")
	private long Redo;

//	@Column(name = "SLA-BA (days)")
	private double slaBa;

//	@Column(name = "SLA-BA(T/F)")
	private String slaBaTF;

//	@Column(name = "SLA-DEV")
	private String slaDev;

//	@Column(name = "SLA-DEV (days)")
	private double slaDevD;

//	@Column(name = "SLA-QA (days)")
	private double slaQaD;

//	@Column(name = "SLA-QA(T/F)")
	private String slaQaTF;

//	@Column(name = "Status")
	private String status;

//	@Column(name = "Test Fail")
	private long testFail;

//	@Column(name = "Total BA In Progress Time (days)")
	private double totalBaInProgressTime;

//	@Column(name = "Total DEV Blocked")
	private long totalDevBlocked;

//	@Column(name = "Total DEV In Progress Time (days)")
	private double totalDevInProgressTime;

//	@Column(name = "Total Exception Time")
	private long totalExceptionTime;

//	@Column(name = "Total QA In Progress Time (days)")
	private double totalQAInProgressTime;

//	@Column(name = "Total Wait For DEV Time (days)")
	private double TotalWaitForDEVTime;

//	@Column(name = "Total Wait For QA Time (days)")
	private double TotalWaitForQATime;

//	@Column(name = "Type")
	private String Type;


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

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
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
		return Label;
	}

	public void setLabel(String label) {
		this.Label = label;
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
		return Redo;
	}

	public void setRedo(long redo) {
		this.Redo = redo;
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
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}


}
