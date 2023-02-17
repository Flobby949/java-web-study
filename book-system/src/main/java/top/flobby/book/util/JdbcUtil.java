package top.flobby.book.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-17 16:04
 **/

public class JdbcUtil {
    private static DataSource ds;

    private static JdbcUtil jdbcUtil = null;

    static {
        // 加载配置文件
        System.out.println("执行静态代码块");
        Properties properties = new Properties();
        InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);
            // 初始化连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }


    private JdbcUtil() {
        System.out.println("执行构造方法");
    }
}
