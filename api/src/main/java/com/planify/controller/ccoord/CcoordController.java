package com.planify.controller.ccoord;

import org.springframework.web.bind.annotation.RestController;


import com.planify.model.Response;
import com.planify.service.CcoordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinators")
public class CcoordController {

    @Autowired
    private CcoordService coordinatorService;

    // Get all coordinators
    @GetMapping
    public ResponseEntity<Response> getAllCoordinators() {
        Response successResponse = new Response(
            HttpStatus.OK.value(),
            "success",
            coordinatorService.getAllCoordinators()
        );
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    // Get a coordinator by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseCoordinator> getCoordinatorById(@PathVariable Long id) {
        return coordinatorService.getCoordinatorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new coordinator
    @PostMapping
    public CourseCoordinator addCoordinator(@RequestBody CourseCoordinator coordinator) {
        return coordinatorService.addCoordinator(coordinator);
    }

    // Update an existing coordinator
    @PutMapping("/{id}")
    public ResponseEntity<CourseCoordinator> updateCoordinator(@PathVariable Long id, @RequestBody CourseCoordinator coordinatorDetails) {
        return ResponseEntity.ok(coordinatorService.updateCoordinator(id, coordinatorDetails));
    }

    // Delete a coordinator
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCoordinator(@PathVariable Long id) {
        coordinatorService.deleteCoordinator(id);
        Response successResponse = new Response(
            HttpStatus.OK.value(),
            "Deleted"
        );
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}


