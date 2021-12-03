package com.ymmihw.chained;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class ChainedConfig {

  @Bean(name = "chainedTransactionManager")
  public ChainedTransactionManager chainedTransactionManager(
      KafkaTransactionManager kafkaTransactionManager, JpaTransactionManager transactionManager) {
    return new ChainedTransactionManager(transactionManager, kafkaTransactionManager);
  }
}
