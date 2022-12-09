package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {
	
	private static Connection connection;
	
	public SerieDao () {
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Serie> series = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM series";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
				
				Serie serie = new Serie(
							rs.getInt("id"),
							rs.getString("titulo"),
							rs.getInt("edad"),
							rs.getString("plataforma"),
							null
				);
				
				String query_temporadas = "select * from temporadas where serie_id = ?";
				PreparedStatement ps_temporadas = connection.prepareStatement(query_temporadas);
				ps_temporadas.setInt(1, rs.getInt("id")); 
				ResultSet rs_temporadas = ps_temporadas.executeQuery();
				
				while(rs_temporadas.next()) {
					Temporada temporada = new Temporada(
								rs_temporadas.getInt("id"),
								rs_temporadas.getInt("num_temporada"),
								rs_temporadas.getString("titulo")
					);
					temporadas.add(temporada);
				}
				
				serie.setTemporadas(temporadas); 
				
				series.add(serie);
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return series;
	}

	@Override
	public Serie buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		Serie serie = null;
		
		String query = "select * from series where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				serie = new Serie(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
				);
				serie.setTemporadas(obtenerTemporadas(serie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return serie;
	}

	@Override
	public void insertar(Serie serie) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into series (titulo, edad, plataforma)"
							+ " values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Serie serie) {
		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();
		
		connection = openConnection();
		
		String query = "UPDATE series SET titulo = ?, edad = ?, plataforma = ? "
				+ " WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public ArrayList<Temporada> obtenerTemporadas(Serie serie) {
		ArrayList<Temporada> temporadas = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM temporadas WHERE serie_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Temporada temporada = new Temporada(
							rs.getInt("id"),
							rs.getInt("num_temporada"),
							rs.getString("titulo"),
							serie
						);
				temporadas.add(temporada);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return temporadas;
	}
		
	@Override
	public void borrar(Serie serie) {
		int serie_id = serie.getId();
		
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.borrarPorSerie(serie_id); 
		
		connection = openConnection();
		
		String query = "DELETE FROM series WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
}