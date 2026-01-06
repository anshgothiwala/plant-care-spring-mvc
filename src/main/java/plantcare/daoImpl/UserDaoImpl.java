package plantcare.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import plantcare.dao.UserDao;
import plantcare.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		this.hibernateTemplate.update(user);
	}

	@Override
	public void delete(int id) {
		User user = this.hibernateTemplate.load(User.class, id);
        if (user != null) 
        {
            this.hibernateTemplate.delete(user);
        }
    }

	@Override
	public User getById(int id) {
		User user = this.hibernateTemplate.load(User.class, id);
		return user;
	}

	@Override
	public User getByEmail(String email) {
		/*
		 * List<User> users = (List<User>)
		 * this.hibernateTemplate.find("from User where email = ?", email); return
		 * users.isEmpty() ? null : users.get(0);
		 */
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

	    Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
	    query.setParameter("email", email);  // named parameter

	    return query.uniqueResult();  // returns single User or null
	}

	@Override
	public List<User> getAll() {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}

}
