package coinDispenserBackEnd;


import backend.entities.User;
import backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createNewUser(){
        User user = User.builder().firstname("John").lastname("Doe").email("johnDoe@gmail.com").password("123$567").build();
        User user1 = userRepository.save(user);
        assertEquals(user.getFirstname(), user1.getFirstname());
    }
}
