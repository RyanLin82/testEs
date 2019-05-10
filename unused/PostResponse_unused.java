//package org.cmsideproject.minerva.entity;
//
//import org.springframework.beans.factory.annotation.Value;
//
//public class PostResponse_unused extends Response {
//	
//	@Value("${PostResponse.version}")
//	private String putVersion;
//	
//	public PostResponse_unused() {
//		super();
//		this.setVersion(putVersion);
//	}
//
//	public static class Builder extends BaseBuilder<PostResponse_unused, Builder> {
//		
//		@Override
//		protected PostResponse_unused getActual() {
//			return new PostResponse_unused();
//		}
//
//		@Override
//		protected Builder getActualBuilder() {
//			return this;
//		}
//	}
//}
