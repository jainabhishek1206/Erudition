import java.io.IOException ;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	Connection con;
	int flag=0;
    public SignIn() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int flag=0;

		//retreiving the values from the previous jsp
		String username=request.getParameter("username");
 	    String password=request.getParameter("password");
 	    String name="";
 	    String dob="";
 	    String address="";
 	    String id="";
 	    String age="";
		PrintWriter out=response.getWriter();
	//	out.println("Value of username is" +username +" and that of password is "+password);
		
		   /*try
		   {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","root");
		   }		
		
		 //load the Driver and establish a connection

		   catch (ClassNotFoundException | SQLException e)
		   {
			e.printStackTrace();
		   }*/
		   
		
		DbInfo obj=new DbInfo();
		con=obj.getConnection();
		 
		   //writting the query
		
		   String query="select * from emp where Username=? and password=?";
		   try
		   {
		    PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
						
			java.sql.ResultSet res=ps.executeQuery();
			while(res.next())
			{
				flag=1;
				name=res.getString(2);
				dob=res.getString(5);
				address=res.getString(7);
				age=res.getString(6);
				id=res.getString(1);
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("username", username);
				request.setAttribute("dob", dob);
				request.setAttribute("address", address);
				request.setAttribute("age", age);
				
				
				HttpSession session=request.getSession();
				session.setAttribute("name",name);
				session.setAttribute("username", username);
				session.setAttribute("dob", dob);
				session.setAttribute("address", address);
				session.setAttribute("id", id);
				session.setAttribute("password", password);
				session.setAttribute("age", age);
				RequestDispatcher dp=request.getRequestDispatcher("/info.jsp");
				dp.forward(request, response);
				//response.sendRedirect("info.jsp");
				break;
			}

			if(flag==0)
			{
				//out.println("Login Failed!! Retry");
				String login="Login Failed!! Retry";
				request.setAttribute("login", login);
				RequestDispatcher rl=request.getRequestDispatcher("/Login.jsp");
				rl.forward(request, response);
			}
		   }
		   catch(Exception e)
		   {
			   
		   }

		   
		   doGet(request, response);
	}

}
