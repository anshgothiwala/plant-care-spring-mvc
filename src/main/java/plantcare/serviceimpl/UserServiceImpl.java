package plantcare.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import plantcare.dao.UserDao;
import plantcare.model.User;
import plantcare.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(User user) {
		userDao.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userDao.delete(id);
		
	}

	@Override
	public User getUserById(int id) {
		User user = userDao.getById(id);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

}
