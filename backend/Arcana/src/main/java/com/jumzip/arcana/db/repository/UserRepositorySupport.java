package com.jumzip.arcana.db.repository;

import com.jumzip.arcana.db.entity.User;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository @Primary
@Transactional
public class UserRepositorySupport implements UserRepository {

    private final EntityManager em;
    public UserRepositorySupport(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveUser(User user) { em.persist(user); }
    @Override
    public void removeUser(String uid) { em.remove(findUserByUid(uid)); }

    @Override
    public User findUserByUid(String uid) { return em.find(User.class, uid); }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}