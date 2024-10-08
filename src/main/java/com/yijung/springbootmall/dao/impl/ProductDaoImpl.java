package com.yijung.springbootmall.dao.impl;

import com.yijung.springbootmall.dao.ProductDao;
import com.yijung.springbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.yijung.springbootmall.rowmapper.ProductRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "select product_id, product_name, category, image_url," +
                " price, stock, description, created_date," +
                " last_modified_date from product where product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId",productId);
        List<Product> productList = nameParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList != null && productList.size() > 0) {
            return productList.get(0);
        }else{
            return null;
        }

    }
}
