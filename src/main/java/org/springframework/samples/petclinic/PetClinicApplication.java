/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.SpecialityRepository;
import org.springframework.samples.petclinic.repository.VetRepository;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	
	@Autowired
	VetRepository vetRepo;
	
	@Autowired
	SpecialityRepository specRepo;
	
	@Autowired
	OwnerRepository ownRepo;
	
	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");
			
			//TODO Añade aquí tu código
			/*Vet vet = new Vet();
			vet.setId(7);
			vet.setFirstName("Marian");
			vet.setLastName("Bulo");
			vetRepo.save(vet);
			System.out.println("Se ha añadido a " +  vet.toString());*/
			Vet vetPrueba = vetRepo.findOne(7);
			System.out.println("Se ha recuperado a " +  vetPrueba.toString());
			vetPrueba.addSpecialty(specRepo.findFirstByName("radiology")); // Añade la especialidad de radiology
			vetRepo.save(vetPrueba);
			System.out.println("Lista de veterinarios\n=====================");
			for(Vet vet : vetRepo.findAll()) {
				System.out.println("Se ha recuperado a " +  vet.toString());
			}
			String busqueda = "Bulo";
			System.out.println("Lista de veterinarios que se llaman o apellidan "+busqueda+"\n=====================");
			for(Vet vet : vetRepo.findByFirstNameOrLastName(busqueda, busqueda)) {
				System.out.println("Se ha recuperado a " +  vet.toString());
			}
			
			System.out.println("Lista de veterinarios radiologos\n=====================");
			for(Vet vet : vetRepo.findBySpecialty("radiology")) {
				System.out.println("Se ha recuperado a " +  vet.toString());
			}
			System.out.println("Lista de propietarios encontrados\n=====================");
			for(Owner own : ownRepo.findByFirstNameOrLastName("Mari")) {
				System.out.println("Se ha recuperado a " +  own.toString());
			}
		
			
		};
	}
    
}
