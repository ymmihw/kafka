package com.ymmihw.kafka;

import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;

@Configuration
public class KafkaProducerConfig {

  @Bean
  public KafkaTemplate<String, Greeting> kafkaTemplate(ProducerFactory producerFactory) {
    KafkaTemplate<String, Greeting> kafkaTemplate = new KafkaTemplate(producerFactory);
    kafkaTemplate.setTransactionIdPrefix(String.format("tx-%s-", UUID.randomUUID().toString()));
    return kafkaTemplate;
  }

  @Bean
  public KafkaTransactionManager kafkaTransactionManager(ProducerFactory producerFactory) {
    KafkaTransactionManager ktm = new KafkaTransactionManager(producerFactory);
    return ktm;
  }
}
