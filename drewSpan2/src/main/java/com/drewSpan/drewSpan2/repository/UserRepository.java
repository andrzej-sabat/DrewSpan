package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);

    User findById(long id);

    User deleteById(long id);
}
