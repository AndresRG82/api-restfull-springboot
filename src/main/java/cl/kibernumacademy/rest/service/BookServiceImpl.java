package cl.kibernumacademy.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.kibernumacademy.rest.exception.ResourceNotFoundException;
import cl.kibernumacademy.rest.model.Book;
import cl.kibernumacademy.rest.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

  private final IBookRepository bookRepository;

  public BookServiceImpl(IBookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> findAll() {
  return this.bookRepository.findAll(); // * Select * from books;
  }

  @Override
  public Optional<Book> findById(Long id) {
    return this.bookRepository.findById(id); // * Select * from books where id = ?;
  }

  @Override
  public Book create(Book book) {
    return this.bookRepository.save(book); // * Insert into books (title, author, isbn) values (?, ?, ?);
  }

  @Override
  public Book update(Long id, Book book) {
    Book existing = this.bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));

    existing.setTitle(book.getTitle());
    existing.setAuthor(book.getAuthor());
    existing.setIsbn(book.getIsbn());
    return this.bookRepository.save(existing); // * Update books set title = ?, author = ?,
  }

  @Override
  public void delete(Long id) {
  Book existing = this.bookRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
  this.bookRepository.delete(existing);
  }

}
