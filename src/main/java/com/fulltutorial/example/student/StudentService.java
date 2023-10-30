package com.fulltutorial.example.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    /*
    * SERVICE => BUSINESS LAYER
    * */

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(studentRepository.findAll());

        var studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);

        if (!exists)
            throw new IllegalArgumentException("student with id "+ studentID +" does not exists");
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("student with id " + studentId + " does not exists"));

        if (name != null && !name.isBlank() && !Objects.equals(student.getName(), name))
            student.setName(name);

        if (email != null && !email.isBlank() && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent())
                throw new IllegalArgumentException("email taken already");
            student.setEmail(email);
        }
    }

    /*
    * ;
    * */
}
