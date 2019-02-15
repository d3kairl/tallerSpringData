package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepo;

	public PetRepository getPetRepo() {
		return petRepo;
	}

	public void setPetRepo(PetRepository petRepo) {
		this.petRepo = petRepo;
	}
}
