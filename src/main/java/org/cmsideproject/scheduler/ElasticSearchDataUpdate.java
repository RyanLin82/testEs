//package org.cmsideproject.scheduler;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.cmsideproject.exception.ErrorInputException;
//import org.cmsideproject.minerva.service.TestTicketSumaryServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//
//public class ElasticSearchDataUpdate {
//
//	@Autowired
//	TestTicketSumaryServiceImpl testTicketSumaryServiceImpl; 
//	/**
//     * 
//     * @throws InterruptedException
//	 * @throws ParseException 
//	 * @throws ErrorInputException 
//	 * @throws IOException 
//     */
//    @Scheduled(cron = "0 0 1 * * *")
//    public void reportCurrentTimeCron() throws InterruptedException, ErrorInputException, ParseException, IOException {
//        
//    	//TODO get data list from minerva core
//    	List dataList = new ArrayList<>();
//    	testTicketSumaryServiceImpl.saveByEntity(dataList);
//    }
//}
