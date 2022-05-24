package main;

import java.util.List;

import DAO.DevProductDao;
import Enitity.Product;
import util.DbUtil;

public class DbDevExam5_Delete {

	public static void main(String[] args) {

		DevProductDao product = new DevProductDao(DbUtil.getConnection());

		product.delete("ボールペン");
		List<Product> list = product.findAll();

		for (Product b : list) {

			System.out.print("product_id:" + b.getProduct_id() + "、");
			System.out.print("product_name:" + b.getProduct_name() + "、");
			System.out.println("price:" + b.getPrice());

		}
	}

}
