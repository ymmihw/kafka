package com.ymmihw.chained;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class ChainedConfig {

  @Bean(name = "chainedKafkaTransactionManager")
  public ChainedKafkaTransactionManager<?, ?> chainedKafkaTransactionManager(
      KafkaTransactionManager kafkaTransactionManager, JpaTransactionManager transactionManager) {
    return new ChainedKafkaTransactionManager(transactionManager, kafkaTransactionManager);
  }
}
