package DAO;

import doamin.User;

import java.util.List;

public interface UserDAO {

    public void save(User user);

    public User get(int id);

    public List<User> getAll();

    public void delete(int id);

    public long getCountWithName(String name);

    public long getCountWithEmail(String email);

    public long getAllCount();

    public String getPasswordFromUsername(String username);

    public int getIdFromUsername(String username);


}
