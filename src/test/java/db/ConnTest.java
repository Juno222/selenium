package db;

import db.JDBCCon;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * Created by Juno on 2016/6/11.
 */
public class ConnTest {
    @Test
    public void connTest(){
        JDBCCon jdbccon = new JDBCCon();
        Connection conn = jdbccon.getConn();
        Assert.assertNotNull(conn);
    }
}
