package com.wpw.springbootjpa.repository;

import com.wpw.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wpw
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor {
    @Query(value = "update user set last_name=?1 where id=?2", nativeQuery = true)
    @Modifying
    @Transactional
    int update(String lastName, Integer id);
}
