package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor

@Entity
@Table(name = "book_publisher")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class BookPublisher implements Serializable {

	  
   /* @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookPublisher other = (BookPublisher) obj;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
*/

	public BookPublisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookPublisher [book=" + book.getId() + ", publisher=" + publisher.getId() + ", publishedDate=" + publishedDate + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne()
	@JsonBackReference
    @JoinColumn
    private Book book;

	@Id
    @ManyToOne()
	@JsonBackReference
    @JoinColumn
    private Publisher publisher;

    private Date publishedDate;

   /* public BookPublisher(Publisher publisher, Date publishedDate) {
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }
 

    
    public BookPublisher(Date  publishedDate) {
      
        this.publishedDate = publishedDate;
    }*/
   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookPublisher)) return false;
        BookPublisher that = (BookPublisher) o;
        return Objects.equals(book.getId(), that.book.getId()) &&
               Objects.equals(publisher.getId(), that.publisher.getId());
        
       //return  Objects.equals(publisher.getId(), that.publisher.getId());
    }

    @Override
    public int hashCode() {
       return Objects.hash(book.getId(), publisher.getId());
    	//return Objects.hash(publisher.getId());
    }
}
