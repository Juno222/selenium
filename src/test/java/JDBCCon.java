import com.mysql.jdbc.PreparedStatement;
import properties.MyProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Juno on 2016/6/11.
 */
public class JDBCCon {

    public Connection getConn(){
        Map<String,String> DBProp = MyProperties.getProp("db.properties");

        String driver = DBProp.get("driver");//驱动包名
        String url = DBProp.get("url");//数据库链接地址
        String username = DBProp.get("username");
        String password = DBProp.get("password");
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
//    public static void main(String[] args) {
//        JDBCCon c = new JDBCCon();
//        c.getConn();
//    }
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
