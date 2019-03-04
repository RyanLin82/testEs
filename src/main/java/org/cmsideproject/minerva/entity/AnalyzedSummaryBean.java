package org.cmsideproject.minerva.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AnalyzedSummaryBean contains fields in the main tickets as well as accumulated SLA related date. <p>
 */
public class AnalyzedSummaryBean{

	@Id
    private String id;
	
	@JsonProperty("JiraId")
	private String jiraId;

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("component")
	private String component;
	
	@JsonProperty("label")
	private String label;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("Ba_Assignee")
	private String ba_assignee;

	@JsonProperty("dev_Assignee")
	private String dev_assignee;

	@JsonProperty("qa_Assignee")
	private String qa_assignee; 	
	
	public AnalyzedSummaryBean(AnalyzedSummaryBeanBuilder builder) {
		this.jiraId = builder.jiraId;
		this.type = builder.type;
		this.component = builder.component;;
		this.label = builder.label;
		this.status = builder.status;
		this.ba_assignee = builder.ba_assignee;
		this.dev_assignee = builder.dev_assignee;
		this.qa_assignee = builder.qa_assignee;
	}
	
	public static class AnalyzedSummaryBeanBuilder{
		private String jiraId = "";
		private String type = "";
		private String component = ""; 	
		private String label = ""; 	
		private String status = ""; 	
		private String ba_assignee = ""; 
		private String dev_assignee = ""; 	
		private String qa_assignee = ""; 	
		
		/**
		 * Set jira in analyzed ticket. Default value is an empty string </p>
		 * @param jira the jira to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setJira(String jiraId) {
			this.jiraId = jiraId;
			return this;
		}
		
		/**
		 * Set type in analyzed ticket. Default value is an empty string </p>
		 * @param type the type to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setType(String type) {
			this.type = type;
			return this;
		}
		
		/**
		 * Set component in analyzed ticket. Default value is an empty string </p>
		 * @param component the component to set
		 * @return AnalyzedSumaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setComponent(String component) {
			this.component = component;
			return this;
		}
		
		/**
		 * Set label in analyzed ticket. Default value is an empty string </p>
		 * @param label the label to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setLabel(String label) {
			this.label = label;
			return this;
		}
		
		/**
		 * Set status in analyzed ticket. Default value is an empty string </p>
		 * @param status the status to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setStatus(String status) {
			this.status = status;
			return this;
		}
		
		/**
		 * Set ba_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param ba_assignee the ba_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_assignee(String ba_assignee) {
			this.ba_assignee = ba_assignee;
			return this;
		}
		
		/**
		 * Set dev_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param dev_assignee the dev_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_assignee(String dev_assignee) {
			this.dev_assignee = dev_assignee;
			return this;
		}
		
		/**
		 * Set qa_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param qa_assignee the qa_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_assignee(String qa_assignee) {
			this.qa_assignee = qa_assignee;
			return this;
		}
		
	}

	public String getJira() {
		return jiraId;
	}

	public String getType() {
		return type;
	}

	public String getComponent() {
		return component;
	}

	public String getLabel() {
		return label;
	}

	public String getStatus() {
		return status;
	}

	public String getBa_assignee() {
		return ba_assignee;
	}

	public String getDev_assignee() {
		return dev_assignee;
	}

	public String getQa_assignee() {
		return qa_assignee;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.jiraId).append("]").append(" : ");
		sb.append(this.component);
		return sb.toString();
	}
}