package com.codeup.lectureblog.repositories;


import com.codeup.lectureblog.posts.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
