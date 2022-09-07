package databseInsertionDynamicallyJDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcInsertionDynamically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		BufferedReader br=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harendradb", "root", "root@123");
		   st=con.createStatement();
		   
		   br =new BufferedReader(new InputStreamReader(System.in));
		   
		   while(true) {
			   System.out.println("Enter Employee Number ");
			   int eno=Integer.parseInt(br.readLine());

			   System.out.println("Enter tha Employee name");
			   String ename=br.readLine();

			   System.out.println("Enter the Employee Salary");
			   float esal=Float.parseFloat(br.readLine()); 

			   System.out.println("Enter the Employee address");
			   String eadd=br.readLine();

			   String query="insert into employee value("+eno+",'"+ename+"','"+esal+"','"+eadd+"')";

			   st.executeUpdate(query);

			   System.out.print("Do you want add more employee? [y/n] :");
			   String option=br.readLine();
			   if(option.equalsIgnoreCase("y")) {
				   continue;
			   }else {
				   break;
			   }
		   }
		   System.out.println("Employee Inserted Successfully");
			
			
	}catch(Exception e) {
		e.printStackTrace();
		
	}
		finally {
			try {
				br.close();
				st.close();
				con.close();
				
				
			}catch(Exception e2) 
			{
				e2.printStackTrace();
			}
			
		}
	}

}

