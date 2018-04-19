package com.codeup.lectureblog.repositories;


import com.codeup.lectureblog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Transactional
    void deleteById(Long id);

}
