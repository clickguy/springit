package com.rcusick.springit.config;

import com.rcusick.springit.domain.User;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author RCusick
 */
public class AuditorAwareTempl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication() == null){
            
            return Optional.of("master@gmail.comn");
            
        }
        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
    }
 
}
