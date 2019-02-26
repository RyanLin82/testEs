package org.cmsideproject.minerva.entity;

import org.springframework.beans.factory.annotation.Value;

public class PostResponse extends Response {
	
	@Value("${PostResponse.version}")
	private String putVersion;
	
	public PostResponse() {
		super();
		this.setVersion(putVersion);
	}

	public static class Builder extends BaseBuilder<PostResponse, Builder> {
		
		@Override
		protected PostResponse getActual() {
			return new PostResponse();
		}

		@Override
		protected Builder getActualBuilder() {
			return this;
		}
	}
}
