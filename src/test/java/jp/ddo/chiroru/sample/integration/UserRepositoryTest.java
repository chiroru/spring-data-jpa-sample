package jp.ddo.chiroru.sample.integration;

import static org.hamcrest.CoreMatchers.*;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void ユーザ情報を登録()
            throws Exception {

        User user = new User();
        user.setUsername("username");
        user = repository.save(user);
        assertThat(repository.findOne(user.getId()), is(user));
    }

    @Test
    public void 苗字および名前で検索()
            throws Exception {

        User user = new User();
        user.setUsername("foobar");
        user.setLastname("lastname");

        user = repository.save(user);

        List<User> users = repository.findByLastname("lastname");

        assertNotNull(users);
        assertTrue(users.contains(user));

        User reference = repository.findByTheUsersName("foobar");
        assertEquals(user, reference);
    }

    @Test
    public void testCustomMethod() {

        User user = new User();
        user.setUsername("username");

        user = repository.save(user);

        List<User> users = repository.myCustomBatchOperation();

        assertNotNull(users);
        assertTrue(users.contains(user));
    }
}
