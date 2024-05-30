package com.cafeteria.fransstar.services;

import com.cafeteria.fransstar.entities.People;
import com.cafeteria.fransstar.repositories.PeopleRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepositorie peopleRepositorie;

    public List<People> findAll(){
        return peopleRepositorie.findAllByActiveTrue();
    }

    public People create(People obj){
        return peopleRepositorie.save(obj);
    }

    public void update(Long id, People obj){
        var people = peopleRepositorie.getReferenceById(id);
        people.updateData(obj);
        peopleRepositorie.save(people);
    };

    public People findById(Long id){
        Optional<People> obj = peopleRepositorie.findById(id);
        return obj.orElseThrow(()-> new RuntimeException("Objeto não encontrado"));
    }

    public void delete(Long id){
        var people = peopleRepositorie.getReferenceById(id);
        people.delete();
        peopleRepositorie.save(people);
    }
}
