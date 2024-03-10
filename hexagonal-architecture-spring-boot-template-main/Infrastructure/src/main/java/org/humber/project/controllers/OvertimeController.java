package org.humber.project.controllers;


import org.humber.project.domain.Overtime;
import org.humber.project.services.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/overtimes")
public class OvertimeController {


    private final OvertimeService overtimeService;


    @Autowired
    public OvertimeController(OvertimeService overtimeService) {
        this.overtimeService = overtimeService;
    }


    @PostMapping
    public ResponseEntity<Overtime> createOvertime(@RequestBody Overtime overtime) {
        Overtime createdOvertime = overtimeService.createOvertime(overtime).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOvertime);
    }


    @GetMapping("/{overtimeId}")
    public Overtime getOvertime(@PathVariable Long overtimeId) {
        return overtimeService.getOvertime(overtimeId).build();
    }


    @PutMapping("/{overtimeId}")
    public ResponseEntity<Overtime> updateOvertime(@PathVariable Long overtimeId, @RequestBody Overtime overtime) {
        // Set the overtimeId from path variable
        overtime.setId(overtimeId);
        Overtime updatedOvertime = overtimeService.updateOvertime(overtime);
        return ResponseEntity.ok(updatedOvertime);
    }


    @DeleteMapping("/{overtimeId}")
    public ResponseEntity<Void> deleteOvertime(@PathVariable Long overtimeId) {
        boolean deleted = overtimeService.deleteOvertime(overtimeId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
