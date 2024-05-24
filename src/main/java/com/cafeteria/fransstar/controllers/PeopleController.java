package com.cafeteria.fransstar.controllers;

import com.cafeteria.fransstar.entities.People;
import com.cafeteria.fransstar.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<People>> findAll(){
        var list = peopleService.findAll();
        return ResponseEntity.ok().body(list);
    }


}
