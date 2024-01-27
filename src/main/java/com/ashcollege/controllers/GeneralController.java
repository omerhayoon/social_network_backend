package com.ashcollege.controllers;

import com.ashcollege.Persist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class GeneralController {

    @Autowired
    private Persist persist;

    @PostConstruct
    public void init () {
    }
}
