package com.rcusick.springit.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author RCusick
 */
@Entity
// Project Lombok will create getters, setters, toString and no args constructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails {
    
    @Id @GeneratedValue
    private Long id;
    
    @NonNull
    @Size(min=8, max=20)
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(length = 100)
    private String password;
    
    @NonNull
    @Column(nullable = false)
    private boolean enabled;

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
    
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
          
    public void addRole(Role role){
        roles.add(role);
    }
    
    public void addRoles(Set<Role> roles){
        roles.forEach(this :: addRole);
    }
            
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        for(Role role : roles ){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
       
}
