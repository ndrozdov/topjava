package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;


/**
 * Created by admin_DKRS on 05.04.16.
 */

@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaUserMealRepositoryTest extends UserMealServiceTest{
}