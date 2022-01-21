package com.sample.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sample.project.model.Contact;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
	
}
