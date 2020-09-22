package com.example.exercise;

import com.example.exercise.entity.RedisEntity;
import com.example.exercise.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping(value = "read")
    public RedisEntity read(int _id) {
        return redisService.read(_id);
    }

    @GetMapping(value = "insert")
    public String insert(@ModelAttribute RedisEntity redisEntity) {
        String result = new Boolean(redisService.insert(redisEntity)).toString();
        return result;
    }

    @GetMapping(value = "update")
    public String update(@ModelAttribute RedisEntity redisEntity) {
        String result = new Boolean(redisService.update(redisEntity)).toString();
        return result;
    }

    @GetMapping(value = "delete")
    public String delete(int _id) {
        String result = new Boolean(redisService.delete(_id)).toString();
        return result;
    }
}
