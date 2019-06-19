package org.cmsideproject.exception;

public class ErrorInputException extends MinervaException {

	private static final long serialVersionUID = 6063079100693863265L;
	
	private static final String CODE = "102";

	public ErrorInputException(String ticketNum, Throwable throwable) {
		super(throwable, CODE, ticketNum);
	}

	public ErrorInputException(String inputData, String msg) {
		super(CODE, msg, inputData);
	}

	public ErrorInputException(String msg) {
		super(CODE, msg);
	}

	@Override
	public String getCode() {
		return CODE;
	}
}
