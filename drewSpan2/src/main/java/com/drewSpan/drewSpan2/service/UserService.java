package com.drewSpan.drewSpan2.service;

import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.OpTechRepository;
import com.drewSpan.drewSpan2.repository.RoleRepository;
import com.drewSpan.drewSpan2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(User user) {
        userRepository.delete(user);
    }

    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }
}
