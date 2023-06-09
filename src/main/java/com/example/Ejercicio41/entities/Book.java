package com.example.Ejercicio41.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
//para que los atributos sean las columnas de la base de datos
@Table(name="books")
//para ponerle nombre a la base de datos

public class Book {
    //atributos
    @Id
    //para que le coloque un id a cada fila de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //para que maneje los id y no tengamos que estar pendientes de el manejo de los id
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private double price;
    private LocalDate releaseDate;
    private boolean onLine;
    //constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, double price, LocalDate releaseDate, boolean onLine) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.onLine = onLine;
    }

    //metodos

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }
}
