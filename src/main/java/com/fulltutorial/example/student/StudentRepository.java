package com.fulltutorial.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
    * REPOSITORY => DATA ACCESS LAYER
    * */


}
