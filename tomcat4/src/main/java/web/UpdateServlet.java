package web;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();//采用多态写法，解除service层与servlet之间的耦合
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取json字符串
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        Product product = JSON.parseObject(params, Product.class);
        if (product.getName() != "" && product.getPrice() != null && product.getSales() != null) {
            response.getWriter().write("success");
            productService.updateProduct(product.getId(), product.getName(), product.getPrice(), product.getSales());
        } else {
            response.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
