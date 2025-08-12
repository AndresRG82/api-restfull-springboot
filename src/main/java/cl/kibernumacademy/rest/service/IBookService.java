package cl.kibernumacademy.rest.service;

import java.util.List;
import java.util.Optional;

import cl.kibernumacademy.rest.model.Book;

public interface IBookService {
  List<Book> findAll();
  Optional<Book> findById(Long id);
  Book create(Book book);
  Book update(Long id, Book book);
  void delete(Long id);
}
