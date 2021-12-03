package com.ymmihw.kafka;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@KafkaListener(topics = "whm_test")
public class MessageHandler {

  @SneakyThrows
  @KafkaHandler
  public void process(String message) {
    log.info("=============Process: {}", message);
  }
}
