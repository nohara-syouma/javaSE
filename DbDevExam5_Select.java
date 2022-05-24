package main;

import DAO.DevProductDao;
import Enitity.Product;
import util.DbUtil;

public class DbDevExam5_Select {

	public static void main(String[] args) {

		DevProductDao product = new DevProductDao(DbUtil.getConnection());

		Product b = product.fintdByProductId(102);
		
		System.out.println("product_id:" + b.getProduct_id() + "product_name:"+ b.getProduct_name() + "price:" + b.getPrice());
	}

}