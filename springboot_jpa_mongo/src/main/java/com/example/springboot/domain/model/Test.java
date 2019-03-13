package com.example.springboot.domain.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;

@Document(collection = "test")
@Data
@ToString
@EqualsAndHashCode
@Entity
public class Test {
    @Id
    private ObjectId id;

    @Field("test_name")
    private String name;

    public Test(){}

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
