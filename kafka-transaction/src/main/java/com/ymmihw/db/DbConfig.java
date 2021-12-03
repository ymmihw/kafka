package com.ymmihw.db;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class DbConfig {
  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory em) {
    return new JpaTransactionManager(em);
  }
}
