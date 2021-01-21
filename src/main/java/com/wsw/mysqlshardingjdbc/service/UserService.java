package com.wsw.mysqlshardingjdbc.service;

import com.wsw.mysqlshardingjdbc.entity.testUser;
import com.wsw.mysqlshardingjdbc.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 14:52 2021/1/21
 * @Description:
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Integer addUser(testUser user) {
        String sql = "insert into test_user(id, name, age) values(?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge());
    }

    public List<testUser> getUsers() {
        return userRepository.findAll();
    }

    public testUser getUser(Integer id) {
        return userRepository.findUserById(id);
    }

    public boolean deleteOne(Integer id) {
        int i = userRepository.deleteUserById(id);
        return i > 0;
    }
}
