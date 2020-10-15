package com.example.bookstorefall2020;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.bookstorefall2020.model.User;
import com.example.bookstorefall2020.model.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void createNewUser() {
		User user = new User("TestiUser", "TestiUserSalasana", "TestiUserEmail", "User");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
