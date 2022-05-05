package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Complaints;
import com.example.demo.repository.ComplaintsRepository;

@Service
public class ComplaintsServiceImpl implements ComplaintsService{

	@Autowired
	private ComplaintsRepository complaintsRepository;
	
	
	
	@Override
	public Complaints addComplaints(Complaints complaints) {
		
		return complaintsRepository.save(complaints);
	}

	@Override
	public Complaints updateComplaints(Complaints complaints) {
	
		return complaintsRepository.save(complaints);
	}

	@Override
	public void deleteComplaints(Long id) {
		complaintsRepository.deleteById(id);
		
	}

	@Override
	public List<Complaints> getAll() {
		return complaintsRepository.findAll();
	}

	@Override
	public Complaints findById(Long id) {
		return complaintsRepository.findById(id).orElse(null);
	}

}
