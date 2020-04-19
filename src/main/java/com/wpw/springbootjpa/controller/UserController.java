package com.wpw.springbootjpa.controller;

import com.wpw.springbootjpa.service.UserService;
import com.wpw.springbootjpa.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wpw
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public Integer save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/get")
    public User get(@RequestParam(value = "id") Integer id) {
        return userService.get(id);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody User user) {
        String lastName = user.getLastName();
        Integer id = user.getId();
        //根据id进行查询
        User u = userService.get(id);
        if (u == null) {
            return;
        }
        userService.update(lastName, id);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(value = "id") Integer id) {
        userService.delete(id);
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        return userService.listAll();
    }

    @GetMapping(value = "/list-pagination")
    public List<User> listPagination(@RequestBody User user) {
        return userService.listPagination(user);
    }
}
