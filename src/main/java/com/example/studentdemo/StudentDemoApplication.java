package com.example.studentdemo;

import com.example.studentdemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentRepository studentRepository){
        return (args -> {
            System.out.println(studentRepository.findAll()
            );
        });
    }
}
