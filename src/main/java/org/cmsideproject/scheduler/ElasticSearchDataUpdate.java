package org.cmsideproject.scheduler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.miverva.service.TestTicketSumaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ElasticSearchDataUpdate {

	@Autowired
	TestTicketSumaryServiceImpl testTicketSumaryServiceImpl; 
	/**
     * 
     * @throws InterruptedException
	 * @throws ParseException 
	 * @throws ErrorInputException 
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void reportCurrentTimeCron() throws InterruptedException, ErrorInputException, ParseException {
        
    	//TODO get data list from minerva core
    	List dataList = new ArrayList<>();
    	testTicketSumaryServiceImpl.saveByDto(dataList);
    }
}
