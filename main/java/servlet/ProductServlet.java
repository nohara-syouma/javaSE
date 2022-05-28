package servlet;

import java.io.IOException;
import java.util.List;

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
        //Integer productId = ParamUtil.checkAndParseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        //String price = request.getParameter("price");
        
        Integer priceint = ParamUtil.checkAndParseInt(request.getParameter("price"));
        
        ProductService ProductService = new ProductService();
        
        
        
        
        Product Product = new Product(null,name,priceint);
    	List<Product> product = ProductService.find(Product);
    	
//    	System.out.println(Product.getProductId());
//    	System.out.println(Product.getProductName());
//    	System.out.println(Product.getPrice());
    	System.out.println(product);
    	if(product.isEmpty()) {
    		request.setAttribute("msg", "対象のデータはありません。");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
    		
    	}else {
    		request.setAttribute("product", product);
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
    	}
      
    
        
//        if (ParamUtil.isNullOrEmpty(name) && ParamUtil.isNullOrEmpty(price)) {
//        	List<Product> product = ProductService.findAll();
//            // 未入力時
//            request.setAttribute("product", product);
//            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
//           
//        }else {
//        	Product Product = new Product(null,name,priceint);
//        	List<Product> product = ProductService.find(Product);
//        	request.setAttribute("product", product);
//            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
//        }
        
        
        
//        if(product != null) {
//        	
//        	request.setAttribute("product", product);
//            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
//        	
//        }else {
//        	request.setAttribute("msg", "対象のデータはありません。");
//            request.getRequestDispatcher("/top.jsp").forward(request, response);
//        }

   

    }
}

