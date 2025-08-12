package cl.kibernumacademy.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.kibernumacademy.rest.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {
	// Inherits: List<Book> findAll(), Optional<Book> findById(Long id), save, delete, etc.
}

//* Select * from Books; -> findAll()
//* Select * from Books where id = ? -> findById(id)
