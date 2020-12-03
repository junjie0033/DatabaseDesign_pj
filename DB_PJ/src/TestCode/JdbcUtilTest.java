package TestCode;

import TestCode.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtilTest {
    public static void main(String[] args) {
        JdbcUtil util = new JdbcUtil();
        Connection conn = util.getConnection();
        String sql = "show databases";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            // 输出数据库中所有database的名字
            while (rs.next()) {
                System.out.println(rs.getString("Database"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
    }
}
