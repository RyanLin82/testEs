package org.cmsideproject.exception;

public class ElasticSearchRequestException extends MinervaException {

	private static final long serialVersionUID = 9119000803000251023L;
	private static final String CODE = "101";

	public ElasticSearchRequestException(String ticketNum, Throwable throwable) {
		super(throwable, CODE, ticketNum);
	}
}
