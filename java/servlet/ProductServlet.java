package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Enitity.Product;
import service.ProductService;
import util.ParamUtil;

@WebServlet({ "/login" })
public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        request.setCharacterEncoding("UTF-8");
        Integer productId = ParamUtil.checkAndParseInt(request.getParameter("id"));
        
        if (productId == null) {
            // 未入力時
            request.setAttribute("msg", "product_idを入力してください");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
           
        }
        
        ProductService ProductService = new ProductService();
        Product product = ProductService.find(productId);
        System.out.println(product);
        
        if(product != null) {
        	
        	request.setAttribute("product", product);
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
        	
        }else {
        	request.setAttribute("msg", "対象のデータはありません。");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        }

   

    }
}

