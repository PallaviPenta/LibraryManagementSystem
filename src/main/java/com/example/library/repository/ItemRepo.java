package com.example.library.repository;
import com.example.library.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findByNameContainingIgnoreCase(String name);
    List<Item> findByWriterContainingIgnoreCase(String writer);
    List<Item> findByTypeContainingIgnoreCase(String type);
}
