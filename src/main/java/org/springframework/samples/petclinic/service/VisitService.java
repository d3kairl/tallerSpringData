package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

	@Autowired
	private VisitRepository visitRepo;
}
