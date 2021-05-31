package authenticate;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Based on MVC

public class LoginModel {
	Connection connection;


	public LoginModel() {
		//Check whether connected to database
		//Use Exception handling
		try {
			//Establish connection by using getConnection method which returns connection of sqlCon
			this.connection = dbConnection.getConnection();
		} catch (SQLException e) {
			//Catch SQL Exception
			e.printStackTrace();
		}
		if (this.connection == null){
			//If getConnection returns null, exit
			System.exit(0);
		}


	}


    public boolean isDBConnected(){
		//Connected to DB if it's not null
		return this.connection != null;
	}

	public boolean isLogin(String user, String pass, String opt) throws Exception{
		//SubInterface of Statement used to execute parameterized query
		PreparedStatement preparedStatement = null;//Object of PreparedStatement
		//The object of ResultSet maintains a cursor pointing to a row of a table
		ResultSet rs= null;
		//SQL Query to select values from auth table
		String sql = "SELECT * FROM auth WHERE username = ? and password = ? and role = ?";
		try{
			//Pass SQL Query to object of prepared statement
			preparedStatement = this.connection.prepareStatement(sql);
			//sets the String value to the given parameter index.
			preparedStatement.setString(1, user);
			preparedStatement.setString(2,pass);
			preparedStatement.setString(3,opt);
			rs = preparedStatement.executeQuery();//result set object

			/*The next() method of the ResultSet interface moves
			the pointer of the current (ResultSet) object to the next row, from the current position.*/

			if (rs.next()){
				//Setting user credentials for further processing
				return true;
			}
				return false;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			//Close Database Connection
			preparedStatement.close();
			rs.close();
		}

        return true;
    }


}
