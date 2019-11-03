package com.service;

import com.domain.User;

import java.util.List;

/**
 * 用户的业务层接口
 *
 * @Author JinLu
 * @Date2019/11/2 20:05
 **/
public interface IUserService {
    /**
     * 查询用户列表
     * @return
     **/
    List<User> findAll();

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);
}
