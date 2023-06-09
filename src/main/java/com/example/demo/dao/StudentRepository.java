package com.example.demo.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
