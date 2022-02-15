package com.smartassistance.Controller;

import com.smartassistance.Model.User;
import com.smartassistance.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smart-assistance/api")
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public ResponseEntity createNewUser(@RequestBody User user) {

        logger.info("Request To Add a New User");

        User existUser = userService.createUser(user);
        if (existUser == null) {
            return new ResponseEntity<>("There is already a User attached with This username", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(existUser, HttpStatus.CREATED);
    }

    @GetMapping("/all-users")
    public ResponseEntity retrieveAllUsers() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long userId) {

        logger.info("Request To Delete a User");
        boolean result = userService.deleteUser(userId);

        if (!result ) {
            return new ResponseEntity<>("Couldn't Find any User associated with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User has been Deleted Successfully", HttpStatus.OK);
    }
}




