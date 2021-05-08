package authenticate;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Based on MVC

public class LoginModel {
	Connection connection;
	public static String loggerUsername = "";
	public static String loggerAccessLevel = "";


	public LoginModel() {
		//Check whether connected to database
		try {
			this.connection = dbConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (this.connection == null){
			System.exit(0);
		}


	}


    public boolean isDBConnected(){
		return this.connection != null;
	}

	public boolean isLogin(String user, String pass, String opt) throws Exception{
		PreparedStatement preparedStatement = null;
		ResultSet rs= null;
		String sql = "SELECT * FROM auth WHERE username = ? and password = ? and role = ?";
		try{
			preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.setString(1, user);
			preparedStatement.setString(2,pass);
			preparedStatement.setString(3,opt);
			rs = preparedStatement.executeQuery();//result set object

			boolean status;
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
			preparedStatement.close();
			rs.close();
		}

        return true;
    }


}
