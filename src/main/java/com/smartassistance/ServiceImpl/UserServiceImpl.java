package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.User;
import com.smartassistance.Repo.UserRepository;
import com.smartassistance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User newUser) {
        // Checking if there is already Exist User with this username in the DB
        User existUser = userRepository.findUserByUsername(newUser.getUsername()).orElse(null);

        if (existUser == null) {
            return userRepository.save(newUser);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        // Checking if there associated User with given ID
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
