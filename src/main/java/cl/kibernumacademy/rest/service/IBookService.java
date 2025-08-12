package cl.kibernumacademy.rest.service;

import java.util.List;
import java.util.Optional;

import cl.kibernumacademy.rest.dto.BookDTO;
import cl.kibernumacademy.rest.model.Book;

public interface IBookService {
  List<Book> findAll();
  Optional<Book> findById(Long id);
  Book create(BookDTO bookDTO);
  Book update(Long id, BookDTO book);
  void delete(Long id);
}
