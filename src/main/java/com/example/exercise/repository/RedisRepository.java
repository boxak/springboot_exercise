package com.example.exercise.repository;

import com.example.exercise.entity.RedisEntity;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
    @Autowired
    SqlSession sqlSession;

    @Autowired
    RedisRepository2Impl redisRepository2;

    Logger LOG = LoggerFactory.getLogger(RedisRepository.class);

    public boolean insert(RedisEntity redisEntity) {
        boolean result = false;
        try {
            int cnt = sqlSession.insert("insertOne",redisEntity);
            if(cnt == 1) result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(RedisEntity redisEntity) {
        boolean result = false;
        try {
            int cnt = sqlSession.update("updateOne",redisEntity);
            if(cnt == 1) result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int _id) {
        boolean result = false;
        try {
            int cnt = sqlSession.delete("deleteOne",_id);
            if(cnt == 1) result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public RedisEntity read(int _id) {
        RedisEntity redisEntity = null;
        try {
            redisEntity = redisRepository2.findById(_id);
            LOG.info("Redis : "+(redisEntity==null ? "Null" : redisEntity.toString()));
            if(redisEntity == null) {
                redisEntity = sqlSession.selectOne("selectOne", _id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return redisEntity;
    }
}
