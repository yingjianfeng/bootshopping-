package com.yjf.shopping;

import com.yjf.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title: RedisService
 * Description: TODO
 *
 * @author yingjf
 * @date 2020/12/11 16:36
 */
@Component
public class RedisService {
    @Autowired
    RedisUtil redisUtil;

    public void saveGoods(Map<Long, Goods> map){
        if(map!=null){
            Set<Long> keys = map.keySet();
            for(Long key:keys){
                Goods goods = map.get(key);
                redisUtil.set(key+"",goods);
            }
        }
    }
    public Goods getGoodsById(Long id){
        Goods good =(Goods)redisUtil.get(id+"");
        return good;
    }

    public void consumerGoodsById(Long id){
        redisUtil.del(id+"");
    }
}
