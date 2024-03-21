package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String userName,String password){
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();		
			String sql = "SELECT * FROM customer WHERE username = '"+userName+"' AND password = '"+password+"'";			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}else{
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Customer> getCutomer(String username){

		ArrayList<Customer> cus = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer WHERE username = '"+username+"'";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);

				Customer c = new Customer(id,name,email,phone,userU,passU);
				cus.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//connection close wela nattm some times stmt fail wenw
			//dao eke eka table ekt adala crud okkom eka file eke danne
		}

		return cus;
	}

	public static boolean insertcustomer(String name, String email, String phone, String username, String password){
		boolean isSuccess = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO customer VALUES (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);

			if(rs>0){
				isSuccess = true;
			}else{
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean updatecustomer(String id,String name, String email, String phone, String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE customer SET name = '"+name+"', email = '"+email+"', phone = '"+phone+"', username = '"+username+"', password = '"+password+"' WHERE id ='"+id+"';";
			int rs = stmt.executeUpdate(sql);

			if(rs>0){
				isSuccess = true;
			}else{
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static List<Customer> getCutomerDetails(String Id){

		int convertedId = Integer.parseInt(Id);
		ArrayList<Customer> cus = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer WHERE id = '"+convertedId+"';";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);

				Customer c = new Customer(id,name,email,phone,userU,passU);
				cus.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cus;
	}
	
	public static boolean deleteCustomer(String id) {
		
		int convId = Integer.parseInt(id);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM customer WHERE id ='"+convId+"'";
			int rs = stmt.executeUpdate(sql);

			if(rs>0){
				isSuccess = true;
			}else{
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}

//lines wadi krl readbility wadi krl gnn puluwn
