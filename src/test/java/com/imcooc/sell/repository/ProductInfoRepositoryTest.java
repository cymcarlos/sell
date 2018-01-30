package com.imcooc.sell.repository;

import com.imcooc.sell.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {


    @Autowired
    private   ProductInfoRepository   repository;


    @Test
    public  void  saveTest(){
        ProductInfo    vo = new ProductInfo();
        vo.setProductId("123456");
        vo.setProductName("皮蛋瘦肉粥");
        vo.setProductPrice(new BigDecimal(3.2));
        vo.setProductIcon("xx.jpg");
        vo.setProductStock(100);
        vo.setProductDescription("很好喝的粥");
        vo.setCategoryType(2);
        vo.setProductStatus(0);
        ProductInfo  result = repository.save(vo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
       List<ProductInfo> list   =  repository.findByProductStatus(0);
       Assert.assertNotEquals(0,list.size());

    }
}