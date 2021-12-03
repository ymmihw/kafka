package com.ymmihw.chained;

import com.ymmihw.AppConfig;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@Slf4j
@SpringBootTest(classes = AppConfig.class, webEnvironment = WebEnvironment.NONE)
public class ChainedServiceTest {
  @Autowired ChainedService chainedService;

  @Test
  public void test() throws InterruptedException {
    try {
      chainedService.chained();
    } catch (Exception e) {
      log.error("{}", e);
    }
    TimeUnit.SECONDS.sleep(10);
  }
}
