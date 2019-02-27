package org.cmsideproject.minerva.entity;

import org.springframework.beans.factory.annotation.Value;

public class GetResponse extends Response {

	@Value("${GetResponse.version}")
	private String putVersion;

	private Object data;

	public GetResponse() {
		super();
		this.setVersion(putVersion);
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	
//	public GetResponse(Builder build) {
//		super(build);
//		this.data = build.getActual().getData();
//	}

	public static class Builder extends BaseBuilder<GetResponse, Builder> {

		@Override
		protected GetResponse getActual() {
			return new GetResponse();
		}

		@Override
		protected Builder getActualBuilder() {
			return this;
		}
		
		public Builder data(Object data) {
			actualClass.setData(data);
			return this;
		}
	}
}
