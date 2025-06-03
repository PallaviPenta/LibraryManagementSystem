package com.example.library.controller;
import com.example.library.entity.Item;
import com.example.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/items")
public class ItemController {
    @Autowired private ItemService itemService;
    @PostMapping public Item addItem(@RequestBody Item item) { return itemService.addItem(item); }
    @GetMapping public List<Item> getAllItems() { return itemService.getAllItems(); }
    @GetMapping("/search/name") public List<Item> findByName(@RequestParam String name) { return itemService.findByName(name); }
    @GetMapping("/search/writer") public List<Item> findByWriter(@RequestParam String writer) { return itemService.findByWriter(writer); }
    @GetMapping("/search/type") public List<Item> findByType(@RequestParam String type) { return itemService.findByType(type); }
    @DeleteMapping("/{id}") public void removeItem(@PathVariable Long id) { itemService.removeItem(id); }
}
