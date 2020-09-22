package com.example.exercise.service;

import com.example.exercise.entity.RedisEntity;
import com.example.exercise.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    RedisRepository redisRepository;

    public RedisEntity read(int _id) {
        return redisRepository.read(_id);
    }

    public boolean insert(RedisEntity redisEntity) {
        return redisRepository.insert(redisEntity);
    }

    public boolean update(RedisEntity redisEntity) {
        return redisRepository.update(redisEntity);
    }

    public boolean delete(int _id) {
        return redisRepository.delete(_id);
    }
}
