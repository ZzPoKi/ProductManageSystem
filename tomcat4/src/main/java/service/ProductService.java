package service;

import pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();
    void addProduct(Integer id, String name, Integer price, Integer sales);
    void deleteProduct(Integer id);
    void updateProduct(Integer id, String name, Integer price, Integer sales);
}
