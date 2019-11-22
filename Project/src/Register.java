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

import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.javah.Util.Exit;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
           public Register() {
        super();
    }
           Connection con;

           protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
           {
        	   System.out.println("Entered in doget blcok");
        	   //Retreiving the values from the jsp page
        	   String name=request.getParameter("name");
        	   String username=request.getParameter("username");
        	   String password=request.getParameter("password");
        	   String confirm=request.getParameter("confirm");
        	   String dob=request.getParameter("dob");
        	   String address=request.getParameter("address");
        	   String age=request.getParameter("age");
        	   
        	   
        	   /*HttpSession session=request.getSession();
        	   session.setAttribute("username1", username);*/
        	   
        	   
        	   PrintWriter out=response.getWriter();
        	  // out.println("values of the variables are"+name +"   "+username +"   "+password +"   "+confirm +"   "+dob +"   "+address);
        	
        	   if(password.equals(confirm))
        	   {
        		   //out.println("password and confirm password does not match");
        	   }
        	   else
        	   {
        		   //out.println("password and confirm password does not match");
        		   //response.sendRedirect("regist.jsp");
        		   String message="password and confirm password does not match!! Please try Again";
        		   request.setAttribute("pass", message);
        		   RequestDispatcher ds=request.getRequestDispatcher("/regist.jsp");
        		   ds.forward(request, response);
        	   }
        	   
        	   if(name.equals("")||username.equals(""))
        	   {
        		   String namemessage="Name and username field cannot be empty";
        		   request.setAttribute("namemessage", namemessage);
        		   RequestDispatcher dn=request.getRequestDispatcher("/regist.jsp");
        		   dn.forward(request, response);
        	   }
        	   
        	   try
        	   {
        		   int i=0;
        		   i=Integer.parseInt(age);
        		   if(i>150 && i<1)
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
        		   RequestDispatcher rd=request.getRequestDispatcher("/regist.jsp");
        		   rd.forward(request, response);
			   }
        	   
        	   //load the Driver
        	  /* try
        	   {
        		Class.forName("com.mysql.jdbc.Driver");
        		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","root");
        	   }
        	   catch (ClassNotFoundException | SQLException e)
        	   {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	   }*/
        	   
        	   
        	   DbInfo obj=new DbInfo();
       		con=obj.getConnection();
        	   int flag=0;
        	   //establish a connection
        	  // String query="insert into employee values(?,?,?,?,?)";
        	     String query="insert into emp (Name, Username, password, DOB, Age, Address) values(?,?,?,?,?,?)";
        	   String query1="select * from emp where Username=?";
        	   System.out.println("Query is "+query);
        	   try
        	   {
        		   
        		   PreparedStatement ps1=con.prepareStatement(query1);
        		   
        		   
        		   ps1.setString(1, username);
        		   java.sql.ResultSet res=ps1.executeQuery();
        		   
        		   
        		   while(res.next())
        		   {
        			   String usernamemessage="UserName already exist!! Please try another username";
            		   request.setAttribute("usernamemessage", usernamemessage);
            		   RequestDispatcher ru=request.getRequestDispatcher("/regist.jsp");
            		   ru.forward(request, response);
            		   flag=1;
        			   
        		   }
        		   if(flag==0)
        		   {
        		   PreparedStatement ps=con.prepareStatement(query);
        		   ps.setString(1, name);
        		   ps.setString(2, username);
        		   ps.setString(3, password);
        		   ps.setString(4, dob);
        		   ps.setString(5, age);
        		   ps.setString(6, address);
        		   ps.executeUpdate();
        		   ps.close();
        		   con.close();
        		   
        		   RequestDispatcher re=request.getRequestDispatcher("/Login.jsp");
        		   re.forward(request, response);
        		   }
        		   
        		   
        		   
        	   }
        	   catch(Exception e)
        	   {
        		   e.printStackTrace();
        	   }
      
        	   
        	   
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 	   System.out.println("Entered in do post blcok");
		doGet(request, response);
	}

}
