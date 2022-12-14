package buba.com.cn.utils;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: firstJavaWeb
 * @ClassName TestJdbc
 * @description:
 * @author: MSY
 * @create: 2022-09-20 15:21
 * @Version 1.0
 **/
public class TestJdbc {
    public static void main(String[] args) {
        //创建JDBCTemplate对象 获取连接池
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDateSource());
        //3.调用方法 测试是否连接成功
        String sql = "select count(*) from t_soldier";
        Float count = template.queryForObject(sql, Float.class);
        System.out.println(count);
    }
}
