package pojo;

import java.util.ArrayList;

public class Autor {
	
	private int id;
	private String nombre;
	private int edad;
	private String pais;
	private ArrayList<Manga> mangas;
	
	public Autor(int id, String nombre, int edad, String pais, ArrayList<Manga> mangas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.pais = pais;
		this.mangas = mangas;
	}

	public Autor(int id, String nombre, int edad, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(ArrayList<Manga> mangas) {
		this.mangas = mangas;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", pais=" + pais + ", mangas=" + mangas
				+ "]";
	}
	
	
	
	

}
