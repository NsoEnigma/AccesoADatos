package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AnimalDAO {

	private static Connection connection;
	
	//Buscar animal por id
	public static Animal findById(int id) {
		connection = openConnection();
		
		String query = "select * from animales where id = ?";
		Animal animal = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				animal = new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitad"),
						rs.getDouble("peso_aproximado")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return animal;
	}
	
	// Borrar animal por nombre
	public static void deleteAnimalByNombre(String nombre) { 
		connection = openConnection(); 
		
		String query = "DELETE FROM animales WHERE nombre = ?"; 
		
		try { 
			PreparedStatement ps = connection.prepareStatement(query); 
			ps.setString(1, nombre); 
			ps.executeUpdate();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
		closeConnection(); 
	}
		
	//Borrar todos los animales
	public static void deleteAnimal() {
		connection = openConnection();
		
		String query = "delete from animales";
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	//	Insertar un animal
	public static void insertAnimal(Animal animal) {
		connection = openConnection();
		
		String query = "insert into animales (nombre, habitad, "
				+ "peso_aproximado) values (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement(query);
			
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.gethabitad());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
