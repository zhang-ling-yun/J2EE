import entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author: rain
 * @date: 2019-3-24 22:10
 * @description:
 */
public class ProductTest {
    @Test
    public void testGetSession() {
        Session session = HibernateUtil.getSession();

        Assert.assertNotNull(session);

        HibernateUtil.closeSession();
    }

    @Test
    public void testSave() {
        Product product = new Product();
        product.setName("轻量级Java EE企业应用实战");
        product.setPrice(65.32);
        product.setCreateTime(new Date());

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void testQuery() {
        Session session = HibernateUtil.getSession();

        Product p =(Product) session.get(Product.class, 4);

        System.out.println("id=4的产品名称是: " + p.getName());
        HibernateUtil.closeSession();
    }

    @Test
    public void testUpdate() {
        // 这里要注意的是，没有赋值的字段Hibernate会默认给空值
        Product product = new Product();
        product.setId(4);
        product.setName("Effective Java 第二版");

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        session.update(product);

        tx.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void testDelete() {
        Product product = new Product();
        product.setId(5);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        session.delete(product);

        tx.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void testState() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Product p = new Product();
        p.setName("p3");
        p.setPrice(88.88);
        p.setCreateTime(new Date());
        System.out.println("此时p是瞬时状态");
        session.save(p);
        System.out.println("此时p是持久状态");
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        System.out.println("此时p是脱管状态");
    }

    @Test
    public void testHql() {
        Session session = HibernateUtil.getSession();
        String hql = "FROM Product P WHERE P.name like :name";
        Query query = session.createQuery(hql);
        query.setParameter("name","%Java%");
        List<Product> results = query.list();
        for (Product p : results) {
            System.out.println(p.getName());
        }
        HibernateUtil.closeSession();
    }

    @Test
    public void testCriteria() {
        Session session = HibernateUtil.getSession();

        // 以下方用法已过时
        /*Criteria c= session.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%Java%"));
        List<Product> ps = c.list();
        for (Product p : ps) {
            System.out.println(p.getName());
        }*/
        CriteriaBuilder crb = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = crb.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        criteriaQuery.where(crb.like(root.get("name"),"%Java%"));
        List<Product> resultList= session.createQuery(criteriaQuery).getResultList();
        for (Product p : resultList) {
            System.out.println(p.getName());
        }
    }

    @Test
    public void testSql() {
        Session session = HibernateUtil.getSession();
        // 注意这边直接用like %Java% 会报错，无法识别为字符串
        String sql = "select * from product p where p.name like '%Java%'";

        Query q= session.createSQLQuery(sql);
        List<Object[]> list = q.list();
        for (Object[] os : list) {
            for (Object filed: os) {
                System.out.print(filed+"\t");
            }
            System.out.println();
        }
        HibernateUtil.closeSession();
    }

    @Test
    public void testTransaction() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 删除第一个产品
        Product p = (Product) session.get(Product.class, 1);
        session.delete(p);

        // 此处超出长度会抛异常，事务自动回滚，产品一不会被删除
        Product p2 = (Product) session.get(Product.class, 2);
        p2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
        session.update(p2);

        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void testOneCache() {
        Session session = HibernateUtil.getSession();
        System.out.println("log1");
        Product c1 = (Product) session.get(Product.class, 1);
        System.out.println("log2");
        Product c2= (Product) session.get(Product.class, 1);
        System.out.println("log3");
        HibernateUtil.closeSession();
    }

    @Test
    public void testPage() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 这种方式已经过期了
        /*String name = "Java";
        Criteria c= session.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%"+name+"%"));
        c.setFirstResult(2);
        c.setMaxResults(3);*/

        //1.定义查询最大记录数的Query对象
        Query queryPage = session.createQuery("FROM Product");
        //2.查询最大记录数的数据
        queryPage.setMaxResults(3);
        //3.确定查询起点
        queryPage.setFirstResult(2);

        List<Product> ps = queryPage.list();
        for (Product p : ps) {
            System.out.println(p.getName());
        }
        HibernateUtil.closeSession();
    }

    @Test
    public void testLoadAndGetOne() {
        Session session = HibernateUtil.getSession();
        System.out.println("log1");
        Product p = (Product) session.get(Product.class, 1);
        System.out.println("log2");
        Product p2 = (Product) session.load(Product.class, 2);
        System.out.println("log3");
        System.out.println(p2.getName());
        System.out.println("log4");

        Product p3 = (Product) session.get(Product.class, 500);
        System.out.println("p3 = "+ p3);

        Product p4 = (Product) session.load(Product.class, 500);
        System.out.println("p4 = "+ p4);
        HibernateUtil.closeSession();
    }

    @Test
    public void testNPlusOne() {
        Session session = HibernateUtil.getSession();
        String name = "Java";
        Query q = session.createQuery("from Product p where p.name like :name");
        q.setParameter("name", "%" + name + "%");
        Iterator<Product> it = q.iterate();
        while(it.hasNext()){
            Product p = it.next();
            System.out.println(p.getName());
        }
        // 注意与下面用list方法的区别，会直接把所有数据获取出来
        /*List<Product> it = q.list();
        for (Product p : it) {
            System.out.println(p.getName());
        }*/
        HibernateUtil.closeSession();
    }
}
