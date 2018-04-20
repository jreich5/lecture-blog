package com.codeup.lectureblog.mammals.repositories;

import com.codeup.lectureblog.mammals.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value="SELECT age FROM people", nativeQuery=true)
    public List<Integer> getAges();

}
