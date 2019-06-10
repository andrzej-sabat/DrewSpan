package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.RoleRepository;
import com.drewSpan.drewSpan2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
/*
    public User saveUser(User user) {
        user.setPassword();
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
*/
}
