package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

	@Autowired
	private  OwnerRepository ownRepo;

	public OwnerRepository getOwnRepo() {
		return ownRepo;
	}

	public void setOwnRepo(OwnerRepository ownRepo) {
		this.ownRepo = ownRepo;
	}
}
