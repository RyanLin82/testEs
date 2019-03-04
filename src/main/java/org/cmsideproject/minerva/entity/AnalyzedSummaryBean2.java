package org.cmsideproject.minerva.entity;
import java.util.Date;

/**
 * AnalyzedSummaryBean contains fields in the main tickets as well as accumulated SLA related date. <p>
 */
public class AnalyzedSummaryBean2{

	// fields in main ticket body
	/**
	 * ticket number, like CZ-1111
	 */
	private String jira = "";
	
	/**
	 * ticket summary description
	 */
	private String summary= "";
	
	/**
	 * ticket type, such as story, bug....
	 */
	private String type = "";		
	
	/**
	 * ticket components, such as Bridge, CM Configuration, PM Configuration ...
	 */
	private String component = ""; 	
	
	/**
	 * ticket keyword define in {@code CommentIdentify.Keyword}
	 */
	private String keyword = ""; 	
	
	/**
	 * ticket labels added by user
	 */
	private String label = ""; 	
	
	/**
	 * ticket current status
	 */
	private String status = ""; 	
	
	/**
	 * ticket marked done / story accepted time
	 */
	private Date done_date = null;	
	
	// counters within life cycle
	/**
	 * counter for need more info
	 */
	private int need_more_info = 0; 		
	
	/**
	 * counter for test failure
	 */
	private int test_fail = 0;	
	
	/**
	 * counter for redo
	 */
	private int redo = 0;			
	
	// information for BA
	/**
	 * ba assignee, which is also ba reporter
	 */
	private String ba_assignee = ""; 	
	
	/**
	 * ba location, where the BA located, sucn as onshore / offshore
	 */
	private String ba_location = ""; 	
	
	/**
	 * ba group, who has ever touched this ticket as BA
	 */
	private String ba_group = ""; 	
	
	/**
	 * ba total in progress time (as days), format as .##
	 */
	private double ba_total_in_progress_time = 0; 	
	
	/**
	 * ba sla overdue days, format as .##
	 */
	private double ba_sla_days = 0;
	
	/**
	 * ba sla passed or not, true for passed
	 */
	private boolean ba_sla_passed = true;	
	
	// information for DEV
	/**
	 * dev assignee, usually the one who should take responsibility of the ticket on dev
	 */
	private String dev_assignee = ""; 	
	
	/**
	 * dev location, where the DEV located, sucn as onshore / offshore
	 */
	private String dev_location = ""; 	
	
	/**
	 * dev group, who has ever touched this ticket as DEV
	 */
	private String dev_group = ""; 	
	
	/**
	 * dev total waiting time (as days), format as .##
	 */
	private double dev_total_waiting_time = 0; 	
	
	/**
	 * dev total in progress time (as days), format as .##
	 */
	private double dev_total_in_progress_time = 0;
	
	/**
	 * dev total blocked time (as days), format as .##
	 */
	private double dev_total_blocked_time = 0;
	
	/**
	 * dev sla overdue days, format as .##
	 */
	private double dev_sla_days = 0;
	
	/**
	 * dev sla passed or not, true for passed
	 */
	private boolean dev_sla_passed = true;
	
	// information for QA
	/**
	 * qa assignee, usually the one who should take responsibility of the ticket on qa
	 */
	private String qa_assignee = ""; 	
	
	/**
	 * qa location, where the QA located, sucn as onshore / offshore
	 */
	private String qa_location = ""; 	
	
	/**
	 * qa group, who has ever touched this ticket as QA
	 */
	private String qa_group = ""; 	
	
	/**
	 * qa total waiting time (as days), format as .##
	 */
	private double qa_total_waiting_time = 0;
	
	/**
	 * qa total in progress time (as days), format as .##
	 */
	private double qa_total_in_progress_time = 0;
	
	/**
	 * qa total blocked time (as days), format as .##
	 */
	private double qa_total_blocked_time = 0;
	
	/**
	 * qa sla overdue days, format as .##
	 */
	private double qa_sla_days = 0;
	
	/**
	 * qa sla passed or not, true for passed
	 */
	private boolean qa_sla_passed = true;
	
	// exception records
	/**
	 * number of exceptions in ticket life cycle
	 */
	private int exceptions = 0;		
	
	/**
	 * total exception time (as days), format as .##
	 */
	private double exception_total_time = 0;
	
	// exclusion per role with comment (will be judged manually)
	/**
	 * indicate whether this ticket should not count to the original BA assignee
	 */
	private boolean ba_excluded = false;
	
	/**
	 * indicate whether this ticket should not count to the original DEV assignee
	 */
	private boolean dev_excluded = false;
	
	/**
	 * indicate whether this ticket should not count to the original QA assignee
	 */
	private boolean qa_excluded = false;
	
	/**
	 * comment for later manual judgments
	 */
	private String comment = ""; 	
	
	public AnalyzedSummaryBean2(AnalyzedSummaryBeanBuilder builder) {
		this.jira = builder.jira;
		this.summary = builder.summary;
		this.type = builder.type;
		this.component = builder.component;
		this.keyword = builder.keyword;
		this.label = builder.label;
		this.status = builder.status;
		this.done_date = builder.done_date;
		this.need_more_info = builder.need_more_info;
		this.test_fail = builder.test_fail;
		this.redo = builder.redo;
		this.ba_assignee = builder.ba_assignee;
		this.ba_location = builder.ba_location;
		this.ba_group = builder.ba_group;
		this.ba_total_in_progress_time = builder.ba_total_in_progress_time;
		this.ba_sla_days = builder.ba_sla_days;
		this.ba_sla_passed = builder.ba_sla_passed;
		this.dev_assignee = builder.dev_assignee;
		this.dev_location = builder.dev_location;
		this.dev_group = builder.dev_group;
		this.dev_total_waiting_time = builder.dev_total_waiting_time;
		this.dev_total_in_progress_time = builder.dev_total_in_progress_time;
		this.dev_total_blocked_time = builder.dev_total_blocked_time;
		this.dev_sla_days = builder.dev_sla_days;
		this.dev_sla_passed = builder.dev_sla_passed;
		this.qa_assignee = builder.qa_assignee;
		this.qa_location = builder.qa_location;
		this.qa_group = builder.qa_group;
		this.qa_total_waiting_time = builder.qa_total_waiting_time;
		this.qa_total_in_progress_time = builder.qa_total_in_progress_time;
		this.qa_total_blocked_time = builder.qa_total_blocked_time;
		this.qa_sla_days = builder.qa_sla_days;
		this.qa_sla_passed = builder.qa_sla_passed;
		this.exceptions = builder.exceptions;
		this.exception_total_time = builder.exception_total_time;
		this.ba_excluded = builder.ba_excluded;
		this.dev_excluded = builder.dev_excluded;
		this.qa_excluded = builder.qa_excluded;
		this.comment = builder.comment;
	}
	
	public static class AnalyzedSummaryBeanBuilder{
		private String jira = "";
		private String summary= "";
		private String type = "";
		private String component = ""; 	
		private String keyword = ""; 
		private String label = ""; 	
		private String status = ""; 
		private Date done_date = new Date();	
		private int need_more_info = 0; 
		private int test_fail = 0;	
		private int redo = 0;	
		private String ba_assignee = ""; 
		private String ba_location = ""; 	
		private String ba_group = ""; 
		private double ba_total_in_progress_time = 0; 
		private double ba_sla_days = 0;
		private boolean ba_sla_passed = true;
		private String dev_assignee = ""; 	
		private String dev_location = ""; 	
		private String dev_group = ""; 	
		private double dev_total_waiting_time = 0; 
		private double dev_total_in_progress_time = 0;
		private double dev_total_blocked_time = 0;
		private double dev_sla_days = 0;
		private boolean dev_sla_passed = true;
		private String qa_assignee = ""; 	
		private String qa_location = ""; 	
		private String qa_group = ""; 	
		private double qa_total_waiting_time = 0;
		private double qa_total_in_progress_time = 0;
		private double qa_total_blocked_time = 0;
		private double qa_sla_days = 0;
		private boolean qa_sla_passed = true;
		private int exceptions = 0;		
		private double exception_total_time = 0;
		private boolean ba_excluded = false;
		private boolean dev_excluded = false;
		private boolean qa_excluded = false;
		private String comment = "";
		
		/**
		 * Set jira in analyzed ticket. Default value is an empty string </p>
		 * @param jira the jira to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setJira(String jira) {
			this.jira = jira;
			return this;
		}
		
		/**
		 * Set summary in analyzed ticket. Default value is an empty string </p>
		 * @param summary the summary to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setSummary(String summary) {
			this.summary = summary;
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
		 * Set keyword in analyzed ticket. Default value is an empty string </p>
		 * @param keyword the keyword to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setKeyword(String keyword) {
			this.keyword = keyword;
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
		 * Set done_date in analyzed ticket. Default value is current date </p>
		 * @param done_date the done_date to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDone_date(Date done_date) {
			this.done_date = done_date;
			return this;
		}
		
		/**
		 * Set need_more_info in analyzed ticket. Default value is 0 </p>
		 * @param need_more_info the need_more_info to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setNeed_more_info(int need_more_info) {
			this.need_more_info = need_more_info;
			return this;
		}
		
		/**
		 * Set test_fail in analyzed ticket. Default value is 0 </p>
		 * @param test_fail the test_fail to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setTest_fail(int test_fail) {
			this.test_fail = test_fail;
			return this;
		}
		
		/**
		 * Set redo in analyzed ticket. Default value is 0 </p>
		 * @param redo the redo to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setRedo(int redo) {
			this.redo = redo;
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
		 * Set ba_location in analyzed ticket. Default value is an empty string </p>
		 * @param ba_location the ba_location to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_location(String ba_location) {
			this.ba_location = ba_location;
			return this;
		}
		
		/**
		 * Set ba_group in analyzed ticket. Default value is an empty string </p>
		 * @param ba_group the ba_group to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_group(String ba_group) {
			this.ba_group = ba_group;
			return this;
		}
		
		/**
		 * Set ba_total_in_progress_time in analyzed ticket. Default value is an empty string </p>
		 * @param ba_total_in_progress_time the ba_total_in_progress_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_total_in_progress_time(double ba_total_in_progress_time) {
			this.ba_total_in_progress_time = ba_total_in_progress_time;
			return this;
		}
		
		/**
		 * Set ba_sla_days in analyzed ticket. Default value is an empty string </p>
		 * @param ba_sla_days the ba_sla_days to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_sla_days(double ba_sla_days) {
			this.ba_sla_days = ba_sla_days;
			this.ba_sla_passed = (this.ba_sla_days <=0) ;
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
		 * Set dev_location in analyzed ticket. Default value is an empty string </p>
		 * @param dev_location the dev_location to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_location(String dev_location) {
			this.dev_location = dev_location;
			return this;
		}
		
		/**
		 * Set dev_group in analyzed ticket. Default value is an empty string </p>
		 * @param dev_group the dev_group to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_group(String dev_group) {
			this.dev_group = dev_group;
			return this;
		}
		
		/**
		 * Set dev_total_waiting_time in analyzed ticket. Default value is an empty string </p>
		 * @param dev_total_waiting_time the dev_total_waiting_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_total_waiting_time(double dev_total_waiting_time) {
			this.dev_total_waiting_time = dev_total_waiting_time;
			return this;
		}
		
		/**
		 * Set dev_total_in_progress_time in analyzed ticket. Default value is an empty string </p>
		 * @param dev_total_in_progress_time the dev_total_in_progress_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_total_in_progress_time(double dev_total_in_progress_time) {
			this.dev_total_in_progress_time = dev_total_in_progress_time;
			return this;
		}
		
		/**
		 * Set dev_total_blocked_time in analyzed ticket. Default value is an empty string </p>
		 * @param dev_total_blocked_time the dev_total_blocked_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_total_blocked_time(double dev_total_blocked_time) {
			this.dev_total_blocked_time = dev_total_blocked_time;
			return this;
		}
		
		/**
		 * Set dev_sla_days in analyzed ticket. Default value is an empty string </p>
		 * @param dev_sla_days the dev_sla_days to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_sla_days(double dev_sla_days) {
			this.dev_sla_days = dev_sla_days;
			this.dev_sla_passed = (this.dev_sla_days <= 0);
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
		
		/**
		 * Set qa_location in analyzed ticket. Default value is an empty string </p>
		 * @param qa_location the qa_location to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_location(String qa_location) {
			this.qa_location = qa_location;
			return this;
		}
		
		/**
		 * Set qa_group in analyzed ticket. Default value is an empty string </p>
		 * @param qa_group the qa_group to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_group(String qa_group) {
			this.qa_group = qa_group;
			return this;
		}
		
		/**
		 * Set qa_total_waiting_time in analyzed ticket. Default value is an empty string </p>
		 * @param qa_total_waiting_time the qa_total_waiting_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_total_waiting_time(double qa_total_waiting_time) {
			this.qa_total_waiting_time = qa_total_waiting_time;
			return this;
		}
		
		/**
		 * Set qa_total_in_progress_time in analyzed ticket. Default value is an empty string </p>
		 * @param qa_total_in_progress_time the qa_total_in_progress_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_total_in_progress_time(double qa_total_in_progress_time) {
			this.qa_total_in_progress_time = qa_total_in_progress_time;
			return this;
		}
		
		/**
		 * Set qa_total_blocked_time in analyzed ticket. Default value is an empty string </p>
		 * @param qa_total_blocked_time the qa_total_blocked_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_total_blocked_time(double qa_total_blocked_time) {
			this.qa_total_blocked_time = qa_total_blocked_time;
			return this;
		}
		
		/**
		 * Set qa_sla_days in analyzed ticket. Default value is an empty string </p>
		 * @param qa_sla_days the qa_sla_days to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_sla_days(double qa_sla_days) {
			this.qa_sla_days = qa_sla_days;
			this.qa_sla_passed = (this.qa_sla_days <= 0);
			return this;
		}
		
		/**
		 * Set exceptions in analyzed ticket. Default value is an empty string </p>
		 * @param exceptions the exceptions to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setExceptions(int exceptions) {
			this.exceptions = exceptions;
			return this;
		}
		
		/**
		 * Set exception_total_time in analyzed ticket. Default value is an empty string </p>
		 * @param exception_total_time the exception_total_time to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setException_total_time(double exception_total_time) {
			this.exception_total_time = exception_total_time;
			return this;
		}
		
		/**
		 * Set ba_excluded in analyzed ticket. Default value is an empty string </p>
		 * @param ba_excluded the ba_excluded to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setBa_excluded(boolean ba_excluded) {
			this.ba_excluded = ba_excluded;
			return this;
		}
		
		/**
		 * Set dev_excluded in analyzed ticket. Default value is an empty string </p>
		 * @param dev_excluded the dev_excluded to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setDev_excluded(boolean dev_excluded) {
			this.dev_excluded = dev_excluded;
			return this;
		}
		
		/**
		 * Set qa_excluded in analyzed ticket. Default value is an empty string </p>
		 * @param qa_excluded the qa_excluded to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setQa_excluded(boolean qa_excluded) {
			this.qa_excluded = qa_excluded;
			return this;
		}
		
		/**
		 * Set comment in analyzed ticket. Default value is an empty string </p>
		 * @param comment the comment to set
		 * @return AnalyzedSummaryBeanBuilder
		 */
		public AnalyzedSummaryBeanBuilder setComment(String comment) {
			this.comment = comment;
			return this;
		} 	
		
		
		
	}

	public String getJira() {
		return jira;
	}

	public String getSummary() {
		return summary;
	}

	public String getType() {
		return type;
	}

	public String getComponent() {
		return component;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getLabel() {
		return label;
	}

	public String getStatus() {
		return status;
	}

	public Date getDone_date() {
		return done_date;
	}

	public int getNeed_more_info() {
		return need_more_info;
	}

	public int getTest_fail() {
		return test_fail;
	}

	public int getRedo() {
		return redo;
	}

	public String getBa_assignee() {
		return ba_assignee;
	}

	public String getBa_location() {
		return ba_location;
	}

	public String getBa_group() {
		return ba_group;
	}

	public double getBa_total_in_progress_time() {
		return ba_total_in_progress_time;
	}

	public double getBa_sla_days() {
		return ba_sla_days;
	}

	public boolean isBa_sla_passed() {
		return ba_sla_passed;
	}

	public String getDev_assignee() {
		return dev_assignee;
	}

	public String getDev_location() {
		return dev_location;
	}

	public String getDev_group() {
		return dev_group;
	}

	public double getDev_total_waiting_time() {
		return dev_total_waiting_time;
	}

	public double getDev_total_in_progress_time() {
		return dev_total_in_progress_time;
	}

	public double getDev_total_blocked_time() {
		return dev_total_blocked_time;
	}

	public double getDev_sla_days() {
		return dev_sla_days;
	}

	public boolean isDev_sla_passed() {
		return dev_sla_passed;
	}

	public String getQa_assignee() {
		return qa_assignee;
	}

	public String getQa_location() {
		return qa_location;
	}

	public String getQa_group() {
		return qa_group;
	}

	public double getQa_total_waiting_time() {
		return qa_total_waiting_time;
	}

	public double getQa_total_in_progress_time() {
		return qa_total_in_progress_time;
	}

	public double getQa_total_blocked_time() {
		return qa_total_blocked_time;
	}

	public double getQa_sla_days() {
		return qa_sla_days;
	}

	public boolean isQa_sla_passed() {
		return qa_sla_passed;
	}

	public int getExceptions() {
		return exceptions;
	}

	public double getException_total_time() {
		return exception_total_time;
	}

	public boolean isBa_excluded() {
		return ba_excluded;
	}

	public boolean isDev_excluded() {
		return dev_excluded;
	}

	public boolean isQa_excluded() {
		return qa_excluded;
	}

	public String getComment() {
		return comment;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.jira).append("]").append(" : ");
		sb.append(this.component);
		return sb.toString();
	}
}