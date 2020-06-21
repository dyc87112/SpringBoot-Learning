package com.didispace.chapter38.s;

import com.didispace.chapter38.p.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 程序猿DD/翟永超 on 2020/2/15.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public interface UserRepository extends JpaRepository<com.didispace.chapter38.s.User, Long> {

    com.didispace.chapter38.s.User findByName(String name);

    com.didispace.chapter38.s.User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    com.didispace.chapter38.s.User findUser(@Param("name") String name);

}
