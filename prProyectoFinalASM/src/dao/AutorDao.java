package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Autor;
import pojo.Manga;

public class AutorDao extends ObjetoDao implements InterfazDao<Autor>{
	
private static Connection connection;
	
	public AutorDao() {
		
	}

	@Override
	public ArrayList<Autor> buscarTodos() {
		connection = openConnection();

        ArrayList<Autor> autores = new ArrayList<Autor>();
        String query = "select * from autores";
        Autor autor = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                ArrayList<Manga> mangas = new ArrayList<Manga>();

                autor = new Autor(
                		rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getString("pais"),
						null);	

                String query_mangas = "select * from mangas where autor = ?";
                PreparedStatement ps_mangas = connection.prepareStatement(query_mangas);
                ps_mangas.setString(1, rs.getString("nombre")); 
                ResultSet rs_mangas = ps_mangas.executeQuery();

                while(rs_mangas.next()) {
                	Manga manga = new Manga(
                			rs_mangas.getInt("id"),
                			rs_mangas.getString("titulo"),
							rs_mangas.getInt("numero"),
							rs_mangas.getInt("paginas"));
                    mangas.add(manga);
                }

                autor.setMangas(mangas); 
                
                autores.add(autor);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return autores;
	}

	@Override
	public Autor buscarPorId(int i) {
		connection = openConnection();

        String query_autores = "select * from autores where id = ?";
        Autor autor = null;

        try {
        	PreparedStatement ps_autores = connection.prepareStatement(query_autores);
        	ps_autores.setInt(1, i); 
            ResultSet rs_autores = ps_autores.executeQuery();

            while (rs_autores.next()) {
                
                ArrayList<Manga> mangas = new ArrayList<Manga>();

                autor = new Autor(
                		rs_autores.getInt("id"), 
                		rs_autores.getString("nombre"), 
                		rs_autores.getInt("edad"),
                		rs_autores.getString("pais"), 
                		mangas);

                String query_mangas = "select * from mangas where autor = ?";
                PreparedStatement ps_mangas = connection.prepareStatement(query_mangas);
                ps_mangas.setInt(1, rs_autores.getInt("id")); 
                ResultSet rs_mangas = ps_mangas.executeQuery();

                while(rs_mangas.next()) {
                    Manga manga = new Manga(rs_mangas.getInt("id"),rs_mangas.getString("titulo"), rs_mangas.getInt("numero"), rs_mangas.getInt("paginas"));
                    mangas.add(manga);
                }

                autor.setMangas(mangas); 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return autor;
	}

	@Override
	public void insertar(Autor t) {
		connection = openConnection();

        String query = "insert into autores(id, nombre, edad, pais) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getNombre());
            ps.setInt(3, t.getEdad());
            ps.setString(4, t.getPais());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
		
	}

	@Override
	public void modificar(Autor t) {
		connection = openConnection();

        String query = "update autores set id = ?, edad = ?, pais = ? where nombre = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getId());
            ps.setInt(2, t.getEdad());
            ps.setString(3, t.getPais());
            ps.setString(4, t.getNombre());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void borrar(Autor t) {
		String nombre = t.getNombre();
		
		MangaDao mangaDao = new MangaDao();
		mangaDao.borrarPorAutor(nombre); 
		
		connection = openConnection();
		
		String query = "delete from autores WHERE nombre = ?";
		
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
	
	public Autor buscarPorNombre(String i) {
		connection = openConnection();
		
		String query = "select * from autores where nombre = ?";
		Autor autor = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, i);
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				autor = new Autor(rs.getInt("id"),
									rs.getString("nombre"),
									rs.getInt("edad"),
									rs.getString("pais"),
									null);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return autor;
	}

	

}
