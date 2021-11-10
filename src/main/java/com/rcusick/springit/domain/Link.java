package com.rcusick.springit.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author RCusick
 */
@Entity
// Project Lombok will create getters, setters, toString and no args constructor
@NoArgsConstructor
@Data
public class Link {
    
    @Id
    @GeneratedValue
    private Long id;
    @NonNull // Project Lombok
    private String title;
    @NonNull
    private String url;
    
    // comments


}
