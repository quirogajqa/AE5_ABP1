/**
 * @author Jhoseph Quiroga
 * @version 1.0
 */
package biblioteca;

import java.util.ArrayList;

/**
 * Representa un usuario registrado en la biblioteca. Contiene información
 * personal, la sucursal a la que está afiliado, y listas de sus préstamos
 * activos e historial de préstamos.
 */
public class Usuario {

	// Atributos
	private String rut;
	private String nombre;
	private String correo;
	private Sucursal sucursalAfiliado;
	ArrayList<Prestamo> prestamosActivos = new ArrayList<Prestamo>();
	ArrayList<Prestamo> prestamosHistorial = new ArrayList<Prestamo>();

	/**
	 * Constructor por defecto.
	 */
	public Usuario() {
	}

	// Constructores

	/**
	 * Constructor que inicializa un usuario con sus datos personales y sucursal
	 * afiliada.
	 *
	 * @param rut              RUT del usuario
	 * @param nombre           Nombre del usuario
	 * @param correo           Correo electrónico
	 * @param sucursalAfiliado Sucursal a la que está afiliado el usuario
	 */
	public Usuario(String rut, String nombre, String correo,
			Sucursal sucursalAfiliado) {
		this.rut = rut;
		this.nombre = nombre;
		this.correo = correo;
		this.sucursalAfiliado = sucursalAfiliado;
	}

	// Accesadores y mutadores

	/**
	 * Obtiene el RUT del usuario.
	 *
	 * @return RUT del usuario
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return Nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 *
	 * @return Correo electrónico
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Obtiene la sucursal a la que el usuario está afiliado.
	 *
	 * @return Objeto Sucursal afiliada
	 */
	public Sucursal getSucursalAfiliado() {
		return sucursalAfiliado;
	}

	/**
	 * Obtiene la lista de préstamos activos del usuario.
	 *
	 * @return Lista de préstamos activos
	 */
	public ArrayList<Prestamo> getPrestamosActivos() {
		return prestamosActivos;
	}

	// Métodos especiales

	/**
	 * Cambia la sucursal a la que el usuario está afiliado.
	 *
	 * @param sucursalNueva Nueva sucursal a asignar
	 */
	public void cambiarSucursal(Sucursal sucursalNueva) {
		this.sucursalAfiliado = sucursalNueva;
	}

	/**
	 * Verifica si el usuario puede pedir más préstamos. El límite permitido es
	 * de 5 préstamos activos.
	 *
	 * @return true si puede pedir más préstamos, false si ya alcanzó el límite
	 */
	public boolean puedePedirPrestado() {
		return prestamosActivos.size() <= 5;
	}

	/**
	 * Agrega un préstamo a la lista de préstamos activos y al historial.
	 *
	 * @param prestamo Préstamo a agregar
	 */
	public void agregarPrestamo(Prestamo prestamo) {
		prestamosActivos.add(prestamo);
		prestamosHistorial.add(prestamo);
	}

	/**
	 * Elimina un préstamo de la lista de préstamos activos (por devolución).
	 *
	 * @param prestamo Préstamo a eliminar
	 */
	public void eliminarPrestamo(Prestamo prestamo) {
		prestamosActivos.remove(prestamo);
	}

	/**
	 * Devuelve una representación en cadena del usuario, mostrando sus datos
	 * personales, sucursal y cantidad de préstamos activos.
	 *
	 * @return Información formateada del usuario
	 */
	@Override
	public String toString() {
		return String.format(
				"RUT: %s | Nombre: %s | Correo: %s | Sucursal: %s"
						+ " | Préstamos Activos: %d",
				rut, nombre, correo, sucursalAfiliado.getNombre(),
				prestamosActivos.size());
	}
}
