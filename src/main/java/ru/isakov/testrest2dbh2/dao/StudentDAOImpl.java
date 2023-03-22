package ru.isakov.testrest2dbh2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.isakov.testrest2dbh2.entity.Student;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager   entityManager;
    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createQuery("from Student");
        List<Student> allStudents = query.getResultList();
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {

        Query query = entityManager.createQuery("delete from Student"
                + " where id =:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();

    }
}
