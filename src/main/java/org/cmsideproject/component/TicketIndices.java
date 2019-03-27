//package org.cmsideproject.component;
//
//import java.io.IOException;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
//import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TicketIndices {
//
//	@Autowired
//	RestHighLevelClient client;
//
//	public static TicketIndices instance = null;
//
//	public Set<String> indicesName;
//
//	public TicketIndices() throws IOException {
//		initIndices();
//	}
//
//	private void getIndices() throws IOException {
//		ClusterHealthRequest requests = new ClusterHealthRequest();
//		ClusterHealthResponse response = client.cluster().health(requests, RequestOptions.DEFAULT);
//		Set<String> indices = response.getIndices().keySet();
//		for (String index : indices) {
//			if (!StringUtils.contains(index, "CZ") && !StringUtils.contains(index, "cz")) {
//				indices.remove(index);
//			}
//		}
//		indicesName = indices;
//	}
//
//	public static TicketIndices getInstance() throws IOException {
//		if (instance == null) {
//			synchronized (TicketIndices.class) {
//				if (instance == null) {
//					instance = new TicketIndices();
//				}
//			}
//		}
//		return instance;
//	}
//
//	private void initIndices() throws IOException {
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
