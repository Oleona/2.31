package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    public void delete(Long userId);

    public void update(User user);

    public User getUserById(long userid);
}
