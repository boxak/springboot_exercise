package com.example.exercise.repository;

import com.example.exercise.entity.RedisEntity;

public interface RedisRepository2 {
    void save(RedisEntity redisEntity);
    RedisEntity findById(int _id);
    void update(RedisEntity redisEntity);
    void delete(int _id);
}
