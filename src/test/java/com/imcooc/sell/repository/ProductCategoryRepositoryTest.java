package com.imcooc.sell.repository;

import com.imcooc.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private  ProductCategoryRepository productCategoryRepository;

    @Test
    public  void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory);
    }


    @Test
    @Transactional  //完成后会回滚的事务
    public   void saveTest(){
        ProductCategory  productCategory = new ProductCategory("女生最爱",2);

        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }

    @Test
    public  void   updateTest(){
        ProductCategory productCategory =  productCategoryRepository.findOne(2);
//        productCategory.setCategoryId(2);
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(2);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public  void  findByCategoryTypeIn(){

        List<Integer>  list =  new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<ProductCategory>  result =  productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}