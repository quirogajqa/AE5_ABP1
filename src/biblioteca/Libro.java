/**
 * @author Jhoseph Quiroga
 * @version 1.0
 */
package biblioteca;

/**
 * Representa un libro dentro del sistema de biblioteca. Contiene información
 * básica como título, autor, ISBN, año de publicación, género, así como su
 * sucursal de origen, la sucursal actual y cuántas veces ha sido prestado.
 */
public class Libro {

	// Atributos
	private String titulo;
	private String autor;
	private String isbn;
	private int anio;
	private String genero;
	private Sucursal sucursalOrigen;
	private Sucursal sucursalActual;
	private int conteoPrestamos = 0;

	// Constructores
	/**
	 * Constructor por defecto.
	 */
	public Libro() {

	}

	/**
	 * Constructor con parámetros para crear un libro con toda su información.
	 *
	 * @param titulo         Título del libro
	 * @param autor          Autor del libro
	 * @param isbn           Código ISBN
	 * @param anio           Año de publicación
	 * @param genero         Género del libro
	 * @param sucursalOrigen Sucursal donde fue ingresado el libro originalmente
	 */
	public Libro(String titulo, String autor, String isbn, int anio,
			String genero, Sucursal sucursalOrigen) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.anio = anio;
		this.genero = genero;
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalActual = sucursalOrigen;
	}

	// Accesadores y mutadores

	/**
	 * Obtiene el título del libro.
	 *
	 * @return Título del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Obtiene el autor del libro.
	 *
	 * @return Autor del libro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Obtiene el ISBN del libro.
	 *
	 * @return Código ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Obtiene el año de publicación del libro.
	 *
	 * @return Año del libro
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Obtiene el género del libro.
	 *
	 * @return Género del libro
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Obtiene la sucursal en la que el libro fue registrado originalmente.
	 *
	 * @return Sucursal de origen
	 */
	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	/**
	 * Obtiene la sucursal actual donde se encuentra el libro.
	 *
	 * @return Sucursal actual del libro
	 */
	public Sucursal getSucursalActual() {
		return sucursalActual;
	}

	/**
	 * Obtiene la cantidad de veces que el libro ha sido prestado.
	 *
	 * @return Número de préstamos del libro
	 */
	public int getConteoPrestamos() {
		return conteoPrestamos;
	}

	/**
	 * Cambia la sucursal actual del libro (cuando se transfiere a otra
	 * sucursal).
	 *
	 * @param sucursalOrigen Nueva sucursal donde estará el libro
	 */
	public void transferirLibro(Sucursal sucursalOrigen) {
		this.sucursalActual = sucursalOrigen;
	}

	// Métodos especiales

	/**
	 * Aumenta en uno el conteo de veces que el libro ha sido prestado.
	 */
	public void aumentarConteoPrestamos() {
		this.conteoPrestamos++;
	}

	/**
	 * Representación del objeto libro como una cadena legible para el usuario.
	 *
	 * @return Información completa del libro como String
	 */
	@Override
	public String toString() {
		return String.format("Título: %s | Autor: %s | ISBN: %s | Año: %s"
				+ " | Género: %s | Sucursal origen: %s |  Sucursal actual: %s",
				titulo, autor, isbn, anio, genero, sucursalOrigen.getNombre(),
				sucursalActual.getNombre());
	}

}
