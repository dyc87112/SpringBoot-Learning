package com.didispace.chapter62;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findAll() {

        personRepository.findAll().forEach(p -> {
            System.out.println(p);
        });

    }

    @Test
    public void save() {
        Person person = new Person();
        person.setUid("uid:1");
        person.setUserName("AAA");
        person.setCommonName("aaa");
        person.setUserPassword("123456");
        personRepository.save(person);

        personRepository.findAll().forEach(p -> {
            System.out.println(p);
        });
    }

}
