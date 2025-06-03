package com.example.library.service;
import com.example.library.entity.Person;
import com.example.library.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PersonService {
    @Autowired private PersonRepo personRepo;
    public Person addPerson(Person person) { return personRepo.save(person); }
    public List<Person> getAllPeople() { return personRepo.findAll(); }
    public void removePerson(Long id) { personRepo.deleteById(id); }
}
