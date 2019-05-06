package org.cmsideproject.component;

import java.util.List;
import java.util.Map;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;

public class AliasMapping {

	public static Map<String, List<String>> aliasMapping;
	
	@Autowired
	TransportClient client;
	
	AliasMapping(){
		init();
	}
	
	public void init() {
		client.admin().cluster().prepareState().execute().actionGet().getState().getMetaData().ali;
	}
}
