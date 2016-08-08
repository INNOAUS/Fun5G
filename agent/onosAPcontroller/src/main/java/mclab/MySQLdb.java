package mclab;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MySQLdb 
{
	    private final String jdbcDriverStr;
	    private final String jdbcURL;
	    private final String user;
	    private final String password;
	 
	    private Connection connection;
	    private Statement statement;
	    private ResultSet resultSet;
	    private PreparedStatement preparedStatement;
	 
	    public MySQLdb(String jdbcDriverStr, String jdbcURL, String user, String password){
	        this.jdbcDriverStr = jdbcDriverStr;
	        this.jdbcURL = jdbcURL;
	        this.user = user;
	        this.password = password;
	        try {
			Class.forName(jdbcDriverStr);
			connection = DriverManager.getConnection(jdbcURL,user,password);
			System.out.println("\n- MySQL Connection");
			statement = connection.createStatement();
	        }catch(Exception ex){
				ex.printStackTrace();
	        }
	        
	    }
	    
	    public void insert(String Message) {
	    	/*
	    	 * QUERY: INSERT INTO AP_Information (IP, SSID, Description. Password, Broadcast, Channel, time) VALUES (ip, ssid, desc, pass, broad, chan, CURRENT_TIMESTAMP);
	    	 */
	    	
	    }
	    
	    public void update(String Message) {
	    	/*
	    	 * QUERY: INSERT INTO AP_Information (IP, SSID, Description. Password, Broadcast, Channel, time) VALUES (ip, ssid, desc, pass, broad, chan, CURRENT_TIMESTAMP) ON DUPLICATE KEY;
	    	 */
	 
	    }
	    
	    
	    public void heartbeat() {
	    	/*
	    	 * QUERY: DELETE FROM AP_Information WHERE (time - CURRENT_TIMESTAMP) <= -30; 
	    	 */
	 
	    }
	    
	    public String selcet() throws Exception {
			try{
				String sql;
				sql = "SELECT * FROM AP_Information";
				ResultSet rs = statement.executeQuery(sql);

				while(rs.next()){
					String IP = rs.getString("IP");
					String SSID = rs.getString("SSID");
					String Password = rs.getString("Password");
					String Broadcast = rs.getString("Broadcast");
					String Channel = rs.getString("Channel");
					String Time = rs.getString("Time");


					//should confirm to print format
					System.out.print("\n** IP : " + IP);
					System.out.print("\n   SSID: " + SSID);
					System.out.print("\n** Password : " + Password);
					System.out.print("\n   Broadcast: " + Broadcast);
					System.out.print("\n** Channel : " + Channel);
					System.out.print("\n   Time: " + Time);
					
				}
				rs.close();
			}catch(SQLException se1){
				se1.printStackTrace();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return "Show DB"; 
	    }
	 
	  
	    private void close(){
	        try {
	            if(resultSet!=null) resultSet.close();
	            if(statement!=null) statement.close();
	            if(connection!=null) connection.close();
	        } catch(Exception e){}
	    }
	    
}
