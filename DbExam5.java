package main;

import java.util.List;

import DAO.ProductDao;
import Enitity.Product;
import util.DbUtil;

public class DbExam5 {

	public static void main(String[] args) {

		ProductDao product = new ProductDao(DbUtil.getConnection());

		Product a = new Product();
		a.setProduct_name("ボールペン");
		a.setPrice(200);

		product.register(a);

		List<Product> list = product.findAll();

		for (Product b : list) {

			System.out.print("product_id:" + b.getProduct_id() + "、");
			System.out.print("product_name:" + b.getProduct_name() + "、");
			System.out.println("price:" + b.getPrice());

		}

		// Product u = list.get(0);

		/*
		 * u = list.get(1); assertEquals(Integer.valueOf(2), u.getProduct_id());
		 * assertEquals("Bob", u.getPuroduct_name()); assertEquals("password",
		 * u.getPrice());
		 */

	}

}
