package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {
    UserMeal create(UserMeal userMeal);

    UserMeal update(UserMeal userMeal, int userId);

    boolean delete(int id, int userId);

    UserMeal get(int id, int userId);

    List<UserMeal> getAll(int userId,
                          LocalDate startDate,
                          LocalTime startTime,
                          LocalDate endDate,
                          LocalTime endTime);

    List<UserMeal> getAll(int userId);
}
