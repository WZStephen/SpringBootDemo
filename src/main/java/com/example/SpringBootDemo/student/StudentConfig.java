package com.example.SpringBootDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    //这是一个Bean
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student weichi = new Student(
                    "Weichi Zhao",
                    "wzhao42@asu.edu",
                    LocalDate.of(1996, Month.MAY, 18)
            );
            Student alex = new Student(
                    "Alex Chen",
                    "alx@asu.edu",
                    LocalDate.of(1997, Month.JULY, 1)
            );

            repository.saveAll(  //Hibernate is running when we call saveAll()
                    List.of(weichi, alex)
            );
        };
    }
}
