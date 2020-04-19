package com.wpw.springbootjpa.service.impl;

import com.wpw.springbootjpa.entity.User;
import com.wpw.springbootjpa.repository.UserRepository;
import com.wpw.springbootjpa.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wpw
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Integer save(User user) {
        User u = userRepository.save(user);
        return u == null ? null : u.getId();
    }

    @Override
    public User get(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public void update(String lastName, Integer id) {
        userRepository.update(lastName, id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listPagination(User user) {
        return listPaginationByDynamic(user);
    }

    public List<User> listPaginationByDynamic(User user) {
        Specification specification = (Specification) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(user.getId())) {
                predicates.add(criteriaBuilder
                        .equal(root.get("id"), user.getId()));
            }
            if (!StringUtils.isEmpty(user.getLastName())) {
                predicates.add(criteriaBuilder
                        .like(root.get("lastName"), "%" + user.getLastName() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Integer pageNumber = user.getPageNumber();
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        Integer pageSize = user.getPageSize();
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return userRepository.findAll(specification, pageRequest).getContent();
    }

}
