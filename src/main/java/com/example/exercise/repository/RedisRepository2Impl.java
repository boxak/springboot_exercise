package com.example.exercise.repository;

import com.example.exercise.entity.RedisEntity;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository2Impl implements  RedisRepository2 {
    private RedisTemplate<String, RedisEntity> redisTemplate;
    private HashOperations hashOperations;

    public RedisRepository2Impl(RedisTemplate<String, RedisEntity> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(RedisEntity redisEntity) {
        hashOperations.put("human",redisEntity.get_id(),redisEntity);
    }

    @Override
    public RedisEntity findById(int _id) {
        return (RedisEntity) hashOperations.get("human",_id);
    }

    @Override
    public void update(RedisEntity redisEntity) {
        save(redisEntity);
    }

    @Override
    public void delete(int _id) {
        hashOperations.delete("human",_id);
    }
}
