package com.application.service;


import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import com.application.entity.User;
import com.application.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {


    private final UserService userService;

    public void register(UserDTO userDTO) {
        User user = userService.saveUser(userDTO);


        log.info(String.format("User %s has registered", user.getUsername()));
    }

}