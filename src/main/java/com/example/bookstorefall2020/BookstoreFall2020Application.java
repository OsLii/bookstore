package com.example.bookstorefall2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstorefall2020.model.Book;
import com.example.bookstorefall2020.model.BookRepository;
import com.example.bookstorefall2020.model.Category;
import com.example.bookstorefall2020.model.CategoryRepository;

@SpringBootApplication
public class BookstoreFall2020Application {
	private static final Logger log = LoggerFactory.getLogger(BookstoreFall2020Application.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreFall2020Application.class, args);
	}

	@Bean
	public CommandLineRunner bookdemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Toiminta"));

			Book book1 = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 2000, "	951-31-1737-5",
					10.0, crepository.findByName("Kauhu").get(0));
			Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1998, "	951-31-1146-6",
					8.0, crepository.findByName("Fantasia").get(0));

			brepository.save(book1);
			brepository.save(book2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());

			}
		};

	}
}