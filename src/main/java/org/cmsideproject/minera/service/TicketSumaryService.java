package org.cmsideproject.minera.service;

import org.cmsideproject.minera.entity.TicketSumaryDTO;

public interface TicketSumaryService {

    TicketSumaryDTO save(TicketSumaryDTO TicketSumary);

    void delete(TicketSumaryDTO TicketSumary);
    
    void postData(String indexName, String insertData);

//    TicketSumary findOne(String id);

    Iterable<TicketSumaryDTO> findAll();


}