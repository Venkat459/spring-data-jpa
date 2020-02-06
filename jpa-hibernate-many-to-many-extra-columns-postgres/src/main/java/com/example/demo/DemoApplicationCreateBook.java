package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Book;
import com.example.demo.model.BookPublisher;
import com.example.demo.model.Publisher;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class DemoApplicationCreateBook implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationCreateBook.class, args);
	}

	@Override
	public void run(String... args) {

	savePublishers();
		getPublsihers();
		saveBooks_V2();
		// deleteBook(1);
	//	updateBook();
		
		updateBooKName();

	}

	private void savePublishers() {
		Publisher publisherA = new Publisher("Publisher A");
		Publisher publisherB = new Publisher("Publisher B");
		publisherRepository.saveAll(Arrays.asList(publisherA, publisherB));
	}

	private List<Publisher> getPublsihers() {
		List<Publisher> publishers = publisherRepository.findAll();
		System.out.println("Total Publishers:" + publishers.size());
		// System.out.println("Total Publishers:" + publishers.get(0).toString());
		// System.out.println("Total Publishers:" + publishers.get(1).toString());
		return publishers;

	}

	/*
	 * private void saveBooks() { Publisher publisherA = new Publisher(1); Publisher
	 * publisherB = new Publisher(2); Set<Publisher> publishers = new HashSet<>();
	 * publishers.add(publisherA); publishers.add(publisherB); BookPublisher
	 * bookPublisher1 = new BookPublisher(); bookPublisher1.setPublishedDate(new
	 * Date()); bookPublisher1.setPublisher(publisherA);
	 * 
	 * BookPublisher bookPublisher2 = new BookPublisher();
	 * bookPublisher2.setPublishedDate(new Date());
	 * bookPublisher2.setPublisher(publisherB);
	 * 
	 * Set<BookPublisher> bookPublishers = new HashSet<>();
	 * bookPublishers.add(bookPublisher1); bookPublishers.add(bookPublisher2);
	 * System.out.println("Size:" + bookPublishers.size()); Book b1 = new
	 * Book("book 1"); b1.setId(2); b1.getBookPublishers().addAll(bookPublishers);
	 * 
	 * bookRepository.save(b1); }
	 */

	private void saveBooks_V2() {
		// Create a couple of Book, Publisher and BookPublisher
		Publisher publisherA = new Publisher(1);
		Publisher publisherB = new Publisher(2);
		/* publisherRepository.saveAll(Arrays.asList(publisherA, publisherB)); */
		Book book1 = new Book("Book 1");
		
		BookPublisher bookPublisher1 = new BookPublisher();
		bookPublisher1.setPublisher(publisherA);
		bookPublisher1.setPublishedDate(new Date());
		bookPublisher1.setBook(book1);
		
		BookPublisher bookPublisher2 = new BookPublisher();
		bookPublisher2.setPublisher(publisherB);
		bookPublisher2.setPublishedDate(new Date());
		bookPublisher2.setBook(book1);
		book1.getBookPublishers().add(bookPublisher1);
		book1.getBookPublishers().add(bookPublisher2);

		
		System.out.println("book1 size:" + book1.getBookPublishers().size());

		

		bookRepository.save(book1);
	
		// bookRepository.save(book2);
	}

	private void updateBook() {
		// Create a couple of Book, Publisher and BookPublisher
		Publisher publisherA = new Publisher(3);
		Publisher publisherB = new Publisher(4);
		/* publisherRepository.saveAll(Arrays.asList(publisherA, publisherB)); */

		Optional<Book> ob = bookRepository.findById(2);
		Book book = ob.get();

		System.out.println("Book Id:" + book.getId());

		System.out.println("Book name:" + book.getName());

		System.out.println("Existing size:" + book.getBookPublishers().size());
		/*BookPublisher bookPublisher1 = new BookPublisher(publisherA, new Date());
		bookPublisher1.setBook(book);

		BookPublisher bookPublisher2 = new BookPublisher(publisherB, new Date());*/
		/*bookPublisher2.setBook(book);
		book.getBookPublishers().add(bookPublisher1);
		book.getBookPublishers().add(bookPublisher2);*/
		// book.getBookPublishers().add(new BookPublisher(publisherB, new Date()));
		System.out.println("book1 size:" + book.getBookPublishers().size());
		book.getBookPublishers().clear();
		BookPublisher bookPublisher1 = new BookPublisher();
		bookPublisher1.setPublisher(publisherA);
		bookPublisher1.setPublishedDate(new Date());
		bookPublisher1.setBook(book);
		
		BookPublisher bookPublisher2 = new BookPublisher();
		bookPublisher2.setPublisher(publisherB);
		bookPublisher2.setPublishedDate(new Date());
		bookPublisher2.setBook(book);
		book.getBookPublishers().add(bookPublisher1);
		book.getBookPublishers().add(bookPublisher2);
		System.out.println("book1 size:" + book.getBookPublishers().size());
		bookRepository.save(book);
	}

	private void deleteBook(Integer bookId) {
		bookRepository.deleteById(1);
	}
	
	private void updateBooKName() {
	

		Optional<Book> ob = bookRepository.findById(1);
		Book book = ob.get();
		
	
		System.out.println("Book Id:" + book.getId());

		System.out.println("Book name:" + book.getName());
		
		book.setName("updateBookName");
		bookRepository.save(book);
   }
}

