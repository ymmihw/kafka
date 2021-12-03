package com.ymmihw.kafka;

import com.ymmihw.AppConfig;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = AppConfig.class, webEnvironment = WebEnvironment.NONE)
public class MessageProducerTest {
  @Autowired MessageProducer messageProducer;

  @Test
  public void test() {
    Greeting g = new Greeting();
    g.setMsg(UUID.randomUUID().toString());
    messageProducer.sendGreetingMessage(g);
  }
}
