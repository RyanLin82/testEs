package org.cmsideproject.minerva.entity;

public class Response {

	private MinervaResponseStatus status;

	private String statusCode;

	private String message;

	private String version;

	public Response() {
	}

	public Response(ResponseBuilder builder) {
		this.message = builder.message;
		this.status = builder.status;
		this.statusCode = builder.statusCode;
		this.version = builder.version;
	}
	
	public MinervaResponseStatus getStatus() {
		return status;
	}

	public void setStatus(MinervaResponseStatus status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public static class ResponseBuilder {

		private MinervaResponseStatus status;

		private String statusCode;

		private String message;

		private String version;

		public ResponseBuilder() {
		}

		public ResponseBuilder setStatus(MinervaResponseStatus status) {
			this.status = status;
			return this;
		}

		public ResponseBuilder setStatusCode(String statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public ResponseBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public ResponseBuilder setVersion(String version) {
			this.version = version;
			return this;
		}

		public Response build() {
			return new Response(this);
		}
	}
}
