package com.alura.literalura;

import com.alura.literalura.modelo.Libro;
import com.alura.literalura.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroServicio libroServicio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run (String... args){
		Scanner scanner = new Scanner(System.in);
		Boolean continuar = true;

		while (continuar){
			mostrarMenuPrincipal();
			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion){
				case 1:
					buscarLibroPorTitulo(scanner);
					break;

				case 2:
					listarTodosLosLibros();
					break;

				case 3:
					listarAutoresRegistrados();
					break;

				case 4:
					listarAutoresVivos(scanner);
					break;

				case 5:
					listarLibrosPorIdioma(scanner);
					break;

				case 6:
					continuar = false;
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida. Por favor, intenta de nuevo.");

			}
		}

		scanner.close();
	}

	private void mostrarMenuPrincipal() {
		System.out.println("\n--- Menú Principal ---");
		System.out.println("1. Buscar libro por título");
		System.out.println("2. Listar todos los libros");
		System.out.println("3. Listar autores registrados");
		System.out.println("4. Listar autores vivos en un determinado año");
		System.out.println("5. Listar libros por idioma");
		System.out.println("6. Salir");
		System.out.print("Seleccione una opción: ");
	}

	private void buscarLibroPorTitulo(Scanner scanner) {
		System.out.print("Ingrese el título del libro: ");
		String titulo = scanner.nextLine();
		List<Libro> libros = libroServicio.buscarPorTitulo(titulo);
		if (libros.isEmpty()) {
			List<Libro> librosAPI = libroServicio.buscarLibroEnAPI(titulo);
			if (librosAPI.isEmpty()) {
				System.out.println("Libro no encontrado.");
			} else {
				System.out.println("Libros encontrados en la API:");
				for (Libro libro : librosAPI) {
					System.out.println(libro);
				}
			}
		} else {
			System.out.println("Libros encontrados:");
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		}
	}

	private void listarTodosLosLibros() {
		List<Libro> libros = libroServicio.listarTodosLosLibros();
		System.out.println("Lista de todos los libros:");
		for (Libro libro : libros) {
			System.out.println(libro);
		}
	}

	private void listarAutoresRegistrados() {
		// Implementar lógica para listar autores registrados
	}

	private void listarAutoresVivos(Scanner scanner) {
		// Implementar lógica para listar autores vivos en un determinado año
	}

	private void listarLibrosPorIdioma(Scanner scanner) {
		System.out.print("Ingrese el idioma de los libros: ");
		String idioma = scanner.nextLine();
		List<Libro> libros = libroServicio.buscarPorIdioma(idioma);
		System.out.println("Libros en idioma " + idioma + ":");
		for (Libro libro : libros) {
			System.out.println(libro);
		}
	}

}
