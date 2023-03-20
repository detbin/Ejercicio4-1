package com.example.Ejercicio41.controller;

import com.example.Ejercicio41.entities.Book;
import com.example.Ejercicio41.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.Extension;
import java.util.List;
import java.util.Optional;

//rest controller nos permite crear los archivos de json y solo controller nos permitira crear archivos html
@RestController
public class BookController {
    //variable para lanzar el mensaje de warning en caso de querer crear un libro por id
    private final Logger log = LoggerFactory.getLogger(BookController.class);
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // metodo parra crear los CRUD
    //Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //recuperar y devolver los libros
        return bookRepository.findAll();
    }
    //Buscar un libro segun id
    @GetMapping("/api/books/{id}")
    //Pathvariable nos va asociar el id de la base de datos con el id del getmapping
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
        // tambien se puede return bookOpt.orElse(null) y sustituye



    }
    //Crear un libro
    @PostMapping("/api/books")
    public ResponseEntity<Object> create(@RequestBody Book book, @RequestHeader HttpHeaders  headers){
        System.out.println(headers.get("User-Agent"));
        //el User-agent es para saber quien nos esta enviando la peticion
        //hacemos un if para mandar un mensaje de eroor en caso de querer rear un libro con un id que ya existe
        if(book.getId() != null){
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
            Book result= bookRepository.save(book);
            return ResponseEntity.ok(result);
            //guardar el libro recibido por parametros en la base de datos
        }

        //Actualizar un libro
        @PutMapping("/api/books")
        public ResponseEntity<Object> update(@RequestBody Book book){
            if(book.getId() == null){
                log.warn("trying to update a book without id");
                return ResponseEntity.badRequest().build();
            }
            //verificamos que existe el libro
            if (!bookRepository.existsById(book.getId())){
                log.warn("Trying to Update a non existent book");
                return ResponseEntity.notFound().build();
            }
        Book result= bookRepository.save(book);
            return ResponseEntity.ok(result);
        }

        //borrar un libro
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Trying to Delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteall(){

        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
