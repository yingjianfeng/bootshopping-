package com.yjf.shopping;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Title: Goods
 * Description: TODO
 *
 * @author yingjf
 * @date 2020/12/11 16:05
 */
@Data
@Getter
@Setter
public class Goods implements Serializable {
    Long id;
    String name;
    Long price;
    String desc;
}
