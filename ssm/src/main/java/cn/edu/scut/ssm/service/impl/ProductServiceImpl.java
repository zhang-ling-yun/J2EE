package cn.edu.scut.ssm.service.impl;

import cn.edu.scut.ssm.dao.ProductDao;
import cn.edu.scut.ssm.entity.Product;
import cn.edu.scut.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: rain
 * @date: 2019-4-19 10:52
 * @description: ssm
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public PageInfo<Product> selectProductList(Map<String, Object> params, int pageNo, int pageSize) {
        pageNo = pageNo <= 0 ? 1 : pageNo;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productDao.selectProductList(params);
        PageInfo<Product> page = new PageInfo<>(list);
        return page;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int addProduct(Product product) {
        if (product == null || product.getCategory() == null || product.getCategory().getId() == null) {
            return 0;
        }
        int result = productDao.addProduct(product);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int updateProduct(Product product) {
        if (product == null || product.getCategory() == null || product.getCategory().getId() == null) {
            return 0;
        }
        int result = productDao.updateProduct(product);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int deleteProduct(Integer id) {
        int result = productDao.deleteProduct(id);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }
}
