package com.ymmihw.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactionManager")
@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public void save(User user) {
    userRepository.save(user);
  }
}
