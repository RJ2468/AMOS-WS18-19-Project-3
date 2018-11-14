package db.psql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class User {
	
	static String psqlUser = "server_Adrenaline";
	static String psqlPassword = "pw";

	public static int writeUserIntoDBgetID(String email, String pw, int typeID, int type)
			throws SQLException, ClassNotFoundException, InterruptedException, ParseException {

		String url = "jdbc:postgresql://localhost:5432/Adrenaline_DB";
		Class.forName("org.postgresql.Driver");

		Connection conn = DriverManager.getConnection(url, psqlUser, psqlPassword);

		String query = "INSERT INTO USER (id_user, email, password, id_user_type, user_type) VALUES (?, ?, ?, ?, ?);";

		// possible if ID gets generated 
		//String generatedColumns[] = { "id_user" };
		//String generatedColumns[] = null;
		
		//PreparedStatement preparedStmt = conn.prepareStatement(query, generatedColumns);
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		
		preparedStmt.setInt(1, 1);
		preparedStmt.setString(2, email);
		preparedStmt.setString(3, pw);
		preparedStmt.setInt(4, 1);
		preparedStmt.setInt(5, 1);

		preparedStmt.executeUpdate();

		/*
		ResultSet rs = preparedStmt.getGeneratedKeys();
		rs.next();
		int vorgangID = (int) rs.getLong(1);

		System.out.println("...process " + vorgangID + " is registered.");
		*/
		
		return 11;
	}
	
}
