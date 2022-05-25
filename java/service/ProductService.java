package service;

import java.sql.Connection;

import Enitity.Product;
import dao.ProductDao;
import util.DbUtil;

public class ProductService {

	public Product find(Integer productId) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao ProductDao = new ProductDao(conn);
            return ProductDao.findpro(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}