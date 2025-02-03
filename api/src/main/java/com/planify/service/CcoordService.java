package com.planify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planify.dto.CcoordUpdateDto;
import com.planify.model.Ccoord;
import com.planify.model.Course;
import com.planify.model.User;
import com.planify.repository.CcoordRepository;
import com.planify.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CcoordService {
      
    @Autowired
    private CcoordRepository ccoordRepository;
    
    @Autowired
    private UserRepository userRepository;

    // Get all course coordinators
    public List<CcoordUpdateDto> getAllCoordinators() {
        return ccoordRepository.findSelectedFieldsFromCcoordAndUser();
    }

    // Get a course coordinator by ID
    public Optional<CcoordUpdateDto> getCoordinatorById(Long id) {
        return ccoordRepository.findSelectedFieldsFromCcoordAndUserById(id);
    }

    // Add a new course coordinator
    public Ccoord addCoordinator(CcoordUpdateDto details) {
    	User user = new User();
    	user.setFirstname(details.getFirstName());
    	user.setLastname(details.getLastName());
    	user.setEmail(details.getEmail());
    	user.setCourse(details.getCourse());
    	user.setMobilenumber(details.getMobilenumber());
    	user.setCategory("course coordinator");
    	user.setPassword("1234"); //this part is wrong forsure
    	Ccoord ccoord = new Ccoord();
    	ccoord.setUser(user);
    	ccoord.setCourse(details.getCourse());
    	ccoord.setDob(details.getDob());
    	ccoord.setSpecialization(details.getSpecialization());
    	userRepository.save(user);
    	return ccoordRepository.save(ccoord);
        
        

    }

    // Update an existing course coordinator
    public Ccoord updateCoordinator(Long id, CcoordUpdateDto details) {
    	Ccoord coordinator = ccoordRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Coordinator not found with id: " + id));
    	User user = coordinator.getUser();
    	
        coordinator.setCourse(details.getCourse());
        coordinator.setDob(details.getDob());
        coordinator.setSpecialization(details.getSpecialization());
        user.setCategory(details.getFirstName());
        user.setLastname(details.getLastName());
        user.setMobilenumber(details.getMobilenumber());
        user.setEmail(details.getEmail());
        userRepository.save(user);
        return ccoordRepository.save(coordinator);
    }
      
    // Delete a course coordinator
    public void deleteCoordinator(Long id) {
    	Ccoord coordinator = ccoordRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Coordinator not found with id: " + id));
    	User user = coordinator.getUser();
    	ccoordRepository.deleteById(id);
    	userRepository.deleteById(user.getId());
    }
}
