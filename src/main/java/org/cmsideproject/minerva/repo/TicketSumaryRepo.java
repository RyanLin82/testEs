package org.cmsideproject.minerva.repo;

import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketSumaryRepo extends MinervaRepo<TicketSumaryDTO> {

	public TicketSumaryRepo() {
		super(TicketSumaryDTO.class);
	}

}
