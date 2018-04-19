package com.codeup.lectureblog.services;

import com.codeup.lectureblog.repositories.DogRepository;
import com.codeup.lectureblog.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MammalStatsService {

    DogRepository dogDao;
    PersonRepository personDao;

    public MammalStatsService(DogRepository dogDao, PersonRepository personDao) {
        this.dogDao = dogDao;
        this.personDao = personDao;
    }

    public int getAverageMammalAge() {

        List<Integer> totalAges = new ArrayList<>();
        List<Integer> dogAges = dogDao.getAges();
        List<Integer> peopleAges = personDao.getAges();
        int sum = 0;

        totalAges.addAll(dogAges);
        totalAges.addAll(peopleAges);

        for (int age : totalAges) {
            sum += age;
        }

        return sum / (totalAges.size());

    }

}
