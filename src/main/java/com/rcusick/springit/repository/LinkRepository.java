package com.rcusick.springit.repository;

import com.rcusick.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RCusick
 * 
 * The "JpaRepositry is from spring that does all the CRUD, sorting, etc
 * The arguments are the domain type (e.g. Link) and the ID type of the Link (e.g. Long)
 */
public interface LinkRepository extends JpaRepository <Link,Long>{

}
