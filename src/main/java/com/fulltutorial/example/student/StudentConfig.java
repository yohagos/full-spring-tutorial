package com.fulltutorial.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.saveAll(
                    List.of(
                            new Student("Yosef Hagos",
                                    LocalDate.of(1989, Month.FEBRUARY, 25),
                                    "yosef@test.de"
                            ),
                            new Student("Maria",
                                    LocalDate.of(1998, Month.AUGUST, 25),
                                    "yosef@test.de"
                            )
                    )
            );

            studentRepository.findAll().forEach(System.out::println);
        };
    }
}
