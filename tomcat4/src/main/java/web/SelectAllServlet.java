package web;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/selectall")
public class SelectAllServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();//采用多态写法，解除service层与servlet之间的耦合
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从service层返回集合数据到web层
        List<Product> products = productService.selectAll();
        //将集合转为json字符串
        String jsonString = JSON.toJSONString(products);
        //将json数据写入前端界面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
