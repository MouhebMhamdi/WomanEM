package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Complaints;
import com.example.demo.services.ComplaintsService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/complaints")
public class ComplaintsController {
	@Autowired
	private ComplaintsService complaintsService;
	
	@PostMapping("/add")
	public Complaints addComplaints(@RequestBody Complaints complaints) {
		return complaintsService.addComplaints(complaints) ;
		
	}
	@PutMapping("/update")
	public Complaints updateComplaints(@RequestBody Complaints complaints) {
		return complaintsService.updateComplaints(complaints);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteComplaints(@PathVariable Long id) {
		
		complaintsService.deleteComplaints(id);
		
	}
	@GetMapping("/all")
	public List<Complaints> getAll(){
		return complaintsService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Complaints findById(Long id) {
		return complaintsService.findById(id);
		
	}

}
