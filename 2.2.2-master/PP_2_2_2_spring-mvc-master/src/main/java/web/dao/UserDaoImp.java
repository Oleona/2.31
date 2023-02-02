package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void delete(Long userId) {
        User user = em.find(User.class, userId);
        em.remove(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(long userid) {
        User user = em.find(User.class, userid);
        return user;
    }
}
