package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User usr) {
        entityManager.persist(usr);
    }


    @Override
    public List getAllUsers() {
        return entityManager.createQuery("select user From User user ").getResultList();
    }

    @Override
    public void update(User usr) {
        entityManager.merge(usr);
    }

    @Override
    public void delete(User usr) {
        entityManager.remove(entityManager.contains(usr) ? usr : entityManager.merge(usr));
    }

}
