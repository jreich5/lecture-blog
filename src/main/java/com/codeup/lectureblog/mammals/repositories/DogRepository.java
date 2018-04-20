package com.codeup.lectureblog.mammals.repositories;

import com.codeup.lectureblog.mammals.models.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Transactional
    public void deleteById(long id);

    @Query("select age from Dog")
    public List<Integer> getAges();

}
