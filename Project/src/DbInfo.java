import java.sql.Connection;
import java.sql.DriverManager;

public class DbInfo 
{        
	public Connection getConnection()
    {
        Connection con=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","rat");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }
}  