package JunitTest;

import DaoImpl.UserDaoImpl;
import doamin.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();


    @Test
    void save() {
        User user = new User(183020,"wjj","121212","999999");
        userDao.save(user);

    }

    @Test
    void get() {
        User user = userDao.get(183020);
        System.out.println(user.getId()+"   "+user.getUsername()+"   "+user.getEmail()+"   "+user.getPassword());
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void getCountWithName() {
    }

    @Test
    void getCountWithEmail() {
    }

    @Test
    void getAllCount() {
    }

    @Test
    void getPasswordFromUsername() {
    }

    @Test
    void getIdFromUsername() {
    }
}