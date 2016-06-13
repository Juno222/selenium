import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Juno on 2016/6/11.
 */
public class JDBCCon {
    public Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";//驱动包名
        String url = "jdbc:mysql://192.168.3.212:3306/item";//数据库链接地址
        String username = "tester";
        String password = "tester#21";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Integer selectCount(String sql){
        Integer count = null;
        Connection conn = getConn();
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count  = Integer.parseInt(rs.getString(1));
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
