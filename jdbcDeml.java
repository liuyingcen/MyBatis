package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcDeml {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_park", "root", "root");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select *from car_user");
        //4.执行sql
        ResultSet rs = pstm.executeQuery();
        //5.封装结果集
        while (rs.next()) {
            System.out.println(rs.getString("User_id"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();

    }
}
