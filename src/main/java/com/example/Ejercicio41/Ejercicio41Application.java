package com.example.Ejercicio41;

import com.example.Ejercicio41.entities.Book;
import com.example.Ejercicio41.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
//estos escaneara todos los beans

public class Ejercicio41Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Ejercicio41Application.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//CRUD
		//crear un libro
		Book book1 = new Book(null, "Homo Devs" , "Yuval Noah", 450, 29.99, LocalDate.of(2018,12,1),true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013,12,1),false);
		//almacenar un libro
		System.out.println("Numero de libros en la base de datos:"+repository.findAll().size());
		repository.save(book1);
		repository.save(book2);
		//recuperar todos los libros
		System.out.println("Numero de libros en la base de datos:"+repository.findAll().size());
		// borrar un libro la L para que lo interprete como L el n'umero 1 y no un integer
		//repository.deleteById(1L);
		System.out.println("Numero de libros en la base de datos:"+repository.findAll().size());
	}
}
