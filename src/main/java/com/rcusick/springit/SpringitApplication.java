package com.rcusick.springit;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringitApplication {

   // private static final Logger log = LoggerFacxtory.getLogger(SpringApplication.class);
    
    public static void main(String[] args) {
            SpringApplication.run(SpringitApplication.class, args);
    }
    
    @Bean
    PrettyTime prettyTime(){
        return new PrettyTime();
    }
    

}
