package com.example.bookstorefall2020;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstorefall2020.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreFall2020ApplicationTests {

	@Autowired
	private BookController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
