package com.fulltutorial.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
    * REPOSITORY => DATA ACCESS LAYER
    * */

    // @Query("SELECT s FROM STUDENT s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
