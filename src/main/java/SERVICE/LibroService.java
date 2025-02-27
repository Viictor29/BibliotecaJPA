package SERVICE;

import DAO.LibroDAO;
import DTO.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibroService {
    Scanner teclado = new Scanner(System.in);
    List<Libro> listaLibrosMemoria = new ArrayList<Libro>();
    LibroDAO libroDAO = new LibroDAO();

    public LibroService() {
        this.libroDAO = new LibroDAO();
        sincronizar();
    }

    public void sincronizar() {
        listaLibrosMemoria = libroDAO.listarLibros();
    }

    public void listarLibrosMemoria() {
        for (Libro libro : listaLibrosMemoria) {
            System.out.println(libro);
        }
    }

    public void añadirLibroMemoria() {
        System.out.println("Introduce ISBN del libro: ");
        String ISBN = teclado.nextLine();
        System.out.println("Introduce titulo del libro: ");
        String titulo = teclado.nextLine();
        System.out.println("Introduce autor del libro: ");
        String autor = teclado.nextLine();
        Libro libro = new Libro(ISBN, titulo, autor);
        libroDAO.insertarLibro(libro);
    }

    public void eliminarLibroMemoria() {
        System.out.println("Introduce el ISBN del libro a eliminar");
        String ISBN = teclado.nextLine();
        if (libroDAO.getLibroIsbn(ISBN) != null) {
            libroDAO.eliminarLibro(libroDAO.getLibroIsbn(ISBN));
        }
    }
}
