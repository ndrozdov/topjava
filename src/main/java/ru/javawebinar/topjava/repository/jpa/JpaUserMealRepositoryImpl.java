package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    @Transactional
    public UserMeal get(int id, int userId) {
        User ref = em.getReference(User.class, userId);
        UserMeal meal = em.find(UserMeal.class, id);
        System.out.println(meal);
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}