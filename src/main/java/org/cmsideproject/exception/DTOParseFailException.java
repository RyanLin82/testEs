package org.cmsideproject.exception;

public class DTOParseFailException extends MinervaException {

	private static final long serialVersionUID = 2603486919995369164L;
	private static final String CODE = "100";

	public DTOParseFailException(String ticketNum, Throwable throwable) {
		super(throwable, CODE, ticketNum);
	}

	@Override
	public String getCode() {
		return CODE;
	}
}
