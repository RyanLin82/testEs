package org.cmsideproject.minerva.entity;
//package org.cmsideproject.minera.entity;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//
//@Document(indexName = "sum_201808", type = "")
//public class TicketSumary {
//
//	@Id
//	private String id;
//	
//	private String baAssignee;
//	private String baAssigneeKeyword;
//	private String baGroup;
//	private String baGroupKeyword;
//	private String component;
//	private String componentKeyword;
//	private String devAssignee;
//	private String devAssigneeKeyword;
//	private String devGroup;
//	private String devGroupKeyword;
//	private String devLocation;
//
//	private String devLocationKeyword;
//	private String Exception;
//	private String jira;
//	private String jiraKeyword;
//	private String keyword;
//	private String keywordKeyword;
//	private String label;
//	private String labelKeyword;
//	private String needMoreInfo;
//
//	private String qaAssignee;
//	private String qaAssigneeKeyword;
//	private String qaGroup;
//	private String qaGroupKeyword;
//
//	private String redo;
//
//	private String slaBa;
//	private String slaBaTF;
//	private String slaBaTFKeyword;
//
//	private String slaDev;
//	private String slaDevD;
//	private String slaDevKeyword;
//
//	private String slaQa;
//	private String slaQaD;
//	private String slaQaTF;
//	private String slaQaTFKeyword;
//
//	private String status;
//	private String statusKeyword;
//
//	private String testFail;
//	private String totalBaInProgressTime;
//	private String totalDevBlocked;
//	private String totalDevInProgressTime;
//
//	private String totalExceptionTime;
//	private String totalQAInProgressTime;
//	private String TotalWaitForDEVTime;
//	private String TotalWaitForQATime;
//	private String type;
//	private String typeKeyword;
//	public String getBaAssignee() {
//		return baAssignee;
//	}
//	public void setBaAssignee(String baAssignee) {
//		this.baAssignee = baAssignee;
//	}
//	public String getBaAssigneeKeyword() {
//		return baAssigneeKeyword;
//	}
//	public void setBaAssigneeKeyword(String baAssigneeKeyword) {
//		this.baAssigneeKeyword = baAssigneeKeyword;
//	}
//	public String getBaGroup() {
//		return baGroup;
//	}
//	public void setBaGroup(String baGroup) {
//		this.baGroup = baGroup;
//	}
//	public String getBaGroupKeyword() {
//		return baGroupKeyword;
//	}
//	public void setBaGroupKeyword(String baGroupKeyword) {
//		this.baGroupKeyword = baGroupKeyword;
//	}
//	public String getComponent() {
//		return component;
//	}
//	public void setComponent(String component) {
//		this.component = component;
//	}
//	public String getComponentKeyword() {
//		return componentKeyword;
//	}
//	public void setComponentKeyword(String componentKeyword) {
//		this.componentKeyword = componentKeyword;
//	}
//	public String getDevAssignee() {
//		return devAssignee;
//	}
//	public void setDevAssignee(String devAssignee) {
//		this.devAssignee = devAssignee;
//	}
//	public String getDevAssigneeKeyword() {
//		return devAssigneeKeyword;
//	}
//	public void setDevAssigneeKeyword(String devAssigneeKeyword) {
//		this.devAssigneeKeyword = devAssigneeKeyword;
//	}
//	public String getDevGroup() {
//		return devGroup;
//	}
//	public void setDevGroup(String devGroup) {
//		this.devGroup = devGroup;
//	}
//	public String getDevGroupKeyword() {
//		return devGroupKeyword;
//	}
//	public void setDevGroupKeyword(String devGroupKeyword) {
//		this.devGroupKeyword = devGroupKeyword;
//	}
//	public String getDevLocation() {
//		return devLocation;
//	}
//	public void setDevLocation(String devLocation) {
//		this.devLocation = devLocation;
//	}
//	public String getDevLocationKeyword() {
//		return devLocationKeyword;
//	}
//	public void setDevLocationKeyword(String devLocationKeyword) {
//		this.devLocationKeyword = devLocationKeyword;
//	}
//	public String getException() {
//		return Exception;
//	}
//	public void setException(String exception) {
//		Exception = exception;
//	}
//	public String getJira() {
//		return jira;
//	}
//	public void setJira(String jira) {
//		this.jira = jira;
//	}
//	public String getJiraKeyword() {
//		return jiraKeyword;
//	}
//	public void setJiraKeyword(String jiraKeyword) {
//		this.jiraKeyword = jiraKeyword;
//	}
//	public String getKeyword() {
//		return keyword;
//	}
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
//	public String getKeywordKeyword() {
//		return keywordKeyword;
//	}
//	public void setKeywordKeyword(String keywordKeyword) {
//		this.keywordKeyword = keywordKeyword;
//	}
//	public String getLabel() {
//		return label;
//	}
//	public void setLabel(String label) {
//		this.label = label;
//	}
//	public String getLabelKeyword() {
//		return labelKeyword;
//	}
//	public void setLabelKeyword(String labelKeyword) {
//		this.labelKeyword = labelKeyword;
//	}
//	public String getNeedMoreInfo() {
//		return needMoreInfo;
//	}
//	public void setNeedMoreInfo(String needMoreInfo) {
//		this.needMoreInfo = needMoreInfo;
//	}
//	public String getQaAssignee() {
//		return qaAssignee;
//	}
//	public void setQaAssignee(String qaAssignee) {
//		this.qaAssignee = qaAssignee;
//	}
//	public String getQaAssigneeKeyword() {
//		return qaAssigneeKeyword;
//	}
//	public void setQaAssigneeKeyword(String qaAssigneeKeyword) {
//		this.qaAssigneeKeyword = qaAssigneeKeyword;
//	}
//	public String getQaGroup() {
//		return qaGroup;
//	}
//	public void setQaGroup(String qaGroup) {
//		this.qaGroup = qaGroup;
//	}
//	public String getQaGroupKeyword() {
//		return qaGroupKeyword;
//	}
//	public void setQaGroupKeyword(String qaGroupKeyword) {
//		this.qaGroupKeyword = qaGroupKeyword;
//	}
//	public String getRedo() {
//		return redo;
//	}
//	public void setRedo(String redo) {
//		this.redo = redo;
//	}
//	public String getSlaBa() {
//		return slaBa;
//	}
//	public void setSlaBa(String slaBa) {
//		this.slaBa = slaBa;
//	}
//	public String getSlaBaTF() {
//		return slaBaTF;
//	}
//	public void setSlaBaTF(String slaBaTF) {
//		this.slaBaTF = slaBaTF;
//	}
//	public String getSlaBaTFKeyword() {
//		return slaBaTFKeyword;
//	}
//	public void setSlaBaTFKeyword(String slaBaTFKeyword) {
//		this.slaBaTFKeyword = slaBaTFKeyword;
//	}
//	public String getSlaDev() {
//		return slaDev;
//	}
//	public void setSlaDev(String slaDev) {
//		this.slaDev = slaDev;
//	}
//	public String getSlaDevD() {
//		return slaDevD;
//	}
//	public void setSlaDevD(String slaDevD) {
//		this.slaDevD = slaDevD;
//	}
//	public String getSlaDevKeyword() {
//		return slaDevKeyword;
//	}
//	public void setSlaDevKeyword(String slaDevKeyword) {
//		this.slaDevKeyword = slaDevKeyword;
//	}
//	public String getSlaQa() {
//		return slaQa;
//	}
//	public void setSlaQa(String slaQa) {
//		this.slaQa = slaQa;
//	}
//	public String getSlaQaD() {
//		return slaQaD;
//	}
//	public void setSlaQaD(String slaQaD) {
//		this.slaQaD = slaQaD;
//	}
//	public String getSlaQaTF() {
//		return slaQaTF;
//	}
//	public void setSlaQaTF(String slaQaTF) {
//		this.slaQaTF = slaQaTF;
//	}
//	public String getSlaQaTFKeyword() {
//		return slaQaTFKeyword;
//	}
//	public void setSlaQaTFKeyword(String slaQaTFKeyword) {
//		this.slaQaTFKeyword = slaQaTFKeyword;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getStatusKeyword() {
//		return statusKeyword;
//	}
//	public void setStatusKeyword(String statusKeyword) {
//		this.statusKeyword = statusKeyword;
//	}
//	public String getTestFail() {
//		return testFail;
//	}
//	public void setTestFail(String testFail) {
//		this.testFail = testFail;
//	}
//	public String getTotalBaInProgressTime() {
//		return totalBaInProgressTime;
//	}
//	public void setTotalBaInProgressTime(String totalBaInProgressTime) {
//		this.totalBaInProgressTime = totalBaInProgressTime;
//	}
//	public String getTotalDevBlocked() {
//		return totalDevBlocked;
//	}
//	public void setTotalDevBlocked(String totalDevBlocked) {
//		this.totalDevBlocked = totalDevBlocked;
//	}
//	public String getTotalDevInProgressTime() {
//		return totalDevInProgressTime;
//	}
//	public void setTotalDevInProgressTime(String totalDevInProgressTime) {
//		this.totalDevInProgressTime = totalDevInProgressTime;
//	}
//	public String getTotalExceptionTime() {
//		return totalExceptionTime;
//	}
//	public void setTotalExceptionTime(String totalExceptionTime) {
//		this.totalExceptionTime = totalExceptionTime;
//	}
//	public String getTotalQAInProgressTime() {
//		return totalQAInProgressTime;
//	}
//	public void setTotalQAInProgressTime(String totalQAInProgressTime) {
//		this.totalQAInProgressTime = totalQAInProgressTime;
//	}
//	public String getTotalWaitForDEVTime() {
//		return TotalWaitForDEVTime;
//	}
//	public void setTotalWaitForDEVTime(String totalWaitForDEVTime) {
//		TotalWaitForDEVTime = totalWaitForDEVTime;
//	}
//	public String getTotalWaitForQATime() {
//		return TotalWaitForQATime;
//	}
//	public void setTotalWaitForQATime(String totalWaitForQATime) {
//		TotalWaitForQATime = totalWaitForQATime;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getTypeKeyword() {
//		return typeKeyword;
//	}
//	public void setTypeKeyword(String typeKeyword) {
//		this.typeKeyword = typeKeyword;
//	}
//	
//	
//}
