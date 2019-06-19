package org.cmsideproject.log;

public interface MinervaLog {

	/**
	 * "\n Method name: [{}] \n timestamp: [{}] \n index name : [{}], \n ticket number: [{}] \n url: [{}] \n data: [{}]"
	 * @param indexName
	 * @param ticketNumber
	 * @param method
	 * @param url
	 * @param data
	 */
	void TicketInfo(String indexName, String ticketNumber, String method, String url, String data);

	/**
	 * "\n Method name: [{}] \n timestamp: [{}] \n index name : [{}], \n ticket number: [{}] \n url: [{}] \n data: [{}] \n message: [{}]"
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
	 * "\n timestamp: [{}] \n index name : [{}], \n method name: [{}] \n url: [{}] \n"
	 * @param indexName
	 * @param method
	 * @param url
	 */
	void TicketInfo(String indexName, String method, String url);

	/**
	 * "\n timestamp: [{}] \n [{}] : [{}], \n [{}] : [{}] \n"
	 * @param title1
	 * @param value1
	 * @param title2
	 * @param value2
	 * @param data
	 */
	void info(String title1, String value1, String title2, String value2, Object data);

	/**
	 * "\n timestamp: [{}] \n index name : [{}], \n method: [{}] \n data: [{}]"
	 * @param title1
	 * @param value1
	 * @param title2
	 * @param value2
	 */
	void info(String title1, String value1, String title2, String value2);

	void info(String indexName, String method, Object data);
	
	void info(String message);

}
