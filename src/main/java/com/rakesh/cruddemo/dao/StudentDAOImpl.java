package com.rakesh.cruddemo.dao;

import com.rakesh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //supports component scanning and translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //Reading Step 2: Add new method to DAO implementation

    // implement save method
    @Override
    @Transactional //only used if updated or modified the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); //Student.class -> Entity class and id -> primary key
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class); //Note: this is NOT the name of the database table. All JPQL syntax is based on entity name and entity fields

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastName);

        //return query results
        return theQuery.getResultList();
    }
}
