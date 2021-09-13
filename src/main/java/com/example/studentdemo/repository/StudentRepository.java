package com.example.studentdemo.repository;

import com.example.studentdemo.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    //save
    //CRUD
    public Student save(Student student);
    //read
    //CRUD
    public List<Student> findListStudentByLastName(String lastName);
    public List<Student> findAll();
    public Student findStudentByEmail(String email);

    //JPQL la query theo entity
    @Query("select s from Student s where s.lastName=?1")
    public List<Student> findListStudentByLastNameJPQL(String lastName);

    @Query("select s from Student s where s.lastName=?1 and s.email=?2")
    public Student findStudentByLastNameEmailJPQL(String lastName,String email);

    //Native query la query theo SQL
    @Query(value = "select * from tbl_student where student_id=?1", nativeQuery = true)
    public Student findStudentByIdNative(Long id);

    @Query(value = "select * from tbl_student s", nativeQuery = true)
    public List<Student> findAllStudentNative();

    //update
    //CRUD

    //JPQL
    @Transactional
    @Modifying
    @Query("update Student e set e.firstName=?2 where e.studentId=?1")
    public void updateFirstNameStudentByIdJPQL(Long id, String firstName);

    //Native
    @Transactional
    @Modifying
    @Query(value = "update tbl_student set last_Name=?2 where student_id=?1",nativeQuery = true)
    public void updateLastNameStudentByIdNative(Long id, String lastName);

    //delete
    //CRUD
    @Transactional
    @Modifying
    public void deleteByStudentId(Long id);

    //JPQL
    @Transactional
    @Modifying
    @Query("delete from Student e where e.email=?1")
    public void deleteStudentByEmailJPQL(String email);

    //Native
    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where email=?1",nativeQuery = true)
    public void deleteStudentByEmailNative(String email);



}
