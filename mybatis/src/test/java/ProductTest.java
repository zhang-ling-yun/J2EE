import cn.edu.scut.mybatis.dao.ProductDao;
import cn.edu.scut.mybatis.dao.ProductMapper;
import cn.edu.scut.mybatis.entity.Product;
import cn.edu.scut.mybatis.util.SessionFactoryUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: rain
 * @date: 2019-4-1 09:11
 * @description:
 */
public class ProductTest {
    Logger logger = Logger.getLogger(ProductTest.class);

    @Test
    public void listProduct() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            // 原先网站使用的方式,不建议使用
            // List<Product> products = session.selectList("listProduct");
            // logger.debug(products);
            ProductDao mapper = session.getMapper(ProductDao.class);
            List<Product> products = mapper.listProduct();
            logger.debug(products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void addProduct() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            Product product = new Product();
            product.setName("深入浅出MyBatis技术原理与实战");
            product.setPrice(69.45);
            int result = mapper.addProduct(product);
            if (result == 1) {
                logger.debug("addProduct result：" + result);
                // 默认不自动提交,这边要手动提交,不然数据库中数据会不存在
                session.commit();
            } else {
                logger.debug("addProduct result：" + result);
                session.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void getProduct() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("getProduct result：" + mapper.getProduct(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void updateProduct() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            Product product = new Product();
            product.setId(3);
            product.setName("Java核心技术卷II");
            int result = mapper.updateProduct(product);
            if (result == 1) {
                logger.debug("updateProduct result：" + result);
                session.commit();
            } else {
                logger.debug("updateProduct result：" + result);
                session.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void deleteProduct() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            int result = mapper.deleteProduct(7);
            if (result == 1) {
                logger.debug("deleteProduct result：" + result);
                session.commit();
            } else {
                logger.debug("deleteProduct result：" + result);
                session.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void listProductByName() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("listProductByName result：" + mapper.listProductByName(null));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void listProductByNameAndPrice() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("listProductByNameAndPrice result：" + mapper.listProductByNameAndPrice("java",36.0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testChoose() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("testChoose result：" + mapper.testChoose("java",36.0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testForeach() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            List<Integer> ids = new ArrayList();
            ids.add(1);
            ids.add(3);
            ids.add(5);
            logger.debug("testForeach result：" + mapper.testForeach(ids));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testBind() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("testBind result：" + mapper.testBind("java"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testAnnotation() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            Product product = new Product();
            product.setName("java核心技术卷II");
            product.setPrice(92.36);
            int result = mapper.add(product);
            logger.debug("add result：" + result);
            session.commit();

            logger.debug(mapper.list());

            product.setId(3);
            product.setName("java核心技术卷I");
            result = mapper.update(product);
            logger.debug("update result：" + result);
            session.commit();

            logger.debug(mapper.list());

            result = mapper.delete(3);
            logger.debug("delete result：" + result);
            session.rollback();

            logger.debug(mapper.list());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testPageHelper() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            PageHelper.offsetPage(0, 2);
            logger.debug("testPageHelper result：" + mapper.testBind("java"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testOneLevel() {
        SqlSession session = SessionFactoryUtil.getSession();
        try {
            ProductDao mapper = session.getMapper(ProductDao.class);
            logger.debug("session0 result：" + mapper.getProduct(1));
            logger.debug("session0 result：" + mapper.getProduct(1));

            SqlSession session1 = SessionFactoryUtil.getSession();
            ProductDao mapper1 = session1.getMapper(ProductDao.class);
            logger.debug("session1 result：" + mapper1.getProduct(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
