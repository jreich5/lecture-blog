package com.codeup.lectureblog.mammals.controllers;


import com.codeup.lectureblog.mammals.models.Dog;
import com.codeup.lectureblog.mammals.models.Person;
import com.codeup.lectureblog.mammals.repositories.DogRepository;
import com.codeup.lectureblog.mammals.repositories.PersonRepository;
import com.codeup.lectureblog.mammals.services.MammalStatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JpaTestController {

    private final PersonRepository personDao;
    private final DogRepository dogDao;
    private final MammalStatsService mamSvc;

    public JpaTestController(PersonRepository personDao, DogRepository dogDao, MammalStatsService mamSvc) {
        this.personDao = personDao;
        this.dogDao = dogDao;
        this.mamSvc = mamSvc;
    }

    @GetMapping("/people")
    @ResponseBody
    public String getPeople() {

        Iterable<Person> people = personDao.findAll();

        String output = "";

        for (Person person : people) {
            output += "<h3>" + person.getName() + "</h3>";
            output += "<h4>" + person.getAge() + "</h4>";
            output += "<h4>" + person.getResideState() + "</h4>";
            output += "<hr>";
        }

        return output;
    }

    @GetMapping("/dogs")
    @ResponseBody
    public String getDogs() {

        Iterable<Dog> dogs = dogDao.findAll();

        String output = "";

        for (Dog dog : dogs) {
            output += "<h3>" + dog.getName() + "</h3>";
            output += "<h4>" + dog.getAge() + "</h4>";
            output += "<h4>" + dog.getResideState() + "</h4>";
            output += "<hr>";
        }

        output += "<br/>";
        output += "<form action=\"/dogs/create\" method=\"POST\"><button>Insert Dog</button></form>";
        output += "<form action=\"/dogs/delete\" method=\"POST\"><button>Delete Bud</button></form>";

        return output;
    }


    @GetMapping("/dogs/{id}")
    @ResponseBody
    public String getDog(@PathVariable long id) {

        Dog dog = dogDao.findOne(id);

        String output = "";
        output += "<h3>" + dog.getName() + "</h3>";
        output += "<h4>" + dog.getAge() + "</h4>";
        output += "<h4>" + dog.getResideState() + "</h4>";

        return output;
    }

    @PostMapping("/dogs/create")
    @ResponseBody
    public String insertDog() {
        // get dog object from form via model binding

        Dog dog = new Dog(3,"Puppy Pup", "TX");
        dogDao.save(dog);

        return "Dog inserted!";
    }


    @PostMapping("/dogs/delete")
    @ResponseBody
    public String deleteDog() {
        dogDao.deleteById(3);
        return "Dog deleted!";
    }


    @GetMapping("/mammal")
    @ResponseBody
    public String getMamInfo() {
        return "Average mammal age is: " + mamSvc.getAverageMammalAge();
    }


}
