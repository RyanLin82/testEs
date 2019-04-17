//package org.cmsideproject.component;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.commons.lang3.StringUtils;
//import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TicketIndices {
//
//	@Autowired
//	ClusterHealthResponse response;
//
//	public Set<String> indicesName;
//
//	private void getIndices() throws IOException {
//		Set<String> value = response.getIndices().keySet();
//		Set<String> indices = new HashSet<>();
//		for (String index : value) {
//			if (StringUtils.contains(index, "CZ") || StringUtils.contains(index, "cz")) {
//				indices.add(index);
//			}
//		}
//		indicesName = indices;
//	}
//
//	@PostConstruct
//	private void init() throws IOException {
//		if (indicesName == null) {
//			getIndices();
//		}
//	}
//
//	public Set<String> getIndicesName() {
//		return indicesName;
//	}
//
//}
