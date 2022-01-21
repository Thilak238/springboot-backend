package com.sample.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.project.model.Contact;
import com.sample.project.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	public ContactRepository contactRepository;
	
	public Iterable<Contact> getAll() {
		return contactRepository.findAll();
	}
	
	public Contact insert(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public ResponseEntity<?> getById(Long id) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		if(optionalContact.isPresent()) {
			return ResponseEntity.ok(optionalContact.get());
		}
		else {
			return ResponseEntity.ok("Id cannot be found");
		}
	}
	
	public ResponseEntity<?> update(Long id,Contact contact) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		if(optionalContact.isPresent()) {
			Contact persistentContact = optionalContact.get();
			persistentContact.setName(contact.getName());
			persistentContact.setEmailId(contact.getEmailId());
			persistentContact.setPhoneNumber(contact.getPhoneNumber());
			contactRepository.save(persistentContact);
			return ResponseEntity.ok(persistentContact);
		}
		else {
			return ResponseEntity.ok("Id does not exist");
		}
	}
	
	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		if(optionalContact.isPresent()) {
			contactRepository.deleteById(id);
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		else {
			response.put("deleted",Boolean.FALSE);
			return ResponseEntity.ok(response);
		}
	}
}
