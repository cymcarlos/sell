package com.imcooc.sell.VO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 */
@Data
public class ProductVO {


    @JsonProperty("name")
    private String   categroyname ;


    @JsonProperty("type")
    private  Integer  categroytype;

    @JsonProperty("food")
    private List<ProductInfoVO>  productInfoVOList;
}
