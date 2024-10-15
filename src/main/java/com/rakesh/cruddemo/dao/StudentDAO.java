package com.rakesh.cruddemo.dao;

import com.rakesh.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //Reading Step 1: add new method to DAO interface
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}
