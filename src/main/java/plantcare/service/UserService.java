package plantcare.service;

import plantcare.model.User;
import java.util.List;

public interface UserService {
    void registerUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
