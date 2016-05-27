package com.didispace.service;

import com.didispace.domain.User;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2016/5/27.
 */
public interface UserService {

    @Transactional
    User login(String name, String password);

}
