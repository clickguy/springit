package com.rcusick.springit;

import com.rcusick.springit.domain.Comment;
import com.rcusick.springit.domain.Link;
import com.rcusick.springit.repository.CommentRepository;
import com.rcusick.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringitApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringitApplication.class, args);
    }
    
    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepositry) {
        return args -> {
            
            Link link = new Link("Getting Started with Sprong Boot 2","https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link);
            
            Comment comment = new Comment("This Spring Boot 2 link is awesome!",link);
            commentRepositry.save(comment);
            
            link.addComment(comment);

            System.out.println("We just inserted a link and comment");
            System.out.println("===========================================");
            
        };
    }

}
