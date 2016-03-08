package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Brother on 06.03.2016.
 */
public class MealDaoImpl implements MealDao {
    private Map<Integer, UserMeal> hashTable;
    public static AtomicInteger maxId = new AtomicInteger(0);

    public MealDaoImpl() {
        this.hashTable = new Hashtable<>();
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );

        for(UserMeal el : mealList) {
            hashTable.put(el.getId(), el);
            maxId.incrementAndGet();
        }
    }

    @Override
    public List<UserMeal> findAll() {
        return this.hashTable.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(UserMeal userMeal) {
        if(!hashTable.isEmpty())
            hashTable.replace(userMeal.getId(), userMeal);
    }

    @Override
    public void create(UserMeal userMeal) {
        UserMeal newEl = new UserMeal(
                maxId.incrementAndGet(),
                userMeal.getDateTime(),
                userMeal.getDescription(),
                userMeal.getCalories());
        hashTable.put(newEl.getId(), newEl);
    }

    @Override
    public void delete(Integer id) {
        hashTable.remove(id);
    }
}