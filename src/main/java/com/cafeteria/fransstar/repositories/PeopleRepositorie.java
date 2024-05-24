package com.cafeteria.fransstar.repositories;

import com.cafeteria.fransstar.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepositorie extends JpaRepository<People, Long> {
}
