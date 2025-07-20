/**
 * 
 * @author Jhoseph Quiroga
 * @version 1.0
 */
package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * SistemaBiblioteca representa la aplicación principal para gestionar una biblioteca.
 * Permite registrar usuarios, libros, sucursales, realizar préstamos y devoluciones,
 * generar reportes y validar datos como el RUT chileno.
 */
public class SistemaBiblioteca {
	/** Scanner para entrada de datos del usuario */
	static Scanner sc = new Scanner(System.in);
	/** Lista de sucursales registradas */
	static ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
	/** Lista de usuarios registrados */
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	/** Lista de préstamos realizados */
	static ArrayList<Prestamo> prestamos = new ArrayList<>();

	/**
	 * Método principal del sistema. Inicia el menú interactivo de opciones y
	 * controla la navegación entre los distintos módulos: usuarios, libros,
	 * préstamos, sucursales y reportes.
	 *
	 * Usa control de excepciones para evitar fallos por entradas inválidas.
	 */
	public static void main(String[] args) {

		boolean datosPruebaCargados = false;
		System.out.println("SISTEMA DE GESTIÓN DE BIBLIOTECAS");
		System.out.println("Bienbenido al sistema de gestión de bibliotecas");
		do {
			try {
				System.out.println("\n MENÚ PRINCIPAL");
				if (!datosPruebaCargados) {
					System.out.println("0.- Ingresar datos de prueba.");
				}
				System.out.println("1.- Usuarios.");
				System.out.println("2.- Libros.");
				System.out.println("3.- Prestamos.");
				System.out.println("4.- Sucursales.");
				System.out.println("5.- Búsqueda y Reportes.");
				System.out.println("6.- Salir.");
				System.out.print("Seleccione el área del sistema: ");
				int opcionArea = sc.nextInt();
				sc.nextLine();
				switch (opcionArea) {
				case 0: {
					llenarDatosPrueba();
					datosPruebaCargados = true;
					break;
				}
				case 1: {
					System.out.println("\n SUBMENÚ USUARIOS");
					System.out.println("1.- Agregar usuario.");
					System.out.println("2.- Cambiar usuario de sucursal.");
					System.out.println("3.- Buscar usuario.");
					System.out.println("4.- Menu principal.");
					System.out.print("Ingrese una opción: ");
					int opcionUsuario = sc.nextInt();
					sc.nextLine();
					switch (opcionUsuario) {
					case 1: {
						agregarUsuario();
						break;
					}
					case 2: {
						cambiarUsuarioSucursal();
						break;
					}
					case 3: {
						System.out.println(buscarUsuario().toString());
						break;
					}
					case 4: {
						break;
					}
					default:
						System.out.println("Ingrese una opción valida.");
					}
					break;
				}
				case 2: {
					System.out.println("\n SUBMENÚ LIBROS");
					System.out.println("1.- Registrar libro.");
					System.out.println("2.- Transferir libro.");
					System.out.println("3.- Mostrar libros disponibles.");
					System.out.println("4.- Menu principal.");
					System.out.print("Ingrese una opción: ");
					int opcionUsuario = sc.nextInt();
					sc.nextLine();
					switch (opcionUsuario) {
					case 1: {
						registrarLibro();
						break;
					}
					case 2: {
						transfeirLibro();
						break;
					}
					case 3: {
						imprimirColeccion();
						break;
					}
					case 4: {
						break;
					}
					default:
						System.out.println("Ingrese una opción vÁlida.");
					}
					break;
				}
				case 3: {
					System.out.println("\n SUBMENÉ PRESTAMOS");
					System.out.println("1.- Prestar un libro.");
					System.out.println("2.- Devolver libro.");
					System.out.println("3.- Menu principal.");
					System.out.print("Ingrese una opción: ");
					int opcionUsuario = sc.nextInt();
					sc.nextLine();
					switch (opcionUsuario) {
					case 1: {
						prestarLibro();
						break;
					}
					case 2: {
						devolverLibro();
						break;
					}
					case 3: {
						break;
					}
					default:
						System.out.println("Ingrese una opción valida.");
					}
					break;
				}
				case 4: {
					System.out.println("\n SUBMENÚ SUCURSALES");
					System.out.println("1.- Agregar sucursal.");
					System.out.println("2.- Mostrar sucursales.");
					System.out.println("3.- Mostrar usuarios sucursal.");
					System.out.println("4.- Menu principal.");
					System.out.print("Ingrese una opción: ");
					int opcionUsuario = sc.nextInt();
					sc.nextLine();
					switch (opcionUsuario) {
					case 1: {
						agregarSucursal();
						break;
					}
					case 2: {
						imprimirSucursales();
						break;
					}
					case 3: {
						imprimirUsuariosSucursal();
						break;
					}
					case 4: {
						break;
					}

					default:
						System.out.println("Ingrese una opción valida.");
					}
					break;
				}

				case 5: {
					System.out.println("\n SUBMENÚ BÚSQUEDA Y REPORTES");
					System.out.println("1.- Buscar libro por titulo.");
					System.out.println("2.- Buscar libro por autor.");
					System.out.println("3.- Buscar libro por genero.");
					System.out.println("4.- Libros mas prestados.");
					System.out
							.println("5.- Usuarios con mas prestamos activos.");
					System.out.println("6.- Listado de prestamos vencidos.");
					System.out.println("7.- Menu principal.");
					System.out.print("Ingrese una opción: ");
					int opcionUsuario = sc.nextInt();
					sc.nextLine();
					switch (opcionUsuario) {
					case 1, 2, 3: {
						buscarLibro(opcionUsuario);
						break;
					}
					case 4: {
						librosMasPrestados();
						break;
					}
					case 5: {
						mostrarUsuariosMasPrestamosActivos();
						break;
					}

					case 6: {
						mostrarPrestamosVencidos();
						break;
					}
					case 7: {
						break;
					}
					default:
						System.out.println("Ingrese una opción válida.");
					}
					break;
				}
				default:
					System.out.println("Ingrese una opción válida.");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"⚠️ Entrada inválida. Debe ingresar un número.");
				sc.nextLine();
			}
		} while (true);
	}

	/**
	 * Muestra los libros más prestados en una sucursal específica, ordenados
	 * por cantidad de préstamos.
	 */
	public static void librosMasPrestados() {
		Sucursal sucursal = elegirSucursal();
		if (sucursal == null) {
			return;
		}

		ArrayList<Libro> libros = new ArrayList<>(
				sucursal.getColeccion().keySet());

		libros.sort((l1, l2) -> Integer.compare(l2.getConteoPrestamos(),
				l1.getConteoPrestamos()));

		System.out.println("Libros más prestados en la sucursal "
				+ sucursal.getNombre() + ":");
		for (Libro libro : libros) {
			System.out.printf("- %s (Prestado %d veces)\n", libro.getTitulo(),
					libro.getConteoPrestamos());
		}
	}

	/**
	 * Muestra los usuarios con más préstamos activos, desde 5 hasta 1.
	 */
	public static void mostrarUsuariosMasPrestamosActivos() {

		for (int i = 5; i > 0; i--) {
			int numeroPrestamos = i;
			for (Usuario usuario : usuarios) {
				if (usuario.getPrestamosActivos().size() == numeroPrestamos) {
					System.out.println(
							usuario.getNombre() + "\t" + numeroPrestamos);
				}
			}
		}

	}

	/**
	 * Muestra todos los préstamos vencidos según la fecha actual del sistema.
	 */
	public static void mostrarPrestamosVencidos() {
		LocalDate fechaActual = LocalDate.now();
		boolean encontrado = false;
		for (Prestamo prestamo : prestamos) {
			if (prestamo.estaVencido(fechaActual)) {
				System.out.println(prestamo.toString());
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No hay libros vencidos.");
		}

	}

	/**
	 * Permite buscar libros dentro de una sucursal seleccionada por título,
	 * autor o género. Muestra el estado del libro (Disponible u Ocupado) junto
	 * con su información detallada.
	 *
	 * @param opcion Indica el tipo de búsqueda: 1 = título, 2 = autor, 3 =
	 *               género
	 */
	public static void buscarLibro(int opcion) {
		boolean encontrado = false;
		Sucursal sucursal = elegirSucursal();
		if (sucursal == null) {
			return;
		}
		switch (opcion) {
		case 1: {
			System.out.print("Ingrese el titulo: ");
			String titulo = sc.nextLine();
			for (Libro libro : sucursal.getColeccion().keySet()) {
				if (libro.getTitulo().equalsIgnoreCase(titulo)) {
					String estado = sucursal
							.disponibleUOcupado(libro.getIsbn());
					System.out.printf("%-10s\t%s\t%s\n", estado, "->",
							libro.toString());
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("Libro no encontrado.");
			}
			break;
		}
		case 2: {
			System.out.print("Ingrese el autor: ");
			String autor = sc.nextLine();
			for (Libro libro : sucursal.getColeccion().keySet()) {
				if (libro.getAutor().equalsIgnoreCase(autor)) {
					String estado = sucursal
							.disponibleUOcupado(libro.getIsbn());
					System.out.printf("%-10s\t%s\t%s\n", estado, "->",
							libro.toString());
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Autor no encontrado.");
			}
			break;
		}
		case 3: {
			System.out.print("Ingrese el género: ");
			String genero = sc.nextLine();
			for (Libro libro : sucursal.getColeccion().keySet()) {
				if (libro.getGenero().equalsIgnoreCase(genero)) {
					String estado = sucursal
							.disponibleUOcupado(libro.getIsbn());

					System.out.printf("%-10s\t%s\t%s\n", estado, "->",
							libro.toString());
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Género no encontrado.");
			}
			break;
		}
		}

	}

	/**
	 * Permite devolver un libro prestado, actualizando disponibilidad y
	 * eliminando el préstamo activo.
	 */
	public static void devolverLibro() {
		Usuario usuario = buscarUsuario();
		if (usuario == null) {
			return;
		}
		if (usuario.getPrestamosActivos().isEmpty()) {
			System.out.println("El usuario no tiene prestamos activos");
			return;
		}
		Sucursal sucursal = usuario.getSucursalAfiliado();
		imprimirLibrosPrestadosUsuario(usuario);
		System.out.print("Ingrese el ISBN del libro que desea devolver: ");
		String isbn = sc.nextLine();
		Libro libro = new Libro();
		Prestamo prestamoActual = new Prestamo();
		for (Prestamo prestamo : prestamos) {
			if (prestamo.getLibro().getIsbn().equals(isbn)) {
				libro = prestamo.getLibro();
				prestamoActual = prestamo;
			}
		}
		prestamos.remove(prestamoActual);
		usuario.eliminarPrestamo(prestamoActual);
		sucursal.devolverLibro(libro);
		System.out.println("Libro devuelto.");

	}

	/**
	 * Imprime todos los libros actualmente prestados a un usuario.
	 *
	 * @param usuario Usuario del cual se desea mostrar sus préstamos activos
	 */
	public static void imprimirLibrosPrestadosUsuario(Usuario usuario) {
		System.out.println("Titulo\t\tISBN");
		for (Prestamo prestamo : usuario.getPrestamosActivos()) {
			Libro libro = prestamo.getLibro();
			System.out.println(libro.getTitulo() + "\t\t" + libro.getIsbn());
		}
	}

	/**
	 * Solicita el RUT al usuario y busca si existe en el sistema. Muestra un
	 * mensaje si el usuario no es encontrado.
	 *
	 * @return El objeto Usuario si se encuentra, o null si no existe
	 */
	public static Usuario buscarUsuario() {
		System.out.print("Ingrese el RUT del usuario: ");
		String rut = sc.nextLine();
		Usuario usuario = encontrarUsuario(rut);
		if (usuario == null) {
			System.out.println("⚠️ Usuario no encontrado.");
			return null;
		}
		return usuario;
	}

	/**
	 * Permite prestar un libro a un usuario, validando disponibilidad y límite
	 * de préstamos.
	 */
	public static void prestarLibro() {
		LocalDate fechaActual = LocalDate.now();
		Usuario usuario = buscarUsuario();
		if (!usuario.puedePedirPrestado()) {
			System.out.println("⚠️ El usuario ya tiene 5 préstamos activos.");
			return;
		}
		Sucursal sucursal = usuario.getSucursalAfiliado();
		System.out.print("Ingrese el ISBN del libro: ");
		String isbn = sc.nextLine();
		if (!sucursal.contieneLibro(isbn) || !sucursal.estaDisponible(isbn)) {
			System.out.println(
					"⚠️ El libro no está disponible en esta sucursal.");
			return;
		}

		Libro libro = sucursal.buscarLibroPorIsbn(isbn);
		for (Prestamo prestamo : usuario.getPrestamosActivos()) {
			if (prestamo.getLibro().equals(libro)) {
				System.out.println("⚠️ El usuario ya tiene este libro.");
				return;
			}
		}
		prestarLibro(libro, usuario, sucursal, fechaActual);
		System.out.println("Préstamo realizado.");
	}

	/**
	 * Realiza el proceso completo de préstamo: crea el objeto Prestamo y
	 * actualiza las estructuras.
	 */
	public static void prestarLibro(Libro libro, Usuario usuario,
			Sucursal sucursal, LocalDate fechaActual) {
		Prestamo prestamo = new Prestamo(libro, usuario, sucursal, fechaActual);
		prestamos.add(prestamo);
		usuario.agregarPrestamo(prestamo);
		sucursal.prestarLibro(libro);
		libro.aumentarConteoPrestamos();
	}

	/**
	 * Busca un usuario en la lista de usuarios por su RUT.
	 *
	 * @param rut RUT del usuario a buscar
	 * @return El objeto Usuario si se encuentra, o null si no existe
	 */
	public static Usuario encontrarUsuario(String rut) {
		for (Usuario usuario : usuarios) {
			if (usuario.getRut().equals(rut)) {
				Usuario usuarioEncontrado = usuario;
				return usuarioEncontrado;
			}
		}
		return null;
	}

	/**
	 * Permite transferir un libro desde una sucursal a otra, actualizando su
	 * ubicación.
	 */
	public static void transfeirLibro() {
		System.out.println("¿En que sucursal esta el libro?");
		Sucursal sucursalOrigen = elegirSucursal();
		System.out.print("Ingrese el ISBN del libro a transferir: ");
		String isbn = sc.nextLine();
		Libro libro = sucursalOrigen.buscarLibroPorIsbn(isbn);
		if (libro == null) {
			System.out.println(
					"⚠️ El libro no se encontró en la sucursal seleccionada.");
			return;
		}
		System.out.println("¿A que sucursal quiere transferir el libro?");
		Sucursal nuevaSucursal = elegirSucursal();
		libro.transferirLibro(nuevaSucursal); // Cambia sucursal del libro
		nuevaSucursal.agregarLibro(libro); // Agrega libro a nueva sucursal
		sucursalOrigen.eliminarLibro(libro); // Elimina libro de antigua
												// sucursal
		System.out.println(
				"Libro transferido a la sucursal " + nuevaSucursal.getNombre());
	}

	/**
	 * Muestra al usuario todas las sucursales disponibles y le permite
	 * seleccionar una.
	 *
	 * @return La sucursal seleccionada, o null si no hay sucursales disponibles
	 */
	public static Sucursal elegirSucursal() {
		imprimirSucursales();
		if (sucursales.isEmpty()) {
			return null;
		}
		System.out.print("Elija la sucursal: ");
		int sucursalSeleccionada = sc.nextInt();
		sc.nextLine();
		Sucursal sucursal = sucursales.get(sucursalSeleccionada - 1);
		return sucursal;
	}

	/**
	 * Imprime todos los libros disponibles en una sucursal seleccionada por el
	 * usuario.
	 */
	public static void imprimirColeccion() {
		Sucursal sucursal = elegirSucursal();
		System.out.println(sucursal.listarLibrosDisponibles());
	}

	/**
	 * Permite registrar un nuevo libro en una o más sucursales.
	 */
	public static void registrarLibro() {
		System.out.print("Ingrese el titulo del libro: ");
		String titulo = sc.nextLine();
		System.out.print("Ingrese el autor: ");
		String autor = sc.nextLine();
		System.out.print("Ingrese ISBN: ");
		String isbn = sc.nextLine();
		System.out.print("Ingrese año: ");
		int anio = sc.nextInt();
		sc.nextLine();
		System.out.print("Ingrese genero: ");
		String genero = sc.nextLine();
		Sucursal sucursalOrigen;
		if (!sucursales.isEmpty()) {
			System.out.println("Elija sucursal de origen: ");
			imprimirSucursales();
			int sucursalSeleccionada = sc.nextInt();
			sc.nextLine();
			sucursalOrigen = sucursales.get(sucursalSeleccionada - 1);
		} else {
			System.out.println("Agregue una sucursal.");
			agregarSucursal();
			sucursalOrigen = sucursales.get(0);
		}

		if (sucursalOrigen.contieneLibro(isbn)) {
			System.out.println(
					"⚠️ El libro ya existe en la sucursal seleccionada. No se agregó.");
		} else {
			Libro libro = new Libro(titulo, autor, isbn, anio, genero,
					sucursalOrigen);
			sucursalOrigen.agregarLibro(libro);
			System.out.println("Libro agregado a la sucursal "
					+ sucursalOrigen.getNombre());
		}
		do {

			System.out.println("¿Desea agregar el libro a otra sucursal mas?");
			System.out.println("1.- Si");
			System.out.println("2.- No.");
			int opcion = sc.nextInt();
			sc.nextLine();
			if (opcion != 1) {
				break;
			} else {
				System.out.println("Elija sucursal de origen: ");
				imprimirSucursales();
				int sucursalSeleccionada = sc.nextInt();
				sc.nextLine();
				if (sucursalSeleccionada > sucursales.size()) {
					System.out.println("Opción Invalida");
					continue;
				}
				Sucursal otraSucursal = sucursales
						.get(sucursalSeleccionada - 1);
				if (otraSucursal.contieneLibro(isbn)) {
					System.out.println(
							"⚠️ El libro ya existe en esa sucursal. No se agregó.");
				} else {
					Libro copiaLibro = new Libro(titulo, autor, isbn, anio,
							genero, otraSucursal);
					otraSucursal.agregarLibro(copiaLibro);
					System.out.println("Libro agregado a la sucursal "
							+ otraSucursal.getNombre());
				}
			}
		} while (true);

	}

	/**
	 * Llena el sistema con datos de prueba: sucursales, usuarios, libros y
	 * préstamos. Útil para testeo sin ingresar datos manualmente.
	 */
	public static void llenarDatosPrueba() {
		// Agregar sucursales de prueba
		Sucursal sucursal1 = new Sucursal("Catamarca", "Salvado 3015",
				sucursales.size() + 1);
		sucursales.add(sucursal1);
		Sucursal sucursal2 = new Sucursal("Bustamante", "Poniente 432",
				sucursales.size() + 1);
		sucursales.add(sucursal2);

		// Agregar usuarios de prueba
		Usuario usuario1 = new Usuario("111", "Manuel Morales",
				"correo@gmail.com", sucursal1);
		usuarios.add(usuario1);
		Usuario usuario2 = new Usuario("22.222.222-2", "Felipe Acosta",
				"correito@hotmail.com", sucursal2);
		usuarios.add(usuario2);
		Usuario usuario3 = new Usuario("13.333.333-4", "Laura Herrera",
				"laura@mail.com", sucursal1);
		usuarios.add(usuario3);
		Usuario usuario4 = new Usuario("4.444.444-4", "Javiera Pinto",
				"javip@mail.com", sucursal2);
		usuarios.add(usuario4);

		// Agregar libros a sucursal1
		Libro libro1 = new Libro("1984", "George Orwell", "978-0451524935",
				1949, "Fábula", sucursal1);
		Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry",
				"978-0156012195", 1943, "Fábula", sucursal1);
		Libro libro3 = new Libro("Cien años de soledad",
				"Gabriel García Márquez", "978-0307474728", 1967,
				"Realismo mágico", sucursal1);
		Libro libro7 = new Libro("Crónica de una muerte anunciada",
				"Gabriel García Márquez", "978-8497592208", 1981,
				"Realismo mágico", sucursal1);
		Libro libro8 = new Libro("Rebelión en la granja", "George Orwell",
				"978-8445079260", 1945, "Fábula", sucursal1);

		sucursal1.agregarLibro(libro1);
		sucursal1.agregarLibro(libro2);
		sucursal1.agregarLibro(libro3);
		sucursal1.agregarLibro(libro7);
		sucursal1.agregarLibro(libro8);

		// Agregar libros a sucursal2
		Libro libro4 = new Libro("Rayuela", "Julio Cortázar", "978-0307474729",
				1963, "Narrativa", sucursal2);
		Libro libro5 = new Libro("Don Quijote de la Mancha",
				"Miguel de Cervantes", "978-8491051068", 1605, "Clásico",
				sucursal2);
		Libro libro6 = new Libro("La sombra del viento", "Carlos Ruiz Zafón",
				"978-8408172176", 2001, "Misterio", sucursal2);
		Libro libro9 = new Libro("Marina", "Carlos Ruiz Zafón",
				"978-8408087692", 1999, "Misterio", sucursal2);
		Libro libro10 = new Libro("Los detectives salvajes", "Roberto Bolaño",
				"978-8433963872", 1998, "Narrativa", sucursal2);

		sucursal2.agregarLibro(libro4);
		sucursal2.agregarLibro(libro5);
		sucursal2.agregarLibro(libro6);
		sucursal2.agregarLibro(libro9);
		sucursal2.agregarLibro(libro10);

		// Crear 10 préstamos
		prestarLibro(libro1, usuario1, sucursal1,
				LocalDate.parse("2025-07-11"));
		prestarLibro(libro2, usuario1, sucursal1,
				LocalDate.parse("2025-07-15"));
		prestarLibro(libro3, usuario2, sucursal2,
				LocalDate.parse("2025-06-16"));
		prestarLibro(libro4, usuario2, sucursal2,
				LocalDate.parse("2025-07-17"));
		prestarLibro(libro5, usuario3, sucursal2,
				LocalDate.parse("2025-07-18"));
		prestarLibro(libro6, usuario3, sucursal2,
				LocalDate.parse("2025-06-19"));
		prestarLibro(libro10, usuario4, sucursal2,
				LocalDate.parse("2025-06-23"));

		System.out.println("Datos de prueba cargados con éxito.");
	}

	/**
	 * Permite cambiar la sucursal de un usuario ya registrado.
	 */
	public static void cambiarUsuarioSucursal() {
		if (!usuarios.isEmpty()) {
			System.out.print("Ingrese el RUT del usuario a cambiar: ");
			String rut = sc.nextLine();

			Usuario usuarioEncontrado = null;

			for (Usuario usuario : usuarios) {
				if (usuario.getRut().equals(rut)) {
					usuarioEncontrado = usuario;
					break;
				}
			}
			if (usuarioEncontrado == null) {
				System.out.println("Usuario no encontrado.");
				return;
			}
			System.out.println("Elija una nueva sucursal: ");
			Sucursal nuevaSucursal = elegirSucursal();
			if (nuevaSucursal == usuarioEncontrado.getSucursalAfiliado()) {
				System.out.println("El usuario ya pertenece a esa sucursal.");
				return;
			}
			usuarioEncontrado.cambiarSucursal(nuevaSucursal);
			System.out.println("Usuario cambiado con éxito.");
		} else {
			System.out.println("No existen usuarios. Agregar usuarios.");
		}

	}

	/**
	 * Muestra todos los usuarios afiliados a una sucursal específica.
	 *
	 */
	public static void imprimirUsuariosSucursal() {
		Sucursal sucursal = elegirSucursal();
		System.out.println(
				"Listado de usuarios en sucursal " + sucursal.getNombre());
		for (Usuario usuario : usuarios) {
			if (usuario.getSucursalAfiliado().equals(sucursal)) {
				System.out.println(usuario.toString());
			}
		}
	}

	/**
	 * Permite agregar un nuevo usuario al sistema, validando su RUT y
	 * afiliándolo a una sucursal.
	 */
	public static void agregarUsuario() {
		System.out.print("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese RUT (11222333-4): ");
		String rut = sc.nextLine();
		if (!validarRut(rut)) {
			System.out.println("RUT ingresado es invalido.");
			return;
		}
		System.out.print("Ingrese correo: ");
		String correo = sc.nextLine();
		Sucursal sucursalAfiliado;
		if (!sucursales.isEmpty()) {
			System.out.println("Elija sucursal de afiliación: ");
			sucursalAfiliado = elegirSucursal();
		} else {
			System.out.println("No existen sucursales, agregue una sucursal.");
			agregarSucursal();
			sucursalAfiliado = sucursales.get(0);
		}
		Usuario usuario = new Usuario(rut, nombre, correo, sucursalAfiliado);
		usuarios.add(usuario);
		System.out.println("Usuario ingresado con éxito!");
	}

	/**
	 * Valida un RUT chileno mediante el cálculo del dígito verificador con
	 * módulo 11.
	 *
	 * @param rut RUT ingresado por el usuario
	 * @return true si el RUT es válido, false si no
	 */
	public static boolean validarRut(String rut) {

		if (rut == null || !rut.matches("\\d{7,8}-[0-9Kk]")) {
			return false;
		}
		// =====================================================
		// PASO 1: MULTIPLICACIÓN CON SECUENCIA 2,3,4,5,6,7
		// =====================================================

		int[] multiplicadores = { 2, 3, 4, 5, 6, 7 };
		int suma = 0;
		int j = 0;
		String digitoVerificadorUsuario = null;

		// Recorremos el RUT de derecha a izquierda
		for (int i = rut.length() - 1; i >= 0; i--) {

			if (i == rut.length() - 1) {
				digitoVerificadorUsuario = String.valueOf(rut.charAt(i));

				// Aca se salta el digito verificador y el guión
			} else if (i < rut.length() - 2) {

				int digito = Character.getNumericValue(rut.charAt(i));
				int producto = digito * multiplicadores[j];
				suma += producto;

				// Avanzar al siguiente multiplicador
				j++;
				if (j >= multiplicadores.length) {
					j = 0; // Reiniciar secuencia
				}
			}
		}

		// =====================================================
		// PASO 2: CÁLCULO DEL MÓDULO 11
		// =====================================================

		int resto = suma % 11;
		int resultado = 11 - resto;

		// =====================================================
		// PASO 3: APLICACIÓN DE REGLAS ESPECIALES
		// =====================================================

		String digitoVerificador;

		if (resultado == 11) {
			digitoVerificador = "0";
//			System.out.println("Caso especial: 11 → 0");
		} else if (resultado == 10) {
			digitoVerificador = "K";
//			System.out.println("Caso especial: 10 → K");
		} else {
			digitoVerificador = String.valueOf(resultado);
//			System.out.println("Caso normal: " + resultado);
		}

		if (digitoVerificadorUsuario.equalsIgnoreCase(digitoVerificador)) {

			return true;
		} else {
			return false;
		}

	}

	/**
	 * Permite registrar una nueva sucursal ingresando nombre y dirección.
	 * Asigna automáticamente un código correlativo a la sucursal y la agrega a
	 * la lista.
	 */
	public static void agregarSucursal() {
		System.out.print("Ingrese el nombre de la sucursal: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese dirección: ");
		String direccion = sc.nextLine();
		Sucursal sucursal = new Sucursal(nombre, direccion,
				sucursales.size() + 1);
		sucursales.add(sucursal);
		System.out.println("Sucursal ingresada con éxito!");
	}

	/**
	 * Muestra la lista de sucursales disponibles en el sistema.
	 */
	public static void imprimirSucursales() {
		if (!sucursales.isEmpty()) {
			System.out.printf("%s\t%s\t%s\n", "Código", "Nombre", "Dirección");
			for (Sucursal sucursal : sucursales) {
				System.out.printf("%d\t%s\t%s\n", sucursal.getCodigo(),
						sucursal.getNombre(), sucursal.getDireccion());
			}
		} else {
			System.out.println(
					"No hay sucursales para mostrar. Ingrese sucursales.");
		}

	}

}