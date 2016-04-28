package com.didispace.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/4/27 下午10:16.
 * @blog http://blog.didispace.com
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
