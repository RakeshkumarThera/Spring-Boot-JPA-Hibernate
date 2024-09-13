package com.rakesh.cruddemo.dao;

import com.rakesh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository //supports component scanning and translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) { //Reading Step 2: Add new method to DAO implementation
        return entityManager.find(Student.class, id); //Student.class -> Entity class and id -> primary key
    }
}
