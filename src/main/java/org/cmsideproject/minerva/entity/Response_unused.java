package org.cmsideproject.minerva.entity;

public abstract class Response_unused {

	private MinervaResponseStatus status;

	private String statusCode;

	private String message;

	private String version;

	public Response_unused() {
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

	public Response_unused(BaseBuilder builder) {
		this.message = builder.getActual().getMessage();
		this.version = builder.getActual().getVersion();
		this.statusCode = builder.getActual().getStatusCode();
		this.status = builder.getActual().getStatus();
	}

	protected static abstract class BaseBuilder<T extends Response_unused, B extends BaseBuilder> {
		protected T actualClass;
		protected B actualClassBuilder;

		protected abstract T getActual();

		protected abstract B getActualBuilder();

		protected BaseBuilder() {
			actualClass = getActual();
			actualClassBuilder = getActualBuilder();
		}

		public B statusCode(String statusCode) {
			actualClass.setStatusCode(statusCode);
			return actualClassBuilder;
		}

		public B message(String message) {
			actualClass.setMessage(message);
			return actualClassBuilder;
		}

		public B version(String version) {
			actualClass.setVersion(version);
			return actualClassBuilder;
		}

		public T build() {
			return actualClass;
		}
	}
}
