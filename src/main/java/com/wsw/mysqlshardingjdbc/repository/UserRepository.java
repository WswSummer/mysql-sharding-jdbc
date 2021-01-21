package com.wsw.mysqlshardingjdbc.repository;

import com.wsw.mysqlshardingjdbc.entity.testUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author WangSongWen
 * @Date: Created in 14:55 2021/1/21
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<testUser, Integer> {

    testUser findUserById(Integer id);

    int deleteUserById(Integer id);
}
