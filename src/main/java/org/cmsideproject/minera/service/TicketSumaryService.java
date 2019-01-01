package org.cmsideproject.minera.service;

import org.cmsideproject.minera.entity.TicketSumaryDTO;

public abstract class TicketSumaryService extends Validation{

	public abstract TicketSumaryDTO save(TicketSumaryDTO TicketSumary);

    public abstract void delete(TicketSumaryDTO TicketSumary);
    
    public abstract void post(String indexName, String insertData);

//    TicketSumary findOne(String id);

    public abstract Iterable<TicketSumaryDTO> findAll();
    
    public abstract void put(String indexName, String insertData, String dataIndex);
    
    public abstract void update(String indexName, String insertData, String dataIndex);
    
    public abstract void getAll(String indexName);
}