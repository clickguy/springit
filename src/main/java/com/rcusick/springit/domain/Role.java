package com.rcusick.springit.domain;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @ManyToMany( mappedBy = "roles")
    private Collection<User> users;

}
