package com.rcusick.springit.security;

import com.rcusick.springit.domain.User;
import com.rcusick.springit.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author RCusick
 */
@Service
class UserDetailServiceTeml implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceTeml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = (Optional<User>) userRepository.findByEmail(email);
        if( !user.isPresent() ) {
            throw new UsernameNotFoundException(email);
        }
        
        return user.get();
    }
    
}
