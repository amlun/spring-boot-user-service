package com.cmcm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class UserServiceApplicationTests {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user_1 = userRepository.findOne("1");
        assertTrue(user_1.getNickname().equals("lunweiwei"));
        System.out.println("First: " + user_1.getNickname());

        User user_2 = userRepository.findOne("1");
        assertTrue(user_1.getNickname().equals("lunweiwei"));
        System.out.println("Second: " + user_2.getNickname());

        user_1.setNickname("伦巍巍");
        userRepository.save(user_1);

        User user_3 = userRepository.findOne("1");
        assertTrue(user_3.getNickname().equals("伦巍巍"));
        System.out.println("Third: " + user_3.getNickname());
    }

    @Before
    public void before() {
        userRepository.save(new User("1", "lunweiwei", "http://is.cmcmcdn.com/cmcm_mobile_game/avatar/6680e3af200f28e1625681679728694c"));
    }

}
