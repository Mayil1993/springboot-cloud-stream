package com.mayil1993.loansource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
@RestController
public class LoansourceApplication {

  private static final Logger log = LoggerFactory.getLogger(LoansourceApplication.class);
  private List<String> names = Arrays.asList("Donald");
  private List<Long> amounts = Arrays.asList(10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 100000000L);

  public static void main(String[] args) {
    SpringApplication.run(LoansourceApplication.class, args);
    log.info("The Loansource Application has started...");
  }
  
  @Autowired private StreamBridge streamBridge;

  @PostMapping("/postMessage")
  public String postMessage(@RequestBody Loan loan) {
	  
	  streamBridge.send("output", loan);
	  return "successfully posted";
  }
  
//  @Bean
//  public Supplier<Loan> supplyLoan(){
//
//    return () -> {
//      Loan loan = new Loan(UUID.randomUUID().toString(),
//              names.get(new Random().nextInt(names.size())),
//              amounts.get(new Random().nextInt(amounts.size())));
//      log.info("{} {} for ${} for {}", loan.getStatus(), loan.getUuid(), loan.getAmount(), loan.getName());
//      return loan;
//    };
//
//  }
}
