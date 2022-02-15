package com.smartassistance.Service;

import com.smartassistance.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *  Created By Qusay Sami on 1/10/22
 */

@Service
public interface UserService {
    User createUser(User newUser);
    boolean deleteUser(Long userId);
    List<User> getAllUser();
}
