package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Autor;
import pojo.Manga;

public class MangaDao extends ObjetoDao implements InterfazDao<Manga>{
	
	private static Connection connection;
	
	@Override
	public ArrayList<Manga> buscarTodos() {
		
		ArrayList<Manga> mangas = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "select * from mangas";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Manga manga = new Manga(rs.getInt("id"),
						rs.getString("titulo"),
						null,
						rs.getInt("numero"),
						rs.getInt("paginas"));
				
				 String query_autores = "select * from autores where nombre = ?";
	             PreparedStatement ps_autores = connection.prepareStatement(query_autores);
	             ps_autores.setInt(1, rs.getInt("id")); 
	             ResultSet rs_autores = ps_autores.executeQuery();
	             
	             while(rs_autores.next()) {
	            	 
	            	Autor autor = new Autor(rs_autores.getInt("id"),
	            			rs_autores.getString("nombre"),
	            			rs_autores.getInt("edad"),
	            			rs_autores.getString("pais"));
	 						
	            	 if(rs_autores.getInt("levelNum") == rs.getInt("backroomNum")) {
	            		 manga.setAutor(autor);
	            	 }
	             }
	             
	             mangas.add(manga);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mangas;
	}

	@Override
	public Manga buscarPorId(int i) {
		Manga manga = null;
		
		connection = openConnection();
		
		String query = "select * from mangas where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				manga = new Manga(rs.getInt("id"),
						rs.getString("titulo"),
						null,
						rs.getInt("numero"),
						rs.getInt("paginas"));
			
				String query_autores = "select * from autores where nombre = ?";
		        PreparedStatement ps_autores = connection.prepareStatement(query_autores);
		        ps_autores.setInt(1, rs.getInt("id")); 
		        ResultSet rs_autores = ps_autores.executeQuery();
		             
		        while(rs_autores.next()) { 
		        	Autor autor = new Autor(rs_autores.getInt("id"),
		        			rs_autores.getString("nombre"),
		            		rs_autores.getInt("edad"),
		            		rs_autores.getString("pais"));
		 						
		            if(rs_autores.getInt("id") == rs.getInt("id")) {
		            	manga.setAutor(autor);
		            }
		        }	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return manga;		
	}
	

	@Override
	public void insertar(Manga t) {
		connection = openConnection();

        String query = "insert into mangas(id, titulo, autor, numero, paginas) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getTitulo());
            ps.setString(3, t.getAutor().getNombre());
            ps.setInt(4, t.getNumero());
            ps.setInt(5, t.getPaginas());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@Override
	public void modificar(Manga t) {
		connection = openConnection();

        String query = "update mangas set id = ?, titulo = ?, autor = ?, numero = ?, paginas = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getTitulo());
            ps.setString(3, t.getAutor().getNombre());
            ps.setInt(4, t.getNumero());
            ps.setInt(5, t.getPaginas());
            ps.setInt(6, t.getId());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	@Override
	public void borrar(Manga t) {
		connection = openConnection();

        String query = "delete from mangas where titulo = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getTitulo());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnection();
	}
	
	public void borrarPorAutor (String nombre) {
		connection = openConnection();
		
		String query = "delete from mangas where autor = ?";
		
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

}
