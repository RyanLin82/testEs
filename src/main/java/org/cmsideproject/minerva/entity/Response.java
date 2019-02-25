package org.cmsideproject.minerva.entity;

public class Response {

	private MinervaResponseStatus status;

	private String statusCode;

	private String message;

	private String version;

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

}
