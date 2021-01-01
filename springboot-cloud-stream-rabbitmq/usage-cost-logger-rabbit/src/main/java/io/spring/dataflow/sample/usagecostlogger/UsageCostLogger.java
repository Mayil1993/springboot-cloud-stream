package io.spring.dataflow.sample.usagecostlogger;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableBinding(Sink.class)
public class UsageCostLogger {

	@StreamListener(Sink.INPUT)
	public void process(UsageCostDetail usageCostDetail) {
		log.info(usageCostDetail.toString());
	}
}
