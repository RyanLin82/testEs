package org.cmsideproject.enumList;

public enum MinervaResponseStatus {
	success("success"), fail("fail"), error("error");
	
	private String status;
	
	MinervaResponseStatus(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
