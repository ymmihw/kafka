package com.ymmihw.kafka;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.ChainedKafkaTransactionManager;
import org.springframework.kafka.transaction.KafkaTransactionManager;

@Configuration
public class KafkaProducerConfig {

  @Bean
  public KafkaTemplate<String, Greeting> kafkaTemplate(ProducerFactory producerFactory) {
    KafkaTemplate<String, Greeting> kafkaTemplate = new KafkaTemplate(producerFactory);
    return kafkaTemplate;
  }

  @Bean
  public KafkaTransactionManager kafkaTransactionManager(ProducerFactory producerFactory) {
    return new KafkaTransactionManager<>(producerFactory);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
      ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
      ConsumerFactory consumerFactory,
      ChainedKafkaTransactionManager chainedKafkaTransactionManager) {
    ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    configurer.configure(factory, consumerFactory);
    factory.getContainerProperties().setTransactionManager(chainedKafkaTransactionManager);
    return factory;
  }
}
