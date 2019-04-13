package cn.edu.scut.spring.proxy;

import cn.edu.scut.spring.entity.Product;
import cn.edu.scut.spring.service.ProductService;
import cn.edu.scut.spring.transaction.LogTransaction;

/**
 * @author: rain
 * @date: 2019-4-7 17:02
 * @description: 商品代理类
 */
public class ProxyProduct implements ProductService {
    /**
     * 真实类
     */
    private ProductService productService;
    /**
     * 事务类
     */
    private LogTransaction logTransaction;

    /**
     * 使用构造函数实例化
     */
    public ProxyProduct(ProductService productService,LogTransaction transaction){
        this.productService = productService;
        this.logTransaction = transaction;
    }

    @Override
    public int addProduct(Product product) {
        logTransaction.before();
        int result = productService.addProduct(product);
        logTransaction.after();
        return result;
    }

    @Override
    public int deleteProduct(Integer id) {
        logTransaction.before();
        int result = productService.deleteProduct(id);
        logTransaction.after();
        return result;
    }
}
