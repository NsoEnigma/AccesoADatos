package prZoologicoDAO;

public class Animal {

	private int id;
	private String nombre;
	private String habitad;
	private double peso_aproximado;
	
	public Animal (int id, String nombre, String habitad, double peso_aproximado) {
		this.id = id;
		this.nombre = nombre;
		this.habitad = habitad;
		this.peso_aproximado = peso_aproximado;
	}
	
	public Animal (String nombre, String habitad, double peso_aproximado) {
		this.nombre = nombre;
		this.habitad = habitad;
		this.peso_aproximado = peso_aproximado;
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

	public String gethabitad() {
		return habitad;
	}

	public void sethabitad(String habitad) {
		this.habitad = habitad;
	}

	public double getPeso_aproximado() {
		return peso_aproximado;
	}

	public void setPeso_aproximado(double peso_aproximado) {
		this.peso_aproximado = peso_aproximado;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", habitad=" + habitad + ", peso_aproximado="
				+ peso_aproximado + "]";
	}
}
