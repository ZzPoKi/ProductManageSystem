package service;

import mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Product;
import utils.sqlSessionFactoryUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    //获取工厂对象
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Product> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectAll();
        sqlSession.close();
        return products;
    }

    @Override
    public void addProduct(Integer id, String name, Integer price, Integer sales) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.addProduct(id, name, price, sales);
        sqlSession.close();
    }

    @Override
    public void deleteProduct(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.deleteProduct(id);
        sqlSession.close();
    }

    @Override
    public void updateProduct(Integer id, String name, Integer price, Integer sales) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.updateProduct(id, name, price, sales);
        sqlSession.close();
    }
}
