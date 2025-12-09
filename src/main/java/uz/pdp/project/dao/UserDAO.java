package uz.pdp.project.dao;

import jakarta.persistence.TypedQuery;
import jakarta.validation.constraints.NotNull;
import uz.pdp.project.entity.User;

import java.util.Optional;

public class UserDAO extends BaseDAO<User, String>{

    public Optional<User> findByEmail(@NotNull String email){
        try {
            begin();
            TypedQuery<User> query = em.createQuery("select u from User u where u.email ilike :email", User.class);
            query.setParameter("email", email);
            User user = query.getSingleResult();
            commit();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public User save(User user) {
        begin();
        em.persist(user);
        commit();
        return user;
    }
}
