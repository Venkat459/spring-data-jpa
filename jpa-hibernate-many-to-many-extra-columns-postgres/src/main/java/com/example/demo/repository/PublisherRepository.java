package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Integer>{ 

}
