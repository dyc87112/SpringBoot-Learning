package com.didispace.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/23 下午2:34.
 * @blog http://blog.didispace.com
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(key = "#p0")
    User findByName(String name);

    @CachePut(key = "#p0.name")
    User save(User user);

}
