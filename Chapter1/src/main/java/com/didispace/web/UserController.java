package com.didispace.web;

import com.didispace.domain.User;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递


        return null;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public User postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数


        return null;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中


        return null;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public User putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息


        return null;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User


        return null;
    }

}