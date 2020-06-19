package com.didispace.chapter36.mapper;

import com.didispace.chapter36.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 程序猿DD/翟永超 on 2020/2/28.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public interface UserMapper {

    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);

}
