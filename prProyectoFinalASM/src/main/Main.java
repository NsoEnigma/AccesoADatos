package main;

import java.util.ArrayList;

import dao.AutorDao;
import dao.MangaDao;
import pojo.Autor;
import pojo.Manga;

public class Main {
	
	public static void main(String[] args) {
		
		AutorDao autorDao = new AutorDao();
		MangaDao mangaDao = new MangaDao();
		
		//Insertar autor en base de datos
		Autor autor1 = new Autor(1,"Igor Danieleski",19,"Polonia");
		//autorDao.insertar(autor1);
		
		Autor autor2 = new Autor(2,"Alba Subires",19,"España");
		//autorDao.insertar(autor2);
		
		
		//INSERTAR MANGAS
		
		
		//Manga manga1 = new Manga(1,"Tokyo Ghoul",autor1,1,150);
		//mangaDao.insertar(manga1);
		//Manga manga2 = new Manga(2,"Konosuba",autor2,1,200);
		//mangaDao.insertar(manga2);
		
		//VER TODAS LOS AUTORES DE LA BASE DE DATOS
		
		/*ArrayList<Autor> autores = autorDao.buscarTodos();
		for(Autor autorImprimir1 : autores) {
			System.out.println(autorImprimir1);
		}*/
		
		//VER AUTORES POR ID
		//System.out.println(autorDao.buscarPorId(2));
		
		//BUSCAR AUTOR POR NOMBRE
		//System.out.println(autorDao.buscarPorNombre("Alba Subires"));
		
		//VER TODOS LOS MANGAS
		/*ArrayList<Manga> mangas = mangaDao.buscarTodos();
		for(Manga mangasImprimir1 : mangas) {
			System.out.println(mangasImprimir1);
		}*/
		
		
		//Ver mangas por id
		//System.out.println(mangaDao.buscarPorId(1));
		
		
		//MODIFICAR AUTOR CREADO
		/*Autor autorModificar = new Autor(1,"Alba Subires",20,"España");
		autorDao.modificar(autorModificar);*/
		
		
		//MODIFICAR MANGA CREADO
		/*Manga mangaModificar = new Manga(1,"Tokyo Ghoul",autor1,1,200);
		mangaDao.modificar(mangaModificar);*/
		
		
		//BORRAR UN MANGA
		/*Manga manga = new Manga(2,"Konosuba",autor2,1,200);
		mangaDao.borrar(manga);*/
		
		
		//BORRA UN AUTOR
		/*Autor autor = new Autor(1,"Igor Danieleski",19,"Polonia");
		autorDao.borrar(autor);*/
	}
	
}
