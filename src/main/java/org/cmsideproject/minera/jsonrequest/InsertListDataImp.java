//package org.cmsideproject.minera.jsonrequest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.cmsideproject.minera.entity.TicketSumary;
//import org.cmsideproject.minera.service.TicketSumaryService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//@Service
//public class InsertListDataImp implements InsertJsonData{
//
//	@Autowired
//	TicketSumaryService ticketSumaryService;
//	
//	public void insertTicketSumaryListIntoEs(Map<String, String>[] jiraJson) {
//		
//	
//		List<TicketSumary> ticketSumaryList = convertInputJsonToTicketSummary(jiraJson, new String[] {"-"," "});
//		
//		if(ticketSumaryList == null || ticketSumaryList.isEmpty()) {
////			throw new JsonMappingDataNotFound();
//		}
//		
//		if(!saveTicketSumaryList(ticketSumaryList)) {
////			throw new InsertDataError();
//		}
//	}
//	
//	private boolean saveTicketSumaryList(List<TicketSumary> ticketSumaryList) {
//		if(ticketSumaryList == null || ticketSumaryList.isEmpty()) {
//			return false;
//		}
//		
//		for(TicketSumary ticket : ticketSumaryList){
//			ticketSumaryService.save(ticket);
//		}
//		return true;
//	}
//	
//	private List<TicketSumary> convertInputJsonToTicketSummary(Map<String, String>[] jiraJson, String[] replaceChars) {
//		
//		if(jiraJson == null || jiraJson.length < 1) {
//			return new ArrayList<>();
//		}
//		
//		
//		List<TicketSumary> ticketSumaryList = new ArrayList<>();
//		String cleanKey;
//		ModelMapper modelMapper = new ModelMapper();
//		for(Map<String, String> jiraTickets : jiraJson){
//			Map<String, String> jiraTicketMap = new HashMap<>();
//			for(Map.Entry<String, String> jiraTicket : jiraTickets.entrySet()){
//				if(jiraTicket == null || StringUtils.isEmpty(jiraTicket.getKey())) {
//					continue;
//				}
//				cleanKey = cleanString(jiraTicket.getKey(), replaceChars);
//				jiraTicketMap.put(cleanKey, jiraTicket.getValue());
//			}
//			
//			TicketSumary ticketSumary = modelMapper.map(jiraTicketMap, TicketSumary.class);
//			ticketSumaryList.add(ticketSumary);
//		}
//		return ticketSumaryList;
//	}
//	
//	private String cleanString(String oldValue, String[] replaceChars) {
//		
//		if(StringUtils.isEmpty(oldValue)|| replaceChars == null || replaceChars.length < 1) {
//			return "";
//		}
//		
//		for(String replaceChar : replaceChars) {
//			oldValue.replace(replaceChar, "");
//		}
//		
//		return oldValue;
//		
//	}
//	
//}
