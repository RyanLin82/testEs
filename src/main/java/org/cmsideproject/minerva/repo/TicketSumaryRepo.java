package org.cmsideproject.minerva.repo;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketSumaryRepo extends MinervaRepo<TicketSumaryDTO> {

	public TicketSumaryRepo() {
		super(TicketSumaryDTO.class);
	}

	@Override
	void hasId(TicketSumaryDTO data) throws ErrorInputException {
		if (StringUtils.isEmpty(data.getJira())) {
			throw new ErrorInputException(data.toString(), "Ticket Number is empty");
		}
	}

}
