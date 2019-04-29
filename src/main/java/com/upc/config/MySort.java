package com.upc.config;

import com.upc.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author: Pan
 * @Date: 2019/4/29 17:11
 * @Description:
 **/

@Cacheable
@Component
public class MySort {

    private static final  String  ZSET = "zset";

    @Autowired
    private RedisService redisService;
    /**
     * 根据key 进行缓存操作
     * @param key
     */
    public void sort(String key){
        Long rank2 = redisService.rank(ZSET, key);
        // 如果rank2为null,则缓存里面不存在该值
        if( rank2 == null ){
             // 不存在,则添加,默认排序为1
             redisService.zAdd(ZSET,key,1.0);
            System.out.println("当前:"+key +":的搜索次数为"+1);
        }else {
            // 如果存在,则获取排序值  并且+1
            int score = (int)redisService.score(ZSET, key);
            System.out.println("当前:"+key +":的搜索次数为"+(score+1));
            redisService.zAdd(ZSET,key,score+1);
         }

    }
         /**
      * 从高到低的排序集中获取从头(start)到尾(end)内的元素。
      * @param start 0 表示第一个
      * @param end  -1 表示最后
      * @return
      */
         public Set<Object> findZset(long start, long end){
             return redisService.reverseRange(ZSET, start, end);
         }

}
