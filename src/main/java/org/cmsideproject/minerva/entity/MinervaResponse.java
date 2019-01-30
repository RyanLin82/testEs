package org.cmsideproject.minerva.entity;

import java.util.Collection;

public class MinervaResponse {

	private MinervaResponseStatus status;

	private Collection<?> data;

	private String message;

	private String statusCode;

	private final String version = "v1.0";

	public MinervaResponse() {
	}
	
	public MinervaResponse(MinervaResponseMsgBuilder builder) {
		this.message = builder.message;
		this.data = builder.data;
		this.status = builder.status;
		this.statusCode = builder.statusCode;
	}

	public MinervaResponseStatus getStatus() {
		return status;
	}

	public void setStatus(MinervaResponseStatus status) {
		this.status = status;
	}

	public Collection<?> getData() {
		return data;
	}

	public void setData(Collection<?> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getVersion() {
		return version;
	}


	public static class MinervaResponseMsgBuilder {

		private MinervaResponseStatus status;

		private Collection<?> data;

		private String message;

		private String statusCode;

		public MinervaResponseMsgBuilder() {
		}

		public MinervaResponseMsgBuilder setStatus(MinervaResponseStatus status) {
			this.status = status;
			return this;
		}

		public MinervaResponseMsgBuilder setData(Collection<?> data) {
			this.data = data;
			return this;
		}

		public MinervaResponseMsgBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public MinervaResponseMsgBuilder setStatusCode(String statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public MinervaResponse build() {
			return new MinervaResponse(this);
		}

	}

}
