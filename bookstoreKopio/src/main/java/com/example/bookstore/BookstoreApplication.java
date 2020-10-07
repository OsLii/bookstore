package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookdemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Kauhu"));

			Book book1 = new Book("Kirjailija1", "123", "Olipa kerran", 1955, crepository.findByName("Kauhu").get(0));

			brepository.save(book1);

		};
	}

}
