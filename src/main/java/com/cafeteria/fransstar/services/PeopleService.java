package com.cafeteria.fransstar.services;

import com.cafeteria.fransstar.entities.People;
import com.cafeteria.fransstar.repositories.PeopleRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepositorie peopleRepositorie;

    public List<People> findAll(){
        return peopleRepositorie.findAll();
    }

}
