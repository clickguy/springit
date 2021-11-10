package com.rcusick.springit.repository;

import com.rcusick.springit.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RCusick
 * 
 * The "JpaRepositry is from spring that does all the CRUD, sorting, etc
 * The arguments are the domain type (e.g. Link) and the ID type of the Link (e.g. Long)
 * 
 * We don't need to add the implementation at all
 * 
 * You CAN still use @NamedQuery if you want - but the Query Method is better
 * 
 * QUERY METHOD:
 * @Query("select u from User u where u.emailAddress = ?1")
 * User findByEmailAddress(String emailAddress)
 * 
 * USING "REGULAR SQL" WITH QUERY METHOD:
 * @Query("SELECT * FROM USERS WHERE EMAILADDRESS = ?1", nativeQuery = true)
 * User findByEmailAddress(String emailAddress)
 */
public interface CommentRepository extends JpaRepository <Comment,Long>{
    
}
