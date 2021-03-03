package com.didispace.chapter61;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
