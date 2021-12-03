package com.ymmihw.chained;

import com.ymmihw.db.User;
import com.ymmihw.db.UserRepository;
import com.ymmihw.kafka.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional("chainedTransactionManager")
@Service
@RequiredArgsConstructor
public class ChainedService {
  private final KafkaTemplate<String, Greeting> greetingKafkaTemplate;
  private final UserRepository userRepository;

  public void chained() {
    greetingKafkaTemplate.send("whm_test", new Greeting());
    User u = new User();
    u.setId(2L);
    userRepository.save(u);
    if (1 == 1) {
      throw new NullPointerException();
    }
  }
}
