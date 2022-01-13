package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException exob1) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/banking_app", "root", "admin123");
		} catch (SQLException exob2) {
		}
		return con;
	}

}