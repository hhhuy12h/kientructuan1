package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("select s from Student s")
    public List<Student> findAllJPQL();

    @Transactional
    @Modifying
    @Query("update Student s set s.firstName=?2 where s.id= ?1")
    public void updateByIdJPQL(Long id, String newFirstName);

    @Query(value = "select * from tbl_student", nativeQuery = true)
    public List<Student> findAllEmployeeNative();

    @Transactional
    @Modifying
    @Query(value = "update tbl_student set first_name=?2 where id= ?1", nativeQuery = true)
    public void updateByIdNative(Long id, String newfirstName);

    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where id= ?1", nativeQuery = true)
    public void deleteByIdNative(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from Student s where s.id= ?1")
    public void deleteByIdJPQL(Long id);

}
