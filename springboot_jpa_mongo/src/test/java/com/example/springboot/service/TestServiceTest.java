package com.example.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class) // 已spring环境运行测试
public class TestServiceTest {

    @Autowired
    private TestService service;

    /**
     * insert
     */
    @Test
    public void save() {
        service.save(new com.example.springboot.domain.model.Test("asdasd"));
    }

    /**
     * query
     */
    @Test
    public void getAll() {
        List<com.example.springboot.domain.model.Test> all = service.getAll();
        all.stream().forEach(x -> System.out.println(x.getName()));
    }

    /**
     * query 分页
     */
    @Test
    public void getThePage() {
        Page<com.example.springboot.domain.model.Test> thePage = service.getThePage(0, 10);
        System.out.println(thePage.getTotalElements());
    }

    /**
     * delete
     */
    @Test
    public void removeAll() {
        service.removeAll();
    }

    @Test
    public void doTaskOne() throws InterruptedException {
        service.doTaskOne();
        service.doTaskTwo();
    }
}