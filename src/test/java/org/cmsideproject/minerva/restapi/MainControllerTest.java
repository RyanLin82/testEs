package org.cmsideproject.minerva.restapi;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class MainControllerTest extends AbstractTest{

	org.cmsideproject.minerva.controller.MainController MainController;
	
	
	@Test
	public void findById() throws ParseException, InterruptedException, ExecutionException {
		String ticketNumber = "";
		MainController.findByTicketNumber(ticketNumber);
	}
}
