package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteWS {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public ClienteWS(){
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
	
	public int addCliente(Cliente cliente){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO cliente (apellidos, "
						+ "nombre,"
						+ "nombre_completo, "
						+ "correo_electronico, "
						+ "compania,"
						+ "cargo, "
						+ "telefono_trabajo,"
						+ "telefono_particular,"
						+ "telefono_movil, "
						+ "numero_fax, "
						+ "direccion,"
						+ "ciudad, "
						+ "estado, "
						+ "codigo_postal) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
				
				
				ps.setString(1, cliente.getApellidos());
				ps.setString(2, cliente.getNombre());
				ps.setString(3, cliente.getNombreCompleto());
				ps.setString(4, cliente.getCorreoElectronico());
				ps.setString(5, cliente.getCompania());
				ps.setString(6, cliente.getCargo());
				ps.setString(7, cliente.getTelefonoTrabajo());
				ps.setString(8, cliente.getTelefonoParticular());
				ps.setString(9, cliente.getTelefonoMovil());
				ps.setString(10, cliente.getNumeroFax());
				ps.setString(11, cliente.getDireccion());
				ps.setString(12, cliente.getCiudad());
				ps.setString(13, cliente.getEstado());
				ps.setString(14, cliente.getCodigoPostal());
				
				
				
				
				
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateCliente(Cliente cliente){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"UPDATE cliente SET "
						+ "apellidos=?,"
						+ "nombre=?, "
						+ "nombre_completo=?,"
						+ "correo_electronico=?, "
						+ "compania=?, "
						+ "cargo=?,"
						+ "telefono_trabajo=?, "
						+ "telefono_particular=?, "
						+ "telefono_movil=?, "
						+ "numero_fax=?, "
						+ "direccion=?, "
						+ "ciudad=?, "
						+ "estado=?, "
						+ "codigo_postal= ?"
						+ "WHERE id = ?;");
				
				ps.setString(1, cliente.getApellidos());
				ps.setString(2, cliente.getNombre());
				ps.setString(3, cliente.getNombreCompleto());
				ps.setString(4, cliente.getCorreoElectronico());
				ps.setString(5, cliente.getCompania());
				ps.setString(6, cliente.getCargo());
				ps.setString(7, cliente.getTelefonoTrabajo());
				ps.setString(8, cliente.getTelefonoParticular());
				ps.setString(9, cliente.getTelefonoMovil());
				ps.setString(10, cliente.getNumeroFax());
				ps.setString(11, cliente.getDireccion());
				ps.setString(12, cliente.getCiudad());
				ps.setString(13, cliente.getEstado());
				ps.setString(14, cliente.getCodigoPostal());
				ps.setInt(15, cliente.getId());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int removeCliente(int id){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM cliente WHERE id = ?;");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Cliente[] getClientes(){
		Cliente[] result = null;
		List<Cliente>  clientes = new ArrayList<Cliente>();
		if (connection!= null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM cliente;");
						while(resultSet.next()){
							Cliente cliente = new Cliente(
									resultSet.getInt("id"),
									resultSet.getString("apellidos"),
									resultSet.getString("nombre"),
									resultSet.getString("nombre_completo"),
									resultSet.getString("correo_electronico"),
									resultSet.getString("compania"),
									resultSet.getString("cargo"),
									resultSet.getString("telefono_trabajo"),
									resultSet.getString("telefono_particular"),
									resultSet.getString("telefono_movil"),
									resultSet.getString("numero_fax"),
									resultSet.getString("direccion"),
									resultSet.getString("ciudad"),
									resultSet.getString("estado"),
									resultSet.getString("codigo_postal"));
									
							clientes.add(cliente);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = clientes.toArray(new Cliente[clientes.size()]);
		return result;
	}
	
	public Cliente getClientesById(int id){
		Cliente  cliente = null;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement("SELECT * FROM cliente WHERE id = ?;");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
						while(resultSet.next()){
							  cliente = new Cliente(
									resultSet.getInt("id"),
									resultSet.getString("apellidos"),
									resultSet.getString("nombre"),
									resultSet.getString("nombre_completo"),
									resultSet.getString("correo_electronico"),
									resultSet.getString("compania"),
									resultSet.getString("cargo"),
									resultSet.getString("telefono_trabajo"),
									resultSet.getString("telefono_particular"),
									resultSet.getString("telefono_movil"),
									resultSet.getString("numero_fax"),
									resultSet.getString("direccion"),
									resultSet.getString("ciudad"),
									resultSet.getString("estado"),
									resultSet.getString("codigo_postal"));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
	
	
}

