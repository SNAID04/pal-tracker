package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = this.timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(timeEntry,HttpStatus.CREATED) ;
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = this.timeEntryRepository.find(id);
        if(timeEntry!=null) {
                return new ResponseEntity(timeEntry, HttpStatus.OK);
            } else {
                return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
            }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list = this.timeEntryRepository.list();
      return new ResponseEntity(list,HttpStatus.OK) ;
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry updateResult = this.timeEntryRepository.update(id, expected);
           if(updateResult!=null){
               return new ResponseEntity(updateResult,HttpStatus.OK) ;}
        else{
            return new ResponseEntity(expected, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        TimeEntry delete = this.timeEntryRepository.delete(id);
        return new ResponseEntity(delete,HttpStatus.NO_CONTENT) ;
    }
}
