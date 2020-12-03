package DaoImpl;

import DAO.DAO;
import DAO.UserDAO;
import doamin.User;

import java.util.List;

public class UserDaoImpl extends DAO<User> implements UserDAO {

    @Override
    public void save(User user) {
        String sql = "insert into user(id, username, email, password) values(?,?,?,?)";
        updata(sql,user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
    }

    @Override
    public User get(int id) {
        String sql = "SELECT id, username, email, password FROM user WHERE id = ?";
        return get(sql,id);
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        return getAll(sql);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        updata(sql,id);
    }

    @Override
    public long getCountWithName(String name) {
        String sql = "select count(id) from user where username = ?";
        long count = getForValue(sql,name);
        return count;
    }

    @Override
    public long getCountWithEmail(String email) {
        String sql = "select count(id) from user where email = ?";
        long count = getForValue(sql,email);
        return count;
    }

    @Override
    public long getAllCount() {
        String sql = "select count(1) from user";
        long count = getForValue(sql);
        return count;
    }

    @Override
    public String getPasswordFromUsername(String username) {
        String sql = "select password from user where username = ?";
        String password = getForValue(sql,username);
        return password;
    }

    @Override
    public int getIdFromUsername(String username) {
        String sql = "select id from user where username = '"+username+"'";
        int id = Integer.parseInt(getForValue(sql));
        return id;
    }
}
