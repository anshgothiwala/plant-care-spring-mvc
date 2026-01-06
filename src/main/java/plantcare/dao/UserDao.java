package plantcare.dao;

import java.util.List;

import plantcare.model.User;

public interface UserDao {
	void save(User user);
    void update(User user);
    void delete(int id);
    User getById(int id);
    User getByEmail(String email);
    List<User> getAll();
}
