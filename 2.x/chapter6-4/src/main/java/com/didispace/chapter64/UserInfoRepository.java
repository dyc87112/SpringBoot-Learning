package com.didispace.chapter64;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 程序猿DD/翟永超 on 2021/10/08.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByName(String name);

    UserInfo findByNameAndAge(String name, Integer age);

    @Query("from UserInfo u where u.name=:name")
    UserInfo findUser(@Param("name") String name);

}
