package com.sun.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sun.vo.Student;

public interface StudentDao extends MongoRepository<Student, Integer> {

}
