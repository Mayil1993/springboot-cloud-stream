package io.spring.dataflow.sample.usagecostlogger;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class UsageCostLogger {

	@Bean
	public Consumer<UsageCostDetail> process() {
		return usageCostDetail -> {
			log.info(usageCostDetail.toString());
		};
	}
}
