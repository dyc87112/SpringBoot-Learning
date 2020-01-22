package com.didispace.service;

import com.didispace.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2016/5/27.
 */
public interface UserService {

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    User login(String name, String password);

}
