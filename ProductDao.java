package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Enitity.Product;

public class ProductDao {
	private Connection connection;
	
	private static final String SQL_SELECT_ALL = "SELECT product_id, product_name, price FROM products ORDER BY product_id";
	private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (?, ?)";
	
	 public ProductDao(Connection connection) {
	        this.connection = connection;
	 }
	
	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

	    try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	Product u = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
	            list.add(u);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }

	    return list;
    }
	
	public void register(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
            //stmt.setInt(1, product.getProduct_id());
            stmt.setString(1, product.getProduct_name());
            stmt.setInt(2, product.getPrice());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		
		
	}
	
	

}
