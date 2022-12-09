package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Serie serie = new Serie("Los Simpsons", 7, "Disney Plus");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//System.out.println(serieDao.buscarPorId(1)); 
		//Serie serie = serieDao.buscarPorId(1);
		//System.out.println(serie); 
		//Temporada t1 = new Temporada(1, "Temporada 1", serie);
		//Temporada t2 = new Temporada(2, "Temporada 2", serie);
		
		//TemporadaDao temporadaDao = new TemporadaDao();
		//temporadaDao.insertar(t1);
		//temporadaDao.insertar(t2); 
		
		//Serie s = new Serie("The Mandalorian", 12, "Disney Plus");
		//serieDao.insertar(s); 
		
		//Serie los_simpsons = serieDao.buscarPorId(1);
		//los_simpsons.setPlataforma("Netflix"); 
		//serieDao.modificar(los_simpsons); 
		
		//ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(los_simpsons);
		
		/*ArrayList<Temporada> temporadas = los_simpsons.getTemporadas();
		
		for (Temporada temporada : temporadas) {
			System.out.println(temporada); 
		}*/
		
		ArrayList<Serie> series = serieDao.buscarTodos();
		
		for (Serie serie : series) {
			System.out.println("SERIE: " + serie.getTitulo()); 
			for (Temporada temporada : serie.getTemporadas()) {
				System.out.println("TEMPORADA: " + temporada.getTitulo()); 
			}
		}
		
		//	Insertar temporadas para The Mandalorian
		//SerieDao serieDao = new SerieDao();
		//TemporadaDao temporadaDao = new TemporadaDao();
		
		/*Serie s = serieDao.buscarPorId(2);
		Temporada t1 = new Temporada(1, "The Mandalorian Season 1", s);
		Temporada t2 = new Temporada(2, "The Mandalorian Season 2", s);
		Temporada t3 = new Temporada(3, "The Mandalorian Final Season", s);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		temporadaDao.insertar(t3); */
		
		//temporadaDao.borrarPorSerie(2); 
		
		//Serie s = serieDao.buscarPorId(2);
		//serieDao.borrar(s); 
	}

}