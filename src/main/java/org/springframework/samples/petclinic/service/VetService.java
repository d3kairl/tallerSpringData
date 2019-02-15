package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

@Service
public class VetService {

	@Autowired
	private VetRepository vetRepo;
}
