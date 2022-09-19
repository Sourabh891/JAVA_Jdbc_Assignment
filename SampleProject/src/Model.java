import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Model{
		String package_id,source_place,destination_place;
		int no_of_days;
		float package_cost;
		
		public String getPackage_id() {
			return package_id;
		}
		public void setPackage_id(String package_id) {
			this.package_id = package_id;
		}
		public String getSource_place() {
			return source_place;
		}
		public void setSource_place(String source_place) {
			this.source_place = source_place;
		}
		public String getDestination_place() {
			return destination_place;
		}
		public void setDestination_place(String destination_place) {
			this.destination_place = destination_place;
		}
		public int getNo_of_days() {
			return no_of_days;
		}
		public void setNo_of_days(int no_of_days) {
			this.no_of_days = no_of_days;
		}
		public float getPackage_cost() {
			return package_cost;
		}
		public void setPackage_cost(float package_cost) {
			this.package_cost = package_cost;
		}
		public Model() {
			super();
		}
		public Model(String package_id, String source_place, String destination_place, int no_of_days,
				float package_cost) {
			super();
			this.package_id = package_id;
			this.source_place = source_place;
			this.destination_place = destination_place;
			this.no_of_days = no_of_days;
			this.package_cost = package_cost;
		}
		public void insert_data() throws Exception,InvalidIdException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/package_cost","root","rps@12345");
			Statement st=con.createStatement();
			if(package_id.length()!=7)
			{
				throw new InvalidIdException("ID must ber greater than 7 characters ");
			}
			else
			{
				st.executeUpdate("insert into package_details values('"+package_id+"','"+source_place+"','"+destination_place+"',"+no_of_days+","+package_cost+")");
			}
			st.close();
			con.close();
		}
}
