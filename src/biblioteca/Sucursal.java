/**
 * @author Jhoseph Quiroga
 * @version 1.0
 */
package biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa una sucursal de la biblioteca. Contiene información de ubicación,
 * código identificador y una colección de libros. Permite agregar, buscar,
 * eliminar, prestar y devolver libros, además de consultar disponibilidad.
 */
public class Sucursal {

	// Atributos
	private String nombre;
	private String direccion;
	private int codigo;
	private HashMap<Libro, Boolean> coleccion = new HashMap<>();

	// Constructores
	/**
	 * Constructor por defecto.
	 */
	public Sucursal() {
	}

	/**
	 * Constructor con parámetros para inicializar una sucursal.
	 *
	 * @param nombre    Nombre de la sucursal
	 * @param direccion Dirección de la sucursal
	 * @param codigo    Código identificador único
	 */
	public Sucursal(String nombre, String direccion, int codigo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;

	}

	// Getter and Setter

	/**
	 * Obtiene el nombre de la sucursal.
	 *
	 * @return Nombre de la sucursal
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la dirección de la sucursal.
	 *
	 * @return Dirección de la sucursal
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Obtiene el código de la sucursal.
	 *
	 * @return Código identificador
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Obtiene la colección de libros y su disponibilidad.
	 *
	 * @return HashMap con libros como claves y disponibilidad (true/false) como
	 *         valor
	 */
	public HashMap<Libro, Boolean> getColeccion() {
		return coleccion;
	}

	// Métodos especiales

	/**
	 * Lista los libros disponibles en la sucursal.
	 *
	 * @return String con los libros disponibles, separados por salto de línea
	 */
	public String listarLibrosDisponibles() {
		StringBuilder resultado = new StringBuilder();
		for (Map.Entry<Libro, Boolean> entry : coleccion.entrySet()) {
			if (entry.getValue()) { // Si el libro está disponible
				Libro libro = entry.getKey();
				resultado.append(libro.toString()).append("\n");
				// resultado.append(libro.getTitulo()).append("\n");
			}
		}
		return resultado.toString();
	}

	/**
	 * Agrega un libro a la colección de la sucursal y lo marca como disponible.
	 *
	 * @param libro Libro a agregar
	 */
	public void agregarLibro(Libro libro) {
		coleccion.put(libro, true);
	}

	/**
	 * Verifica si un libro con el ISBN dado existe en la sucursal.
	 *
	 * @param isbn ISBN del libro a buscar
	 * @return true si el libro está en la colección, false si no
	 */
	public boolean contieneLibro(String isbn) {
		for (Libro libro : coleccion.keySet()) {
			if (libro.getIsbn().equalsIgnoreCase(isbn)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica si un libro con el ISBN dado está disponible para préstamo.
	 *
	 * @param isbn ISBN del libro
	 * @return true si está disponible, false si está prestado o no existe
	 */
	public boolean estaDisponible(String isbn) {
		for (Map.Entry<Libro, Boolean> entry : coleccion.entrySet()) {
			if (entry.getKey().getIsbn().equalsIgnoreCase(isbn)
					&& entry.getValue()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un libro de la colección de la sucursal.
	 *
	 * @param libro Libro a eliminar
	 */
	public void eliminarLibro(Libro libro) {
		coleccion.remove(libro);
	}

	/**
	 * Retorna una cadena indicando si el libro con ese ISBN está "Disponible" u
	 * "Ocupado".
	 *
	 * @param isbn ISBN del libro
	 * @return "Disponible" o "Ocupado"
	 */
	public String disponibleUOcupado(String isbn) {
		if (estaDisponible(isbn)) {
			return "Disponible";
		}
		return "Ocupado";
	}

	/**
	 * Busca un libro por su ISBN en la colección.
	 *
	 * @param isbn ISBN del libro
	 * @return Objeto Libro si se encuentra, null si no existe
	 */
	public Libro buscarLibroPorIsbn(String isbn) {
		for (Libro libro : coleccion.keySet()) {
			if (libro.getIsbn().equalsIgnoreCase(isbn)) {
				return libro;
			}
		}
		return null;
	}

	/**
	 * Marca un libro como prestado en la colección (no disponible).
	 *
	 * @param libro Libro a prestar
	 */
	public void prestarLibro(Libro libro) {
		coleccion.put(libro, false); // marcar como prestado
	}

	/**
	 * Marca un libro como disponible en la colección (devolución).
	 *
	 * @param libro Libro devuelto
	 */
	public void devolverLibro(Libro libro) {
		coleccion.put(libro, true); // Marcar disponible
	}

}
