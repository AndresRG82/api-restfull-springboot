package cl.kibernumacademy.rest.repository;

import org.springframework.data.repository.CrudRepository;

import cl.kibernumacademy.rest.model.Book;

public interface IBookRepository extends CrudRepository<Book, Long>{
  
}

//* Select * from Books; -> findAll()
//* Select * from Books where id = ? -> findById(id)
