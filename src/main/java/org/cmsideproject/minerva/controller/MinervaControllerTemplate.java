package org.cmsideproject.minerva.controller;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.GetResponse;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.PostResponse;
import org.cmsideproject.minerva.entity.Response;


public interface MinervaControllerTemplate {

	public PostResponse insert(String index, String data) throws ErrorInputException, ElasticSearchRequestException;

	public GetResponse getAll(String index) throws DTOParseFailException;

	public GetResponse getByConditions(String index, String data) throws DTOParseFailException;
	
	public PostResponse delete(String index, String data) throws DTOParseFailException;
	
//	public MinervaResponse update(String index, String data);

}
