package com.example.library.repository;
import com.example.library.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {}
