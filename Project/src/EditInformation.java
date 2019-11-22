import java.io.IOException;
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


@WebServlet("/EditInformation")
public class EditInformation extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public EditInformation() {
        super();
    }

    Connection con;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String confirm=request.getParameter("confirm");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		
		//Applying contraints on the data
		if(password.equals(confirm))
 	   {
 		   
 	   }
 	   else
 	   {
 		   String message="password and confirm password does not match!! Please try Again";
 		   request.setAttribute("pass", message);
 		   RequestDispatcher ds=request.getRequestDispatcher("/Update.jsp");
 		   ds.forward(request, response);
 	   }
 	   
 	   if(name.equals("")||dob.equals(""))
 	   {
 		   String namemessage="Name field cannot be empty";
 		   request.setAttribute("namemessage", namemessage);
 		   RequestDispatcher dn=request.getRequestDispatcher("/Update.jsp");
 		   dn.forward(request, response);
 	   }
 	   
 	   
 	   //contraint for age
 	  try
	   {
		   int i=0;
		   i=Integer.parseInt(age);
		   if(i>150)
		   {
			   String agemsg="Incorrect Age!! Please Enter Correct Age";
			   request.setAttribute("agemsg", agemsg);
			   RequestDispatcher ra=request.getRequestDispatcher("/Update.jsp");
			   ra.forward(request, response);
		   }
	   }
	   catch (Exception e) 
	   {
		   String agemessage="Age should be in number format";
		   request.setAttribute("agemessage", agemessage);
		   RequestDispatcher rd=request.getRequestDispatcher("/Update.jsp");
		   rd.forward(request, response);
	   }
 	   
 	   
 	   /*try
 	   {
 		   int i=0;
 		   i=Integer.parseInt(dob);
 	   }
 	   catch (Exception e) 
 	   {
 		   String dobmessage="DOB should be in number format";
 		   request.setAttribute("dobmessage", dobmessage);
 		   RequestDispatcher rd=request.getRequestDispatcher("/Update.jsp");
 		   rd.forward(request, response);
	   }*/
 	   
	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		PrintWriter out=response.getWriter();
		
		out.println("Id of this record is "+id);
	//
		//out.println("Value of username is" +username+" name is "+name+" dob is "+dob+" address is "+address+" password is"+password);
		
		
		
		//Loading the driver
		 /*try
  	   	{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","root");
  	   	}
  	   catch (ClassNotFoundException | SQLException e)
  	   	{
  		   	// TODO Auto-generated catch block
  		   	e.printStackTrace();
  	   	}
  	   */
		
		
		DbInfo obj=new DbInfo();
		con=obj.getConnection();
		 String query="update emp set Name=?, Username=?, DOB=?, Address=?, password=?, Age=? where ID=?";
		 try
		 {
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, name);
			 ps.setString(2, username);
			 ps.setString(3, dob);
			 ps.setString(4, address);
			 ps.setString(5, password);
			 ps.setString(6, age);
			 ps.setString(7, id);
			
			// java.sql.ResultSet res=ps.executeQuery();
  		    
			 ps.executeUpdate();
  		    
  		    	 String sucess="Data updated Sucessfully";
  	  		     request.setAttribute("sucess", sucess);
  	  		     RequestDispatcher rn1=request.getRequestDispatcher("/Update.jsp");
  	 		     rn1.forward(request, response);
  		  
			/* String sucess="Data updated Sucessfully";
  		     request.setAttribute("Sucess", sucess);
  		     RequestDispatcher rn1=request.getRequestDispatcher("/Update.jsp");
 		     rn1.forward(request, response);
  		    */ 
		 }
		 catch (Exception e) 
		 {
			// TODO: handle exception
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet(request, response);
		//Retreiving the information
	}

}
