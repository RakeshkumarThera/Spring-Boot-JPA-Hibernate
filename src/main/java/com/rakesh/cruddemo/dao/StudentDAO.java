package com.rakesh.cruddemo.dao;

import com.rakesh.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id); //Reading Step 1: add new method to DAO interface
}
