package com.github.zhiduoming;

import com.github.zhiduoming.pojo1.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "2006051Chenyibo?";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.获取sql语句的执行对象
        Statement statement = connection.createStatement();

        //4.执行sql
        int i = statement.executeUpdate("update user set age=25 where id=1");
        System.out.println("该sql执行完毕影响的记录数是：" + i);
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testUserQuery() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            // 1. 注册驱动 (MySQL 8.0+ 可省略，但建议保留)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 获取连接 (记得换成你的数据库名和密码)
            String url = "jdbc:mysql://localhost:3306/web01";
            conn = DriverManager.getConnection(url, "root", "2006051Chenyibo?");

            // 3. 定义 SQL (使用 ? 作为占位符，防止 SQL 注入，这是北邮学生该有的职业素养！)
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";

            // 4. 获取执行 SQL 的对象
            pstmt = conn.prepareStatement(sql);

            // 5. 设置参数
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");

            // 6. 执行查询，获取结果集
            rs = pstmt.executeQuery();

            // 7. 遍历结果集，封装 User 对象
            while (rs.next()) {
                // 从结果集中按列名取值
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");

                // 创建 User 对象 (得益于你的 @AllArgsConstructor)
                User user = new User(id, username, pass, name, age);
                userList.add(user);
            }

            // 8. 输出结果
            userList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9. 释放资源 (一定要倒序关！)
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}
