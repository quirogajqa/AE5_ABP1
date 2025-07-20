/**
 * @author Jhoseph Quiroga
 * @version 1.0
 */
package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un préstamo de un libro realizado por un usuario en una sucursal
 * específica. Contiene información sobre el libro, el usuario, la sucursal, la
 * fecha de préstamo y la fecha de vencimiento (automáticamente 14 días después
 * del préstamo).
 */
public class Prestamo {
	// Atributos

	private Libro libro;
	private Usuario usuario;
	private Sucursal sucursalPrestamo;
	private LocalDate fechaPrestamo;
	private LocalDate fechaVencimiento;

	// Constructores

	/**
	 * Constructor por defecto.
	 */
	public Prestamo() {

	}

	/**
	 * Constructor con parámetros que inicializa un préstamo con la fecha actual
	 * y establece la fecha de vencimiento automáticamente a 14 días después.
	 *
	 * @param libro            Libro prestado
	 * @param usuario          Usuario que realiza el préstamo
	 * @param sucursalPrestamo Sucursal desde donde se realiza el préstamo
	 * @param fechaPrestamo    Fecha en que se realiza el préstamo
	 */
	public Prestamo(Libro libro, Usuario usuario, Sucursal sucursalPrestamo,
			LocalDate fechaPrestamo) {
		this.libro = libro;
		this.usuario = usuario;
		this.sucursalPrestamo = sucursalPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaVencimiento = fechaPrestamo.plusDays(14);
	}

	// Accesadores y mutadores

	/**
	 * Obtiene el libro prestado.
	 *
	 * @return Objeto de tipo Libro
	 */
	public Libro getLibro() {
		return libro;
	}
	// Métodos

	/**
	 * Verifica si el préstamo está vencido comparando con una fecha actual
	 * dada.
	 *
	 * @param fechaActual Fecha contra la cual se compara
	 * @return true si la fecha actual es posterior a la fecha de vencimiento,
	 *         false si no
	 */
	public boolean estaVencido(LocalDate fechaActual) {
		return fechaActual.isAfter(fechaVencimiento);
	}

	/**
	 * Devuelve una representación legible del préstamo, incluyendo libro,
	 * usuario, sucursal, fecha de préstamo y vencimiento.
	 *
	 * @return Cadena con la información formateada del préstamo
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return String.format(
				"Libro: %s | Usuario: %s | Sucursal Origen: %s | "
						+ "Fecha de Préstamo: %s | Fecha de vencimiento: %s",
				libro.getTitulo(), usuario.getNombre(),
				sucursalPrestamo.getNombre(), fechaPrestamo.format(formatter),
				fechaVencimiento.format(formatter));
	}

}
