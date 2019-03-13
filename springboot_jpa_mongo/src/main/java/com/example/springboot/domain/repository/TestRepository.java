package com.example.springboot.domain.repository;

import com.example.springboot.domain.model.Test;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, ObjectId> {
    @Query
    Test findTestByName(String name);
}
