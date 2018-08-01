package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry find(Long l);

   List<TimeEntry> list();

    TimeEntry update(Long id, TimeEntry t);

    void delete(Long id);
}
