package org.cmsideproject.log;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;

public class MinervaLogImp implements MinervaLog {
	private Logger log;

	public MinervaLogImp(Class clazz) {
		log = LogManager.getLogger(clazz);
	}

	@Override
	public void TicketInfo(String indexName, String ticketNumber, String method, String url, String data) {
		log.info(
				"\n Method name: [{}] \n timestamp: [{}] \n index name : [{}], \n ticket number: [{}] \n url: [{}] \n data: [{}]",
				method, new Date(), indexName, ticketNumber, url, data);

	}

	@Override
	public void TicketInfo(String indexName, String ticketNumber, String method, String url, String data, String msg) {
		log.info(
				"\n Method name: [{}] \n timestamp: [{}] \n index name : [{}], \n ticket number: [{}] \n url: [{}] \n data: [{}] \n message: [{}]",
				method, new Date(), indexName, ticketNumber, url, data, msg);

	}

	public void TicketInfo(String message, Object p0) {
		log.info(message, p0);
	}

	public void TicketInfo(String message) {
		log.info(message);
	}

	@Override
	public void TicketInfo(String indexName, String method, String url, Object data) {
		// TODO Auto-generated method stub
		log.info("\n timestamp: [{}] \n index name : [{}], \n method: [{}] \n url: [{}] \n data: [{}]", new Date(),
				indexName, method, url, data);

	}

	@Override
	public void TicketInfo(String indexName, String method, String url) {
		// TODO Auto-generated method stub
		log.info("\n timestamp: [{}] \n index name : [{}], \n method name: [{}] \n url: [{}] \n", new Date(), indexName,
				method, url);

	}

	public void info(String title1, String value1, String title2, String value2, Object data) {
		log.info("\n timestamp: [{}] \n [{}] : [{}], \n [{}] : [{}] \n data: [{}] \n", new Date(), title1, value1,
				title2, value2, data);
	}
	
	public void info(String title1, String value1, String title2, String value2) {
		log.info("\n timestamp: [{}] \n [{}] : [{}], \n [{}] : [{}] \n", new Date(), title1, value1,
				title2, value2);
	}

}
