package com.codeup.lectureblog.ads.repositories;


import com.codeup.lectureblog.ads.models.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {

}
