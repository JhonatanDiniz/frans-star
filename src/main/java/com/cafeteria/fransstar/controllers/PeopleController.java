package com.cafeteria.fransstar.controllers;

import com.cafeteria.fransstar.entities.People;
import com.cafeteria.fransstar.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.time.Period;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        var list = peopleService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<People> create(@RequestBody People obj) {
        obj = peopleService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody People obj) {
        peopleService.update(id, obj);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<People> findBbyId(@PathVariable Long id) {
        var obj = peopleService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        peopleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}