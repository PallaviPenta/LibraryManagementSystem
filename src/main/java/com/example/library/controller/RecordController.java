package com.example.library.controller;
import com.example.library.entity.Record;
import com.example.library.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/records")
public class RecordController {
    @Autowired private RecordService recordService;
    @PostMapping("/borrow") public Record borrowItem(@RequestParam Long itemId, @RequestParam Long personId) { return recordService.borrowItem(itemId, personId); }
    @PostMapping("/return/{recordId}") public Record returnItem(@PathVariable Long recordId) { return recordService.returnItem(recordId); }
    @GetMapping("/person/{personId}") public List<Record> getByPerson(@PathVariable Long personId) { return recordService.getByPerson(personId); }
    @GetMapping("/overdue") public List<Record> getOverdueItems(@RequestParam(defaultValue = "14") int days) { return recordService.getOverdueItems(days); }
}
