package org.cmsideproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Document(indexName = "test_sum_201809", type="_doc", createIndex = true)
@Document(indexName = "test_#{suffix.getValue()}", type="_doc", createIndex = true)
public class TestTicketSumary {

	@Id
    private String id;
	
	@JsonProperty("jiraId")
	private String jiraId;

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("component")
	private String component;
	
	@JsonProperty("label")
	private String label;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("ba_assignee")
	private String ba_assignee;

	@JsonProperty("dev_assignee")
	private String dev_assignee;

	@JsonProperty("qa_assignee")
	private String qa_assignee; 	
	
//	public TestTicketSumary(TestTicketSumaryBuilder builder) {
//		this.jiraId = builder.jiraId;
//		this.type = builder.type;
//		this.component = builder.component;;
//		this.label = builder.label;
//		this.status = builder.status;
//		this.ba_assignee = builder.ba_assignee;
//		this.dev_assignee = builder.dev_assignee;
//		this.qa_assignee = builder.qa_assignee;
//	}
	
	public static class TestTicketSumaryBuilder{	
		TestTicketSumary ticket;
		
		public TestTicketSumaryBuilder() {
			ticket = new TestTicketSumary();
		}
		
		/**
		 * Set jira in analyzed ticket. Default value is an empty string </p>
		 * @param jira the jira to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setJiraId(String jiraId) {
			this.ticket.setJiraId(jiraId);
			return this;
		}
		
		/**
		 * Set type in analyzed ticket. Default value is an empty string </p>
		 * @param type the type to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setType(String type) {
			this.ticket.setType(type);
			return this;
		}
		
		/**
		 * Set component in analyzed ticket. Default value is an empty string </p>
		 * @param component the component to set
		 * @return AnalyzedSumaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setComponent(String component) {
			this.ticket.setComponent(component);
			return this;
		}
		
		/**
		 * Set label in analyzed ticket. Default value is an empty string </p>
		 * @param label the label to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setLabel(String label) {
			this.ticket.setLabel(label);
			return this;
		}
		
		/**
		 * Set status in analyzed ticket. Default value is an empty string </p>
		 * @param status the status to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setStatus(String status) {
			this.ticket.setStatus(status);
			return this;
		}
		
		/**
		 * Set ba_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param ba_assignee the ba_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setBa_assignee(String ba_assignee) {
			this.ticket.setBa_Assignee(ba_assignee);
			return this;
		}
		
		/**
		 * Set dev_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param dev_assignee the dev_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setDev_assignee(String dev_assignee) {
			this.ticket.setDev_Assignee(dev_assignee);
			return this;
		}
		
		/**
		 * Set qa_assignee in analyzed ticket. Default value is an empty string </p>
		 * @param qa_assignee the qa_assignee to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public TestTicketSumaryBuilder setQa_assignee(String qa_assignee) {
			this.ticket.setQa_Assignee(qa_assignee);
			return this;
		}
		
		public TestTicketSumary build() {
			return this.ticket;
		}
		
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getJiraId() {
		return jiraId;
	}


	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getBa_Assignee() {
		return ba_assignee;
	}


	public void setBa_Assignee(String ba_Assignee) {
		this.ba_assignee = ba_Assignee;
	}


	public String getDev_Assignee() {
		return dev_assignee;
	}


	public void setDev_Assignee(String dev_Assignee) {
		this.dev_assignee = dev_Assignee;
	}


	public String getQa_Assignee() {
		return qa_assignee;
	}


	public void setQa_Assignee(String qa_Assignee) {
		this.qa_assignee = qa_Assignee;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.jiraId).append("]").append(" : ");
		sb.append(this.component);
		return sb.toString();
	}
}
