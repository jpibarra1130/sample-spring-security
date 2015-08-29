package com.ibarra.dao;

import com.ibarra.Application;
import com.ibarra.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by paoloibarra on 22/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup(){
        userRepository.deleteAll();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setEncryptedPassword("password");
        user.setEmail("hallo");

        userRepository.save(user);
        User savedUser = userRepository.findByEmail("hallo");
        assertThat("", savedUser.getEmail(), is("hallo"));
    }
}
