package com.test;

import com.domain.User;
import com.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户的代理层测试
 *
 * @Author JinLu
 * @Date2019/11/2 20:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll() {
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindId() {
        User byId = userService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void testUpdate() {
        User user = userService.findById(1);
        System.out.println("before:" + user);

        user.setAge(55);
        userService.updateUser(user);

        user = userService.findById(1);
        System.out.println("after:" + user);

    }
}
