package com.yjf.shopping;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Title: GoodsController
 * Description: TODO
 *
 * @author yingjf
 * @date 2020/12/11 15:24
 */
@RestController
@RequestMapping("/web")
@Slf4j
public class GoodsController {
    @Autowired
    RedisService redisService;
    @GetMapping("/show")
    public Map show(){
        Map<Long, Goods> map = new HashMap<>();
        for(int i = 0; i<20; i++){
            String key = UUID.randomUUID().toString().replace("-","");
            Goods good = new Goods();
            good.setId(DateUtil.currentSeconds());
            good.setName(key);
            good.setPrice(DateUtil.currentSeconds());
            good.setDesc(key);
            map.put(DateUtil.currentSeconds(),good);
        }
        redisService.saveGoods(map);
        log.info("save success!");
        return map;
    }

}
