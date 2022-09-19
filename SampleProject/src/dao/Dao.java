package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {
	public void pkd_retrive() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/package_cost","root","rps@12345");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from package_details");
		int package_fare=3000;
		double discount;
		double gst;
		int base_cost;
		while(rs.next())
		{
		String package_id=rs.getString("package_id");
		String source_place=rs.getString("source_place");
		String destination_place=rs.getString("destination_place");
		int no_of_days=rs.getInt("no_of_days");
		double package_cost=rs.getDouble("package_cost");
		System.out.println("Before the calculation of package cost of package_id "+package_id+" is : ");
		System.out.println("Package_ID: "+package_id+" from : "+source_place+" to : "+destination_place+" under "+no_of_days+" days with cost: "+package_cost+"\n");
		System.out.println("After the calculation of package cost of package_id "+package_id+" is : ");
		base_cost=package_fare*no_of_days;
		if(no_of_days<=5)
		{
			discount=0;
			gst=((base_cost-discount)*(0.12));
			package_cost=((base_cost)-discount)+gst;
			
			System.out.println("Package_ID: "+package_id+" from : "+source_place+" to : "+destination_place+" under "+no_of_days+" days with cost: "+package_cost);
			Statement st1=con.createStatement();
			st1.executeUpdate("update package_details set package_cost="+package_cost+" where package_id='"+package_id+"'");
		}else if(no_of_days>5 && no_of_days<=8)
		{
			discount=(base_cost*(0.03));
			gst=((base_cost-discount)*(0.12));
			package_cost=((base_cost)-discount)+gst;
			
			System.out.println("Package_ID: "+package_id+" from : "+source_place+" to : "+destination_place+" under "+no_of_days+" days with cost: "+package_cost);
			Statement st2=con.createStatement();
			st2.executeUpdate("update package_details set package_cost="+package_cost+" where package_id='"+package_id+"'");
		}else if(no_of_days>8 && no_of_days<=10)
		{
			discount=(base_cost*(0.05));
			gst=((base_cost-discount)*(0.12));
			package_cost=((base_cost)-discount)+gst;
			
			System.out.println("Package_ID: "+package_id+" from : "+source_place+" to : "+destination_place+" under "+no_of_days+" days with cost: "+package_cost);
			Statement st3=con.createStatement();
			st3.executeUpdate("update package_details set package_cost="+package_cost+" where package_id='"+package_id+"'");
		}else if(no_of_days>10)
		{
			discount=(base_cost*(0.07));
			gst=((base_cost-discount)*(0.12));
			package_cost=((base_cost)-discount)+gst;
			
			System.out.println("Package_ID: "+package_id+" from : "+source_place+" to : "+destination_place+" under "+no_of_days+" days with cost: "+package_cost);
			Statement st4=con.createStatement();
			st4.executeUpdate("update package_details set package_cost="+package_cost+" where package_id='"+package_id+"'");
		}
			System.out.println("\n\n");
		}
		st.close();
		con.close();
	}
}
