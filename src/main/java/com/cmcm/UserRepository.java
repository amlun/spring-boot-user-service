package com.cmcm;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends CrudRepository<User, String> {

    @Cacheable(key = "#p0")
    User findOne(String openid);

    @CachePut(key = "#p0.openid")
    User save(User user);
}