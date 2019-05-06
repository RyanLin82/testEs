//package org.cmsiderproject.miverva.entity;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class EntityTest {
//
//	
//	@MockBean
//    private org.cmsideproject.minerva.service.TestTicketSumaryServiceImpl TestTicketSumaryServiceImpl;
//    
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    public void findAll() throws Exception {
//    	TicketSummarySpringDataDTO stock = new TicketSummarySpringDataDTO();
//        stock.setId(1L);
//        stock.setName("Stock 1");
//        stock.setPrice(new BigDecimal(1));
//
//        List<Stock> stocks = Arrays.asList(stock);
//        given(stockService.findAll()).willReturn(stocks);
//
//        this.mockMvc.perform(get("/api/v1/stocks"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));
//    }
//}