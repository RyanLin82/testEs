package org.cmsideproject.minerva.controller;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;


public interface MinervaControllerTemplate {

	public MinervaResponse insert(String index, String data) throws ErrorInputException, ElasticSearchRequestException;

	public MinervaResponse getAll(String index) throws DTOParseFailException;

	public MinervaResponse getByConditions(String index, String data) throws DTOParseFailException;
	
	public MinervaResponse delete(String index, String data) throws DTOParseFailException;
	
//	public MinervaResponse update(String index, String data);

}
