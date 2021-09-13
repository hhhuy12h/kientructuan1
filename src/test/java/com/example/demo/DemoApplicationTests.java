package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test //Repository - Add
    public void insertEmployee() {
        Student student = Student.builder()
                .firstName("Van")
                .lastName("Hung")
                .email("hungvan@gmail.com")
                .build();
        employeeRepository.save(student);
    }

    @Test //Repository - Read
    public void findAllEmployee() {
        List<Student> students = (List<Student>) employeeRepository.findAll();
        System.out.println(students);
    }
    @Test //Native - Read
    public void findAllEmployeeNative() {
        List<Student> students = employeeRepository.findAllEmployeeNative();
        System.out.println(students);
    }
    @Test //JPQl - Read
    public void findAllEmployeeJPQL() {
        System.out.println(employeeRepository.findAllJPQL());
    }
    @Test //Repository - Update
    public void updateByIdRepo() {
        Student student = employeeRepository.findById(Long.valueOf(1)).get();
        // crush the variables of the object found
        student.setFirstName("Nguyen");
        student.setLastName("Hai");
        student.setEmail("123@gmail.com");
        employeeRepository.save(student);
    }
    @Test //JPQL - Update
    public void updateByIdJPQL() {
        employeeRepository.updateByIdJPQL(Long.valueOf(1), "Quan");
    }
    @Test //Native - Update
    public void updateByIdNative() {
        employeeRepository.updateByIdNative(Long.valueOf(1), "Khai");
    }
    @Test //Repository - Delete
    public void deleteById() {
        employeeRepository.deleteById(Long.valueOf(1));
    }
    @Test //Native - Delete
    public void deleteByIdNative() {
        employeeRepository.deleteByIdNative(Long.valueOf(1));
    }
    @Test //JPQL - Delete
    public void deleteByIdJPQL() {
        employeeRepository.deleteByIdJPQL(Long.valueOf(1));
    }




}
