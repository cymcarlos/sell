package com.imcooc.sell.service;

import com.imcooc.sell.dataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface ProductService {

     ProductInfo findOne(String  productId);
     List<ProductInfo>  findUpAll();

     Page<ProductInfo> findAll(Pageable pagebale);
     ProductInfo  save(ProductInfo productInfo) ;

     //加库存减库存

}
