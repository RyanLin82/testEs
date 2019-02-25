package org.cmsideproject.minerva.entity;

public class ResponseBuilder<T> {

	private MinervaResponseStatus status;

	private String statusCode;

	private String message;

	private String version;
	
	public ResponseBuilder<T> setStatus(MinervaResponseStatus status) {
		this.status = status;
		return this;
	}

	public ResponseBuilder<T> setStatusCode(String statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public ResponseBuilder<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseBuilder<T> setVersion(String version) {
		this.version = version;
		return this;
	}
}
