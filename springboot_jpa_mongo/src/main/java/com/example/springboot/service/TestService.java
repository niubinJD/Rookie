package com.example.springboot.service;

import com.example.springboot.domain.model.Test;
import com.example.springboot.domain.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository repository;

    @Transactional
    public Test save(Test test){
        return repository.insert(test);
    }
    @Transactional
    public List<Test> getAll(){
        return repository.findAll();
    }

    @Transactional
    public Test findOne(String name){
        return repository.findTestByName(name);
    }

    @Transactional
    public Page<Test> getThePage(int thePage, int pageSize){
        return repository.findAll(PageRequest.of(thePage, pageSize));
    }

    @Transactional
    public void removeAll(){
        repository.deleteAll();
    }

    /**
     * 异步调用
     * @throws InterruptedException
     */
    @Async
    public void doTaskOne() throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println(System.currentTimeMillis() - l);
    }
    @Async
    public void doTaskTwo() throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(3000);
        System.out.println(System.currentTimeMillis() - l);
    }
}
