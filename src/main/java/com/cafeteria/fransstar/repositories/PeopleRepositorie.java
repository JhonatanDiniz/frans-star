package com.cafeteria.fransstar.repositories;

import com.cafeteria.fransstar.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepositorie extends JpaRepository<People, Long> {
    List<People> findAllByActiveTrue();
}
