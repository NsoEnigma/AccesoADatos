package pojo;

public class Manga {
	
	private int id;
	private String titulo;
	private Autor autor;
	private int numero;
	private int paginas;
	
	public Manga(int id, String titulo, Autor autor, int numero, int paginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.numero = numero;
		this.paginas = paginas;
	}

	public Manga(int id, Autor autor, int numero, int paginas) {
		super();
		this.id = id;
		this.autor = autor;
		this.numero = numero;
		this.paginas = paginas;
	}

	public Manga(int id, String titulo, int numero, int paginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numero = numero;
		this.paginas = paginas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Manga [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", numero=" + numero + ", paginas="
				+ paginas + "]";
	}
	
	
	
	
	
	

}
