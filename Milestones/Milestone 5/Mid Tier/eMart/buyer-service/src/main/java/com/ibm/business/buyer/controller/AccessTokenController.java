package com.ibm.business.buyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.buyer.db.entity.AccessToken;
import com.ibm.business.buyer.db.repository.AccessTokenRepository;

@RestController
public class AccessTokenController {

    @Autowired
    private AccessTokenRepository personRepository;

    @PostMapping(path = "/add")
    public void addPerson(AccessToken accessToken) {
        personRepository.save(accessToken);
    }

    @GetMapping(path = "/selectAll")
    public void selectPerson() {
        personRepository.findAll();
    }

    @GetMapping(path = "/select")
    public void selectPerson(String accessToken) {
        personRepository.findByAccessToken(accessToken);
    }
}

