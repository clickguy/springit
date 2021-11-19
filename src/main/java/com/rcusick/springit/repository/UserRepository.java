package com.rcusick.springit.repository;

import com.rcusick.springit.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RCusick
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByEmail(String email);
    
}
