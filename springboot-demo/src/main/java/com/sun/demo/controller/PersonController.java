package com.sun.demo.controller;

import com.sun.demo.vo.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wilson
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @PostMapping
    public Person add(@RequestBody Person person){
        return person;
    }
}
