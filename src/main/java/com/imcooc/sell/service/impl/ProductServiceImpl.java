package com.imcooc.sell.service.impl;

import com.imcooc.sell.dataObject.ProductInfo;
import com.imcooc.sell.enums.ProductStatusEnums;
import com.imcooc.sell.repository.ProductInfoRepository;
import com.imcooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductInfoRepository   repository;

    @Override
    public ProductInfo findOne(String productId) {
        return  repository.findOne(productId);
    }



    @Override
    public Page<ProductInfo> findAll(Pageable pagebale) {
        return   repository.findAll(pagebale);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }
}
