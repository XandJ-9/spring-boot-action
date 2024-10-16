package com.xujia;

import com.xujia.dao.UserRepository;
import com.xujia.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication
{


    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);



//    @Bean
//    public CommandLineRunner demo(UserRepository repository){
//        return (args -> {
//            repository.save(new User("Jack","Bauer"));
//            repository.save(new User("Chloe","O'Brian"));
//            repository.save(new User("Kim","Bauer"));
//            repository.save(new User("David","Palmer"));
//            repository.save(new User("Michelle","Dessler"));
//
//            log.info("Users found with findAll():");
//            log.info("----------------------------");
//
//            for(Object user: repository.findAll()){
//                log.info(user.toString());
//                repository.findById(1L)
//                        .ifPresent(User -> {
//                            log.info("User found with findById(1L):");
//                            log.info(User.toString());
//                        });
//            }
//        });
//    }

    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = SpringApplication.run(JpaApplication.class, args);
//        Map<String, User> beans = context.getBeansOfType(User.class);
//        for (Map.Entry<String, User> userEntry : beans.entrySet()) {
//            System.out.println(userEntry);
//        }


    }




}
