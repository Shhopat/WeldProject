package com.svar_proekt.weldproject;

import com.svar_proekt.weldproject.config.RedissonFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;


public class Test {
    private final RedissonClient redissonClient;

    public Test() {
        this.redissonClient = RedissonFactory.redissonClient();
    }

    public RRateLimiter getUserRateLimiter(int userId) {
        RRateLimiter rRateLimiter = redissonClient.getRateLimiter("read:key:2:userId:" + userId);
        //вызываем данный метод, чтобы создать служебный ключ для каждого клиента
        rRateLimiter.trySetRate(RateType.OVERALL, 3, 1, RateIntervalUnit.SECONDS);

        rRateLimiter.expire(1, TimeUnit.HOURS);
        //устанавливаем время жизни
        return rRateLimiter;
    }

    public static void main(String[] args) {
        Test test = new Test();


        RRateLimiter rRateLimiter = test.getUserRateLimiter(12);

        if (rRateLimiter.tryAcquire()){

        }else {

        }


    }
}
