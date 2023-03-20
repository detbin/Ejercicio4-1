package com.example.Ejercicio41.service;

import com.example.Ejercicio41.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        //configuracion de la prueba
        Book book = new Book(1L, "El senor de los anillos", "Author", 1000, 49.99, LocalDate.now(),true)
        BookPriceCalculator calculator = new BookPriceCalculator();
        //se ejecuta comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);
        // comprobacion aserciones
        assertTrue(price>0);
        assertEquals(57.980000000000004,price);

    }
}