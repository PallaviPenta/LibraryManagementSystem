package com.example.library.controller;
import com.example.library.entity.Person;
import com.example.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/people")
public class PersonController {
    @Autowired private PersonService personService;
    @PostMapping public Person addPerson(@RequestBody Person person) { return personService.addPerson(person); }
    @GetMapping public List<Person> getAllPeople() { return personService.getAllPeople(); }
    @DeleteMapping("/{id}") public void removePerson(@PathVariable Long id) { personService.removePerson(id); }
}
