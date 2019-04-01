package org.cmsideproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
// public class Application implements CommandLineRunner {
public class Application {

	
//	@Autowired
//	TicketIndices ticketIndices;

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("\n\n\n tttttttttttttt \n");
//		TicketIndices.getInstance().getIndicesName();
////		ticketIndices.getIndicesName();
//	}

}