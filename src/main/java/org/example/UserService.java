package org.example;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
       return userRepository.save(user);
    }
}
