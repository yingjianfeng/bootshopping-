package com.yjf;

import cn.hutool.core.date.DateUtil;
import com.yjf.shopping.Goods;
import com.yjf.shopping.RedisService;
import com.yjf.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Title: RedisTest
 * Description: TODO
 *
 * @author yingjf
 * @date 2020/12/11 16:47
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    RedisService redisService;
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void save(){
        Map<Long, Goods> map = new HashMap<>();
        for(int i = 0; i<20; i++){
            String name = UUID.randomUUID().toString().replace("-","");
            Long key = (long)i;
            Goods good = new Goods();
            good.setId(key);
            good.setName(name);
            good.setPrice(DateUtil.currentSeconds());
            good.setDesc(name);
            map.put(key,good);
        }
        redisService.saveGoods(map);
        log.info("save success!");
    }
    @Test
    public void getGoodsById(){
        Goods goods = redisService.getGoodsById(1607680589L);
        System.out.println(goods);
        log.info("query success!");
    }
    @Test
    public void consumerGoodsById(){
        redisService.consumerGoodsById(1L);
        log.info("consumerGoodsById success!");
    }


}
