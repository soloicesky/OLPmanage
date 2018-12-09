package com.onlinepay.manage.web.util;


		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.SQLException;
		public class TestDb {
			public static void main(String[] args) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					try {
						Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_pay?useUnicode=true&amp;characterEncoding=UTF-8&amp","onlinepay", "onlinePay@123");
						System.out.println(c.prepareStatement("select * from channel"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


}
