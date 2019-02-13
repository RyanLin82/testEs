package org.cmsideproject.log;

public interface MinervaLog {
	
	void TicketInfo(String indexName, String ticketNumber, String method, String url, String data);
	void TicketInfo(String indexName, String ticketNumber, String method, String url, String data, String msg);
}
