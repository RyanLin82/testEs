package org.cmsideproject.minerva.entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

public class GetResponse<T> extends Response {

	@Value("${GetResponse.version}")
	private String putVersion;

	private Collection<T> data;

	public GetResponse() {
		super();
		this.setVersion(putVersion);
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}
	
	public Collection<T> getData(){
		return this.data;
	}
	
	public GetResponse(GetResponseBuilder build) {
		super(build);
		this.data = build.data;
	}
	
	public static class GetResponseBuilder<T> extends Response.ResponseBuilder {
		private Collection<T> data;
		
		public GetResponseBuilder setData(Collection<T> data) {
			this.data = data;
			return this;
		}
		public GetResponseBuilder() {
			super();
		}
	}
}
