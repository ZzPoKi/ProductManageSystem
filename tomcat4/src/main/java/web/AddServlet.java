package web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();//采用多态写法，解除service层与servlet之间的耦合

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        //将json数据转换为对象
        Product product = JSON.parseObject(params, Product.class);
        if (product.getName() != "" && product.getPrice() != null && product.getSales() != null) {
            response.getWriter().write("success");
            productService.addProduct(product.getId(), product.getName(), product.getPrice(), product.getSales());
        } else {
            response.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
