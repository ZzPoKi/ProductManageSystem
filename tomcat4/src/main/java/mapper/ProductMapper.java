package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> selectAll();//查询所有
    void addProduct(@Param("id") Integer id, @Param("name") String name, @Param("price") Integer price, @Param("sales") Integer sales);//新增商品
    void deleteProduct(@Param("id") Integer id);
    //修改
    void updateProduct(@Param("id") Integer id, @Param("name") String name, @Param("price") Integer price, @Param("sales") Integer sales);
}
