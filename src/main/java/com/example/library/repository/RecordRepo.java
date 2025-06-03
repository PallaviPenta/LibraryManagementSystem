package com.example.library.repository;
import com.example.library.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface RecordRepo extends JpaRepository<Record, Long> {
    List<Record> findByPerson(Person person);
    List<Record> findByItem(Item item);
    @Query("SELECT r FROM Record r WHERE r.state = 'ISSUED' AND r.endDate IS NULL AND r.startDate < :date")
    List<Record> findOverdueItems(@Param("date") LocalDate date);
}
