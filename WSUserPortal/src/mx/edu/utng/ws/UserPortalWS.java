package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserPortalWS {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public UserPortalWS(){
		conectar();
	}

	
	private void conectar(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:8081/wstest",
					"postgres", "jamoni97");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public int addUserPortal(UserPortal userPortal){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO userportal (portal, user_portall, create_date, isdeleted, refreshroles, authorised) "
						+ "VALUES(?,?,?,?,?,?);");
		
				ps.setString(1, userPortal.getPortal());
				ps.setString(2, userPortal.getUserPortall());
				ps.setString(3, userPortal.getCreateDate());
				ps.setString(4, userPortal.getAutorised());
				ps.setString(5, userPortal.getIsdeleted());
				ps.setString(6, userPortal.getRefreshRoles());
			
				
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateUserPortal(UserPortal userPortal){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"UPDATE userportal 	"
						
						+ "SET  portal=?, "
						+ "user_portall=?,"
						+ " create_date=?, "
						+ "isdeleted=?, "
						+ "refreshroles=?,"
						+ " authorised=?"
						+ "	WHERE id=?; ");
						
						
			
				ps.setString(1, userPortal.getPortal());
				ps.setString(2, userPortal.getUserPortall());
				ps.setString(3, userPortal.getCreateDate());
				ps.setString(4, userPortal.getIsdeleted());
				ps.setString(5, userPortal.getRefreshRoles());
				ps.setString(6, userPortal.getAutorised());
				ps.setInt(7,  userPortal.getId());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int removeUserPortal(int id){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM userportal WHERE id = ?;");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public UserPortal [] getUserPortals(){
		UserPortal [] result = null;
		List<UserPortal> userPortals = new ArrayList<UserPortal>();
		if (connection!= null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM userportal;");
						while(resultSet.next()){
							UserPortal userPortal= new UserPortal(
									resultSet.getInt("id"),
									resultSet.getString("portal"),
									resultSet.getString("user_portall"),
									resultSet.getString("create_date"),
									resultSet.getString("isdeleted"),
									resultSet.getString("authorised"),
									resultSet.getString("refreshroles"));
									
							userPortals.add(userPortal);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = userPortals.toArray(new UserPortal[userPortals.size()]);
		return result;
	}
	
	public UserPortal getUserPortalById(int id){
		UserPortal userPortal = null;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement("SELECT * FROM userportal WHERE id = ?;");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
						while(resultSet.next()){
							userPortal = new UserPortal(
									resultSet.getInt("id"),
									resultSet.getString("portal"),
									resultSet.getString("user_portall"),
									resultSet.getString("create_date"),
									resultSet.getString("autorised"),
									resultSet.getString("isdeleted"),
									resultSet.getString("refreshroles"));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userPortal;
	}
	
	/*public static void main(String[] args){
		AsentamientoWS ws = new AsentamientoWS();
		Asentamiento asentamiento = new Asentamiento(1, "37800", 1, 2, "algo", 1, "dolores", "otro", 2);
		ws.addAsentamiento(asentamiento);
	}*/

	

}

	

	
	
	
	
	
	


