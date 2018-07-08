package com.test.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.test.beans.Product;
import com.test.beans.User;

public class ApplicationDao {

	public List<Product> searchProducts(String searchString) {
		Product product = null;
		List<Product> products = new ArrayList<>();

		try{
			Connection connection = DBConnection.getConnectionToDatabase();

			String sql = "select * from products where product_name like '%"+searchString+"%'";

			Statement statement = connection.createStatement();

			ResultSet set = statement.executeQuery(sql);

			while(set.next()){
				product= new Product();
				product.setProductId(set.getInt("product_id"));
				product.setProductImgPath(set.getString("image_path"));
				product.setProductName(set.getString("product_name"));
				products.add(product);

			}

		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		return products;
	}

	public int registerUser (User user){
		int rowAffected = 0;

		try{
			//get the connection for database
			Connection connection = DBConnection.getConnectionToDatabase();

			//white the insert query
			String insertQuery = " insert into users values (?,?,?,?,?,?)";

			//set parameters with PrepareStatement
			java.sql.PreparedStatement statement = connection.prepareStatement (insertQuery);
			statement.setString (1, user.getUsername ());
			statement.setString (2, user.getPassword ());
			statement.setString (3, user.getFirstname ());
			statement.setString (4, user.getLastname ());
			statement.setInt (5, user.getAge ());
			statement.setString (6, user.getActivity ());


			//execute the statement
			rowAffected = statement.executeUpdate ();


		}catch (SQLException exeption){
 			exeption.printStackTrace ();
		}
		return rowAffected;
	}

	    public boolean validateUser(String username, String password){
	    boolean isValidUser = false;
	    try{
            //get the connection for the database
                Connection connection = DBConnection.getConnectionToDatabase ();

            //white the select query
                String sql = "select * from users where username=? and password=?";

            //set parameter with prepare statement
                PreparedStatement statement = connection.prepareStatement (sql);
                statement.setString (1, username);
                statement.setString (2, password);

            //execute the statement and check whether user exists
                ResultSet Set = statement.executeQuery ();
                while (Set.next ()){
                    isValidUser = true;
                }

        }catch (SQLException exeption){
	        exeption.printStackTrace ();
        }
            return isValidUser;
        }

}
