package org.cmsideproject.log;

import org.cmsideproject.minerva.entity.TicketSummary;

public interface MinervaLog {

	/**
	 * 
	 * @param indexName
	 * @param ticketNumber
	 * @param method
	 * @param url
	 * @param data
	 */
	void TicketInfo(String indexName, String ticketNumber, String method, String url, String data);

	/**
	 * 
	 * @param indexName
	 * @param ticketNumber
	 * @param method
	 * @param url
	 * @param data
	 * @param msg
	 */
	void TicketInfo(String indexName, String ticketNumber, String method, String url, String data, String msg);

	/**
	 * 
	 * @param indexName
	 * @param method
	 * @param url
	 * @param data
	 * @param msg
	 */
	void TicketInfo(String indexName, String method, String url, Object data);

	/**
	 * 
	 * @param indexName
	 * @param method
	 * @param url
	 */
	void TicketInfo(String indexName, String method, String url);

	void info(String title1, String value1, String title2, String value2, Object data);

	void info(String title1, String value1, String title2, String value2);

	void info(String indexName, String method, Object data);

}
