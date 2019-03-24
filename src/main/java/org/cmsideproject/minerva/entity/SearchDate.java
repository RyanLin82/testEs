package org.cmsideproject.minerva.entity;

public class SearchDate {

	public static SearchDate singleton;

	private int fromYear;
	private int fromMonth;

	private int thrYear;
	private int thrMonth;

	public SearchDate(builder builder) {

		this.fromMonth = builder.fromMonth;
		this.fromYear = builder.fromYear;
		this.thrMonth = builder.thrMonth;
		this.thrYear = builder.thrYear;
		singleton = this;
	}

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public int getFromMonth() {
		return fromMonth;
	}

	public void setFromMonth(int fromMonth) {
		this.fromMonth = fromMonth;
	}

	public int getThrYear() {
		return thrYear;
	}

	public void setThrYear(int thrYear) {
		this.thrYear = thrYear;
	}

	public int getThrMonth() {
		return thrMonth;
	}

	public void setThrMonth(int thrMonth) {
		this.thrMonth = thrMonth;
	}

	public static class builder {
		private int fromYear;
		private int fromMonth;

		private int thrYear;
		private int thrMonth;

		public builder setFromYear(int fromYear) {
			this.fromYear = fromYear;
			return this;
		}

		public builder setFromMonth(int fromMonth) {
			this.fromMonth = fromMonth;
			return this;
		}

		public builder setThrYear(int thrYear) {
			this.thrYear = thrYear;
			return this;
		}

		public builder setThrMonth(int thrMonth) {
			this.thrMonth = thrMonth;
			return this;
		}

		public SearchDate build() {
			return new SearchDate(this);
		}
	}
}
