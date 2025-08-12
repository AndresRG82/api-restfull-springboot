package cl.kibernumacademy.rest.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.kibernumacademy.rest.model.Book;
import cl.kibernumacademy.rest.service.IBookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
  
  private final IBookService bookService;

  public BookController(IBookService bookService) {
    this.bookService = bookService;
  }
  // Jackson -> JSON
  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody Book book) {
    Book createdBook = this.bookService.create(book);
    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(this.bookService.findAll());
  }
  


}

//* POST -> localhost:8080/api/books 
//* GET -> localhost:8080/api/books
//* GET -> localhost:8080/api/books/{id}
//* PUT -> localhost:8080/api/books/{id}
//* DELETE -> localhost:8080/api/books/{id}