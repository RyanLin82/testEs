package org.cmsideproject.minerva.repo;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketSumaryRepo extends MinervaRepo<TicketSumaryDTO> {

	public TicketSumaryRepo() {
		super(TicketSumaryDTO.class);
	}

	@Override
	void isEmpty(TicketSumaryDTO data) throws ErrorInputException {
		if (data == null) {
			throw new ErrorInputException(data.toString(), "Ticket Number is empty");
		}
	}

}
