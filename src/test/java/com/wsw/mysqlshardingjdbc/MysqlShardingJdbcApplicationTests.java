package com.wsw.mysqlshardingjdbc;

import com.wsw.mysqlshardingjdbc.entity.testUser;
import com.wsw.mysqlshardingjdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MysqlShardingJdbcApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void add() {
        for (int i = 1; i <= 5; i++) {
            testUser user = new testUser();
            user.setId(i);
            user.setName("sharding-" + (i));
            user.setAge(i);
            userService.addUser(user);
        }
    }

    @Test
    public void getUser() {
        System.out.println(userService.getUser(3));
    }

    @Test
    public void getAllUser() {
        System.out.println(userService.getUsers());
    }

}
