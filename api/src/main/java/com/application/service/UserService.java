package com.application.service;


import com.application.model.UserDTO;
import com.application.converter.UserConverter;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.repository.RoleRepository;
import com.application.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import static com.application.security.UserRole.ADMIN;


@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository,
                       UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDto) {
        User user = UserConverter.userDTOToUser(userDto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findByRoleName(ADMIN.name());
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<UserDTO> findAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserConverter::userToUserDTO)
                .toList();
    }

    public void enableUser(String username) {
        userRepository.enableUser(username);

    }
}