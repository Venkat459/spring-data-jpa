package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Embeddable
public class BookPublisherKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "book_id")
	Long bookId;

	@Column(name = "publisher_id")
	Long publisherId;

	// standard constructors, getters, and setters
	// hashcode and equals implementation

}
