import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conn {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
		public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
		   
		 
	   }
	
	
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'weather' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'city' text, 'localDate' text,'temperature' REAL, 'weather' text);");
		
	   }
	
		public static void WriteDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'weather' ('city', 'localDate','temperature','weather') VALUES ('Лима', '2021-12-31',  "Cолнечно",'25'); ");
		   statmt.execute("INSERT INTO 'weather' ('city', 'localDate','temperature','weather') VALUES ('Буэнос-Айрес', '2021-12-31',  "Cолнечно", '23'); ");
		  
		  
		   
	}
	
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			
		   }

}
