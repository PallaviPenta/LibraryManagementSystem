package com.example.library.service;
import com.example.library.entity.Item;
import com.example.library.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ItemService {
    @Autowired private ItemRepo itemRepo;
    public Item addItem(Item item) { return itemRepo.save(item); }
    public List<Item> getAllItems() { return itemRepo.findAll(); }
    public List<Item> findByName(String name) { return itemRepo.findByNameContainingIgnoreCase(name); }
    public List<Item> findByWriter(String writer) { return itemRepo.findByWriterContainingIgnoreCase(writer); }
    public List<Item> findByType(String type) { return itemRepo.findByTypeContainingIgnoreCase(type); }
    public void removeItem(Long id) { itemRepo.deleteById(id); }
}
