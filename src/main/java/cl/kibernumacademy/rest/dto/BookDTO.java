package cl.kibernumacademy.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
  @NotBlank(message = "Title is mandatory")
  @Size(max = 100)
  private String title;

  @NotBlank(message = "Author is mandatory")
  @Size(max = 100)
  private String author;

  @NotBlank(message = "ISBN is mandatory")
  @Size(max = 20)
  private String isbn;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}

/*
*
* Un DTO (Data Transfer Object) es como una cajita a medida que usas para enviar o recibir datos entre tu API y el cliente.
  No siempre quieres mandar o recibir toda la información de tu entidad (la clase que representa la tabla en la base de datos), porque:
  No siempre necesitas todos los datos → ahorras peso en la respuesta.
  Proteges información sensible → no mandas campos que no quieres mostrar (por ejemplo, contraseñas, IDs internos, etc.).
* */