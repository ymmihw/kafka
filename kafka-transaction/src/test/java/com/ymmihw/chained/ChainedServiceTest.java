package com.ymmihw.chained;

import com.ymmihw.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = AppConfig.class, webEnvironment = WebEnvironment.NONE)
public class ChainedServiceTest {
  @Autowired ChainedService chainedService;

  @Test
  public void test() {
    chainedService.chained();
  }
}
