//package org.cmsideproject.minerva.entity;
//
//import org.springframework.beans.factory.annotation.Value;
//
//public class GetResponse_unused extends Response {
//
//	@Value("${GetResponse.version}")
//	private String putVersion;
//
//	private Object data;
//
//	public GetResponse_unused() {
//		super();
//		this.setVersion(putVersion);
//	}
//
//	public void setData(Object data) {
//		this.data = data;
//	}
//
//	public Object getData() {
//		return this.data;
//	}
//
//	
//	public static class Builder extends BaseBuilder<GetResponse_unused, Builder> {
//
//		@Override
//		protected GetResponse_unused getActual() {
//			return new GetResponse_unused();
//		}
//
//		@Override
//		protected Builder getActualBuilder() {
//			return this;
//		}
//		
//		public Builder data(Object data) {
//			actualClass.setData(data);
//			return this;
//		}
//	}
//}
