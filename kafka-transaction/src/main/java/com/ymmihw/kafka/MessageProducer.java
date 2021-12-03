package com.ymmihw.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("kafkaTransactionManager")
public class MessageProducer {

  @Autowired private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

  public void sendGreetingMessage(Greeting greeting) {
    greetingKafkaTemplate.send("whm_test", greeting);
    if (1 == 1) {
      throw new NullPointerException();
    }
  }
}
