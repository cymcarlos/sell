package com.imcooc.sell.service.impl;

import com.imcooc.sell.dataObject.ProductInfo;
import com.imcooc.sell.enums.ProductStatusEnums;
import com.imcooc.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private   ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo  vo =   productService.findOne("123456");
        Assert.assertEquals("123456",vo.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest  request = new PageRequest(0,2);
        Page<ProductInfo>  pageVo = productService.findAll(request);
        System.out.println(pageVo.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo    vo = new ProductInfo();
        vo.setProductId("456");
        vo.setProductName("象拔蚌");
        vo.setProductPrice(new BigDecimal(3.2));
        vo.setProductIcon("xx.jpg");
        vo.setProductStock(100);
        vo.setProductDescription("很好喝的蚌");
        vo.setCategoryType(2);
        vo.setProductStatus(ProductStatusEnums.DOWM.getCode());
        ProductInfo  result = productService.save(vo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList =productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }
}