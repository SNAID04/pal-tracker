package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> Entries = new HashMap<>();
    private long idCounter = 1;

    public TimeEntry find(long l) {
        return Entries.get(l);
    }
    
    public TimeEntry create(TimeEntry t){
        TimeEntry saved = new TimeEntry(idCounter++, t.getProjectId(), t.getUserId(), t.getDate(), t.getHours());
        Entries.put(saved.getId(),saved);
        return saved;
    }


    public List<TimeEntry> list() {
        return new ArrayList<>(Entries.values());
    }

    public TimeEntry update(Long id, TimeEntry t) {
        TimeEntry updated = new TimeEntry(id, t.getProjectId(), t.getUserId(), t.getDate(), t.getHours());
        Entries.put(updated.getId(),updated);
        return updated;
    }

    public TimeEntry delete(Long id) {
        Entries.remove(id);
        return Entries.get(id);
    }
}
