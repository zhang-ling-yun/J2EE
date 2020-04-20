package cn.edu.scut.springboot.service.impl;

import cn.edu.scut.springboot.dao.ProductDao;
import cn.edu.scut.springboot.entity.Product;
import cn.edu.scut.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-22 10:20
 * @description: springboot
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> selectList() {
        return productDao.selectProductList();
    }
}
