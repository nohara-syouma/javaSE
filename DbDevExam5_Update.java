package main;

import DAO.DevProductDao;
import Enitity.Product;
import util.DbUtil;

public class DbDevExam5_Update {

	public static void main(String[] args) {

		DevProductDao product = new DevProductDao(DbUtil.getConnection());

	
		Product a = new Product();
		a.setProduct_id(101);
		a.setProduct_name("シャープペンシル");
		a.setPrice(70);

		product.update(a);
		Product after = product.fintdByProductId(a.getProduct_id());
	
		
		System.out.println("product_id:" + after.getProduct_id()+"," + "product_name:"+ after.getProduct_name() +","+ "price:" + after.getPrice());
	}

}
