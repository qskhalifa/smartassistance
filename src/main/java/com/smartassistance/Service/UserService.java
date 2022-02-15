package com.smartassistance.Service;

import com.smartassistance.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User newUser);
    boolean deleteUser(Long userId);
    List<User> getAllUser();
}
