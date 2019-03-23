import org.junit.Test;
import util.DBUtil;

import java.sql.*;

/**
 * @Auther: Administrator
 * @Date: 2019-3-16 23:08
 * @Description:
 */
public class ProductTest {
    @Test
    public void insertProduct() {
        Connection conn = DBUtil.getConn();
        int i = 0;
        String sql = "insert into product (name,price) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, "Java核心技术卷II");
            pstmt.setString(2, "99.85");
            i = pstmt.executeUpdate();
            if (i == 1) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductPrice() {
        //SQL语句  
        String sql = "select price from product where name = 'Java核心技术卷II'";
        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        Double price = null;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集  
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                //这里只查询的密码
                price = ret.getDouble(1);
                System.out.println(price);
            }
            ret.close();
            conn.close();//关闭连接  
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void updateProduct() {
        Connection conn = DBUtil.getConn();
        int i = 0;
        String sql = "update product set price=99.89 where name='Java核心技术卷II'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            if (i == 1) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteProduct() {
        Connection conn = DBUtil.getConn();
        int i = 0;
        String sql = "delete from product where name='Java核心技术卷II'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            if (i == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
