package com.rcusick.springit.repository;

import com.rcusick.springit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RCusick
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
