package org.humber.project.controllers;


import org.humber.project.domain.TimeOff;
import org.humber.project.services.TimeOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/timeOffs")
public class TimeOffController {


    private final TimeOffService timeOffService;


    @Autowired
    public TimeOffController(TimeOffService timeOffService) {
        this.timeOffService = timeOffService;
    }


    @PostMapping
    public ResponseEntity<TimeOff> createTimeOff(@RequestBody TimeOff timeOff) {
        TimeOff createdTimeOff = timeOffService.createTimeOff(timeOff).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimeOff);
    }


    @GetMapping("/{timeOffId}")
    public TimeOff getTimeOff(@PathVariable Long timeOffId) {
        return timeOffService.getTimeOff(timeOffId).build();
    }


    @PutMapping("/{timeOffId}")
    public ResponseEntity<TimeOff> updateTimeOff(@PathVariable Long timeOffId, @RequestBody TimeOff timeOff) {
        // Set the timeOffId from path variable
        timeOff.setId(timeOffId);
        TimeOff updatedTimeOff = timeOffService.updateTimeOff(timeOff);
        return ResponseEntity.ok(updatedTimeOff);
    }


    @DeleteMapping("/{timeOffId}")
    public ResponseEntity<Void> deleteTimeOff(@PathVariable Long timeOffId) {
        boolean deleted = timeOffService.deleteTimeOff(timeOffId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
