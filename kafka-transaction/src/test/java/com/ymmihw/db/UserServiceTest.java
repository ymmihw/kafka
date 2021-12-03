package com.ymmihw.db;

import com.ymmihw.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = AppConfig.class, webEnvironment = WebEnvironment.NONE)
public class UserServiceTest {
  @Autowired UserService userService;

  @Test
  public void test() {
    User u = new User();
    u.setId(1L);

    userService.save(u);
  }
}
