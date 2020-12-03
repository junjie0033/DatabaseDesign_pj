package jdbcUtil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc操作工具类
 * 用于初始化数据库连接池、获取数据库连接、释放数据库连接
 * @author wangj
 */
public class jdbcUtil {
    private static DataSource dataSource;

    static {
        dataSource = new  ComboPooledDataSource("testApp");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void releaseConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
