package cl.kibernumacademy.rest.controller;

import java.util.List;

import cl.kibernumacademy.rest.dto.BookDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
    Book createdBook = this.bookService.create(bookDTO);
    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(this.bookService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
    return ResponseEntity.ok(this.bookService.update(id, bookDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
  /*
  // Forma tradicional (sin Optional.map):
  Optional<Book> bookOpt = this.bookService.findById(id);
  if (bookOpt.isPresent()) {
    return ResponseEntity.ok(bookOpt.get());
  } else {
    return ResponseEntity.notFound().build();
  }
  */
  return this.bookService.findById(id) // Busca el libro por su id. El resultado es un Optional<Book> que puede estar vacío si no existe el libro.
    .map(ResponseEntity::ok)            // map es un método de Optional (inspirado en la programación funcional) que permite transformar el valor solo si está presente, evitando ifs explícitos.
                                       // Aquí, si el Optional contiene un libro, lo transforma en una respuesta HTTP 200 OK con el libro en el cuerpo.
    .orElse(ResponseEntity.notFound().build()); // Si el Optional está vacío (no se encontró el libro), retorna una respuesta HTTP 404 Not Found.
  }
  /*
  Qué hace @Valid
    - Activa Bean Validation (Jakarta Validation, Hibernate Validator) sobre el objeto anotado.
    - Valida los campos marcados con anotaciones como @NotNull, @NotBlank, @Size, @Positive, etc., antes de entrar a tu lógica.
   */

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    this.bookService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

//* POST -> localhost:8080/api/books 
//* GET -> localhost:8080/api/books
//* GET -> localhost:8080/api/books/{id}
//* PUT -> localhost:8080/api/books/{id} -> localhost:8080/api/books/1
//* DELETE -> localhost:8080/api/books/{id}