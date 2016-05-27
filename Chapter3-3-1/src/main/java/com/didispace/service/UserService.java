package com.didispace.service;

import com.didispace.domain.User;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2016/5/27.
 */
public interface UserService {

    @Transactional
    User login(String name, String password);

}
