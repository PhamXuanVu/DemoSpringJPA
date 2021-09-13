package com.example.studentdemo.repository;

import com.example.studentdemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudentCRUD(){
        Student student= Student.builder()
                .firstName("Xuan")
                .lastName("Vu")
                .email("aasdư@gmail.com")
                .build();
        Student student1= Student.builder()
                .firstName("Xuan")
                .lastName("Vu")
                .email("aasd1@gmail.com")
                .build();
        Student student2= Student.builder()
                .firstName("Xuan")
                .lastName("Vu")
                .email("aasda2@gmail.com")
                .build();
        Student student3= Student.builder()
                .firstName("Xuan")
                .lastName("Vu")
                .email("aasd3@gmail.com")
                .build();
        studentRepository.save(student);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }
    //read
    //CRUD
    @Test
    void findListStudentByLastName() {
        List<Student> list= (List<Student>) studentRepository.findListStudentByLastName("Vu");
        System.out.println(list);
    }

    @Test
    void findAll() {
        List<Student> list= (List<Student>) studentRepository.findAll();
        System.out.println(list);
    }

    @Test
    void findStudentByEmail() {
        Student student= studentRepository.findStudentByEmail("aasd3@gmail.com");
        System.out.println(student);
    }
    //JPQL
    @Test
    void findListStudentByLastNameJPQL() {
        List<Student> student= studentRepository.findListStudentByLastNameJPQL("Vu");
        System.out.println(student);
    }

    @Test
    void findStudentByLastNameEmailJPQL() {
        Student student=studentRepository.findStudentByLastNameEmailJPQL("Vu","aasd3@gmail.com");
        System.out.println(student);
    }
    //Navtive
    @Test
    void findStudentByIdNative() {
        Student student=studentRepository.findStudentByIdNative(4L);
        System.out.println(student);
    }

    @Test
    void findAllStudentNative() {
        List<Student> list = studentRepository.findAllStudentNative();
        System.out.println(list);
    }
    //update
    @Test
    void updateStudentCRUD(){
        Optional<Student> op= studentRepository.findById(1L);
        Student student= op.get();
        student.setEmail("update@gmail.com");
        Student a= studentRepository.save(student);
        System.out.println(a);
    }


    //jpql
    @Test
    void updateFirstNameStudentByIdJPQL() {
        studentRepository.updateFirstNameStudentByIdJPQL(1L,"update@gmail.com");
        Optional<Student> op= studentRepository.findById(1L);
        Student student= op.get();
        System.out.println(student);
    }
    //native
    @Test
    void updateLastNameStudentByIdNative() {
        studentRepository.updateLastNameStudentByIdNative(2L,"update@gmail.com");
        Optional<Student> op= studentRepository.findById(2L);
        Student student= op.get();
        System.out.println(student);
    }
    //delete
    //CRUD
    @Test
    void deleteByStudentId() {
        //neu ko dinh nghia trong repository studentRepository.deleteById(1L);
        studentRepository.deleteByStudentId(1L);
        List<Student> list= (List<Student>) studentRepository.findAll();
        System.out.println(list);

    }
    //JPQL
    @Test
    void deleteStudentByEmailJPQL() {
        studentRepository.deleteStudentByEmailJPQL("update@gmail.com");
        List<Student> list= (List<Student>) studentRepository.findAll();
        System.out.println(list);
    }
    //Native
    @Test
    void deleteStudentByEmailNative() {
        studentRepository.deleteStudentByEmailNative("update@gmail.com");
        List<Student> list= (List<Student>) studentRepository.findAll();
        System.out.println(list);
    }
}