import dao.Dao;
import java.sql.*;
public class Application {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Model md1=new Model("PK00111","Pune","Jalgaon",6,0);
		Model md2=new Model("PK00112","Kolhapur","Solapur",2,0);
		Model md3=new Model("PK00113","Mumbai","Hyderabad",16,0);
		Model md4=new Model("PK00114","Chennai","Bangalore",10,0);
		Model md5=new Model("PK00115","Karnataka","MadhyaPradesh",20,0);
		try {
		md1.insert_data();
		md2.insert_data();
		md3.insert_data();
		md4.insert_data();
		md5.insert_data();
		}catch(InvalidIdException e)
		{
			System.err.println(e.getMessage());
		}
		Dao d=new Dao();
		d.pkd_retrive();
	}

}
