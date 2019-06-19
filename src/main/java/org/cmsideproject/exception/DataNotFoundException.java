package org.cmsideproject.exception;

public class DataNotFoundException extends MinervaException {

	
	private static final long serialVersionUID = -8624341574199243300L;
	private static final String CODE = "103";

	public DataNotFoundException(String ticketNum, Throwable throwable) {
		super(throwable, CODE, ticketNum);
	}

	public DataNotFoundException(String inputData, String msg) {
		super(CODE, msg, inputData);
	}

	public DataNotFoundException(String msg) {
		super(CODE, msg);
	}

	@Override
	public String getCode() {
		return CODE;
	}
}
