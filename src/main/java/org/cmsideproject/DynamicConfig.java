package org.cmsideproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicConfig {
	@Bean
	Suffix suffix() {
		return new Suffix();
	}
}
