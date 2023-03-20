package com.example.Ejercicio41.repository;

import com.example.Ejercicio41.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JpaRepository nos va a proposionar los metodos CreateRemoveUpdateDelete CRUD
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
