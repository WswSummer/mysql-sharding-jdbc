package com.wsw.mysqlshardingjdbc.controller;

import com.wsw.mysqlshardingjdbc.entity.testUser;
import com.wsw.mysqlshardingjdbc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author WangSongWen
 * @Date: Created in 14:51 2021/1/21
 * @Description:
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getUsers")
    public Object getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUser")
    public Object getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/addUsers")
    public Object add() {
        for (int i = 1; i <= 5; i++) {
            testUser user = new testUser();
            user.setId(i);
            user.setName("sharding-" + (i));
            user.setAge(i);
            long resutl = userService.addUser(user);
            log.info("insert:" + user.toString() + " result:" + resutl);
        }
        return "添加成功";
    }

    @GetMapping("/deleteOne")
    public Object deleteOne(@RequestParam Integer id) {
        boolean result = userService.deleteOne(id);
        if (result)
            return "删除成功!";
        else
            return "删除失败!";
    }
}
