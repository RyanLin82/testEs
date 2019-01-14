package org.cmsideproject.exception;

import org.cmsideproject.exception.message.ExceptionMessager;

public abstract class MinervaException extends Exception{

	private static final long serialVersionUID = 6564389724365215466L;

	public MinervaException(Throwable cause, String code, String... args) {
		super(ExceptionMessager.getInstance().decode(code, args), cause);
	}
	
	public MinervaException(String code, String... args) {
		super(ExceptionMessager.getInstance().decode(code, args));
	}
	
	public abstract String getCode();
}