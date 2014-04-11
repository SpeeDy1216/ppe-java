package file;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connexion {
	private static String url = "jdbc:mysql://127.0.0.1/base_java";
	//private static String url = "jdbc:postgresql://127.0.0.1/base_java";
	private static String user = "root";
	private static String passwd = "";
	
	private static Connection connect;
	
	public static Connection getInstance(){
		if(connect == null){
			try{
				connect=DriverManager.getConnection(url, user, passwd);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return connect;
	}
}
