package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//创建获取工厂对象的工具类
public class sqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //静态代码块会随着类的加载而自动执行，且只执行一次
        try {
            //加载mybatis核心配置文件，获取sqlSessionFactory对象
            //创建工厂对象
            String resource = "Mybatis-config.xml";//传入对应配置文件源
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
