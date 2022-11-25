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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();//采用多态写法，解除service层与servlet之间的耦合
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        Object getId = JSON.parse(params);
        response.getWriter().write("删除成功");
        System.out.println(getId);
        System.out.println(params);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
