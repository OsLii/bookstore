package com.example.bookstorefall2020;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.bookstorefall2020.model.Book;
import com.example.bookstorefall2020.model.BookRepository;
import com.example.bookstorefall2020.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;

	@Test
	public void findByIdShouldReturnBook() {
		List<Book> books = repository.findByTitle("Taru sormusten herrasta");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Taru sormusten herrasta");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("TestiKirjailija", "TestiTitle", 2020, "6426534", 20, new Category("TestiKategoria"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Taru sormusten herrasta");
        repository.deleteById(books.get(0).getId());
    	 assertThat(repository.findByTitle("Taru sormusten herrasta")).hasSize(0);

	}

}
