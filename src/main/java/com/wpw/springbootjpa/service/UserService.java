package com.wpw.springbootjpa.service;

import com.wpw.springbootjpa.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 主键id
     */
    Integer save(User user);

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User get(Integer id);


    /**
     * 根据用户id进行用户名称的更新
     *
     * @param lastName 用户名称
     * @param id       用户id
     */
    void update(String lastName, Integer id);

    /**
     * 根据用户id删除用户信息
     *
     * @param id 用户id
     */
    void delete(Integer id);

    /**
     * 查询用户列表信息，在现在的用户操作上，这个方法用的很少吧，谁会让你全表查询呢，一般都是基于分页查询的
     *
     * @return 用户列表信息
     */
    List<User> listAll();

    /**
     * 返回指定条件的用户列表信息，带分页信息，可以当做listAll()方法的一个动态补充了，这也是自己去写orm框架必须要写的一个方法了
     * 因为分页太普遍了，如果基本操作会了，分页也是要写的，毕竟常用的方法自己写下，到时候遇到这样的问题可以看下
     *
     * @param user 用户信息
     * @return 用户列表信息
     */
    List<User> listPagination(User user);
}
