package cl.kibernumacademy.rest.service;

import java.util.List;
import java.util.Optional;

import cl.kibernumacademy.rest.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional
  public Book create(BookDTO bookDTO) {
    Book book = new Book();
    book.setTitle(bookDTO.getTitle());
    book.setAuthor(bookDTO.getAuthor());
    book.setIsbn(bookDTO.getIsbn());
    return this.bookRepository.save(book);
  }

  @Override
  @Transactional
  public Book update(Long id, BookDTO book) {
    Book existing = this.bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));

    existing.setTitle(book.getTitle());
    existing.setAuthor(book.getAuthor());
    existing.setIsbn(book.getIsbn());
    return this.bookRepository.save(existing); // * Update books set title = ?, author = ?,
  }

  @Override
  @Transactional
  public void delete(Long id) {
  Book existing = this.bookRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
  this.bookRepository.delete(existing);
  }

}
