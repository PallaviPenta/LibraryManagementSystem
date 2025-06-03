package com.example.library.service;
import com.example.library.entity.Item;
import com.example.library.entity.Record;
import com.example.library.entity.Person;
import com.example.library.repository.ItemRepo;
import com.example.library.repository.RecordRepo;
import com.example.library.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class RecordService {
    @Autowired private RecordRepo recordRepo;
    @Autowired private ItemRepo itemRepo;
    @Autowired private PersonRepo personRepo;
    public Record borrowItem(Long itemId, Long personId) {
        Item item = itemRepo.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        Person person = personRepo.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
        if (!item.isAvailable()) throw new RuntimeException("Item is not available");
        item.setAvailable(false); itemRepo.save(item);
        Record record = new Record();
        record.setItem(item); record.setPerson(person); record.setStartDate(LocalDate.now()); record.setState("ISSUED");
        return recordRepo.save(record);
    }
    public Record returnItem(Long recordId) {
        Record record = recordRepo.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found"));
        record.setEndDate(LocalDate.now()); record.setState("RETURNED");
        Item item = record.getItem(); item.setAvailable(true); itemRepo.save(item);
        return recordRepo.save(record);
    }
    public List<Record> getByPerson(Long personId) {
        Person person = personRepo.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
        return recordRepo.findByPerson(person);
    }
    public List<Record> getOverdueItems(int days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return recordRepo.findOverdueItems(date);
    }
}

