package jp.ddo.chiroru.sample.integration;

import static org.junit.Assert.*;

import java.util.List;

import jp.ddo.chiroru.sample.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/repository-Context.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SimpleUserRepositoryTest {

    @Autowired
    SimpleUserRepository repository;

    @Test
    public void testInsert() {

        User user = new User();
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user = repository.save(user);
        assertEquals(user, repository.findOne(user.getId()));
    }

    @Test
    public void foo() throws Exception {

        User user = new User();
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user = repository.save(user);

        List<User> users = repository.findByLastname("lastname");

        assertNotNull(users);
        assertTrue(users.contains(user));
    }

    @Test
    public void testname() throws Exception {

        User user = new User();
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user = repository.save(user);

        List<User> users = repository.findByFirstnameOrLastname("lastname");

        assertTrue(users.contains(user));
    }
}
