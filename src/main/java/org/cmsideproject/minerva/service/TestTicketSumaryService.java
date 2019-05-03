package org.cmsideproject.minerva.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;

public interface TestTicketSumaryService {

	/**
	 * Save the ticket information into Elasticsearch by spring data.
	 * @param ticket
	 * @throws ErrorInputException
	 * @throws ParseException
	 * @throws IOException
	 */
	void save(List<Map<String, Object>> ticket) throws ErrorInputException, ParseException, IOException;

	/**
	 * Delete the ticket information into Elasticsearch by spring data.
	 * @param ticket
	 */
	void delete(List<Map<String, Object>> ticket);

	/**
	 * Get all ticket information within fromDate and thrDate by spring data.
	 * @param fromDate
	 * @param thrDate
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws ParseException
	 */
	List getByDate(String fromDate, String thrDate)  throws InterruptedException, ExecutionException, ParseException;

	/**
	 * Use the ticket number to get the ticket information by spring data
	 * @param id
	 * @return
	 */
	Optional<List<TicketSummarySpringDataDTO>> findByJira(String id);

	/**
	 * Use alias to get the ticket information by spring data
	 * @param aliasName
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	List getByAlias(String aliasName) throws InterruptedException, ExecutionException;
}