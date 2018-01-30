package com.imcooc.sell.controller;


import com.imcooc.sell.VO.ProductInfoVO;
import com.imcooc.sell.VO.ProductVO;
import com.imcooc.sell.VO.ResultVO;
import com.imcooc.sell.dataObject.ProductCategory;
import com.imcooc.sell.dataObject.ProductInfo;
import com.imcooc.sell.service.CategoryService;
import com.imcooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController      // @ResponseBody ＋ @Controller
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService   productService;

    @Autowired
    private CategoryService  categoryService;



    @GetMapping(value = "/list")
    public ResultVO list(){
        //查询所有上架的商品
        List<ProductInfo>  productInfoList = productService.findUpAll();

        //查询所有的类目
        List<Integer>  categroyTypeList = new ArrayList<>();
        //lambda方法
        categroyTypeList  =productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(categroyTypeList);
        //数据拼接

        List<ProductVO>  productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategroyname(productCategory.getCategoryName());
            productVO.setCategroytype(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                      ProductInfoVO productInfoVO = new ProductInfoVO();
                      productInfoVO.setProductDescription(productInfo.getProductDescription());
                      productInfoVO.setProductIcon(productInfo.getProductIcon());
                      productInfoVO.setProductId(productInfo.getProductId());
                      productInfoVO.setProductPrice(productInfoVO.getProductPrice());

                      productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }




        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("success");
        resultVO.setCode(0);
        resultVO.setData(productVOList);

//        ResultVO  resultVO = new ResultVO();
//        ProductVO vo  = new  ProductVO();
//        ProductInfoVO productInfo = new ProductInfoVO();
//        vo.setProductInfoVOList(Arrays.asList(productInfo));
//
//
//        resultVO.setData(Arrays.asList(vo));
//        resultVO.setCode(0);
//        resultVO.setMsg("success");
        return  resultVO;
    }
}
