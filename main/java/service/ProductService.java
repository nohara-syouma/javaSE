package service;

import java.sql.Connection;
import java.util.List;

import Enitity.Product;
import dao.ProductDao;
import util.DbUtil;

public class ProductService {
	
	List<Product> reslt =null;

	public List<Product> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao ProductDao = new ProductDao(conn);
        	reslt = ProductDao.findAll();
            return reslt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
	public List<Product> find(Product pd){
		try (Connection conn = DbUtil.getConnection()) {
        	ProductDao ProductDao = new ProductDao(conn);
        	reslt = ProductDao.find(pd);
            return reslt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
		
	}

}