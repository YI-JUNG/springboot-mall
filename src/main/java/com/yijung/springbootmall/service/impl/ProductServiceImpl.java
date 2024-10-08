package com.yijung.springbootmall.service.impl;

import com.yijung.springbootmall.dao.ProductDao;
import com.yijung.springbootmall.model.Product;
import com.yijung.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
