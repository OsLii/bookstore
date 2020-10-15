package com.example.bookstorefall2020;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstorefall2020.model.Category;
import com.example.bookstorefall2020.model.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByIdShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Toiminta");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Toiminta");
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("TestiKategoria");
		crepository.save(category);
		assertThat(category.getName()).isNotNull();
	}

}