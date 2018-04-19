package com.codeup.lectureblog.repositories;

import com.codeup.lectureblog.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value="SELECT age FROM people", nativeQuery=true)
    public List<Integer> getAges();

}
