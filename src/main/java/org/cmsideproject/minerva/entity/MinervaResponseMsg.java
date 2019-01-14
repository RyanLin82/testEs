package org.cmsideproject.minerva.entity;

import java.util.Collection;

public class MinervaResponseMsg {

	private String resCode;

	private Collection<?> resObj;

	private String resMsg;

	public MinervaResponseMsg(MinervaResponseMsgBuilder builder) {
		this.resMsg = builder.resMsg;
		this.resObj = builder.resObj;
		this.resCode = builder.resCode;
	}

	public String getResponseCode() {
		return resCode;
	}

	public void setResponseCode(String responseCode) {
		this.resCode = responseCode;
	}

	public Collection<?> getResponseObj() {
		return resObj;
	}

	public void setResponseObj(Collection<?> responseObj) {
		this.resObj = responseObj;
	}

	public String getErrorMsg() {
		return resMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.resMsg = errorMsg;
	}

	public static class MinervaResponseMsgBuilder {

		private String resCode;

		private String resMsg;
		
		private Collection<?> resObj;

		public MinervaResponseMsgBuilder() {
		}

		public MinervaResponseMsgBuilder setResponseCode(String responseCode) {
			this.resCode = responseCode;
			return this;
		}

		public MinervaResponseMsgBuilder setErrorMsg(String errorMsg) {
			this.resMsg = errorMsg;
			return this;
		}
		
		public MinervaResponseMsgBuilder setResponseObj(Collection<?> responseObj) {
			this.resObj = responseObj;
			return this;
		}

		public MinervaResponseMsg build() {
			return new MinervaResponseMsg(this);
		}

	}

}
