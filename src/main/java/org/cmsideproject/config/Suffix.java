package org.cmsideproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Suffix {

	@Value("${Format.index}")
	private String indexNamePattern;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String somePropertyValue) {
		
		if(somePropertyValue.contains(indexNamePattern)) {
			somePropertyValue = somePropertyValue.replace(indexNamePattern, "");
		}
		this.value = somePropertyValue;
	}
}
