	package com.sample.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.project.model.Contact;
import com.sample.project.repository.ContactRepository;
import com.sample.project.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	public ContactService contactService;
	
	//Get All the Contacts
	@GetMapping	
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Contact> getAll() {
		return contactService.getAll();
	}
	
	//Insert the contact
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public Contact insert(@RequestBody Contact contact) {
		return contactService.insert(contact);
	}
	
	//Get the contact by Id
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return contactService.getById(id);
	}
	
	//update the contact by Id
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Contact contact) {
		return contactService.update(id, contact);
	}
	
	//Delete the Contact by Id
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return contactService.delete(id);	
	}
}
