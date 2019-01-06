package org.cmsideproject.minerva.service;
//package org.cmsideproject.minera.service;
//
//import java.util.List;
//
//import org.cmsideproject.minera.entity.TicketSumary;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TicketSumaryServiceImpl implements TicketSumaryService {
//
//    private org.cmsideproject.minera.repo.TicketSumaryRepository TicketSumaryRepository;
//
//    @Autowired
//    public void setTicketSumaryRepository(org.cmsideproject.minera.repo.TicketSumaryRepository TicketSumaryRepository) {
//        this.TicketSumaryRepository = TicketSumaryRepository;
//    }
//
//    public TicketSumary save(TicketSumary TicketSumary) {
//        return TicketSumaryRepository.save(TicketSumary);
//    }
//
//    public void delete(TicketSumary TicketSumary) {
//        TicketSumaryRepository.delete(TicketSumary);
//    }
//
////    public TicketSumary findOne(String id) {
////        return TicketSumaryRepository.findOne(id);
////    }
//
//    public Iterable<TicketSumary> findAll() {
//        return TicketSumaryRepository.findAll();
//    }
//
//
//}