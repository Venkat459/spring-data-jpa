package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

}
