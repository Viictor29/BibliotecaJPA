package DAO;

import DTO.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaccion = em.getTransaction();

    public List<Libro> listarLibros(){
        List<Libro> listaLibros = em.createQuery("select l from Libro l").getResultList();
        if (listaLibros.isEmpty()){
            return null;
        }
        return listaLibros;
    }

    public void insertarLibro(Libro libro){
        transaccion.begin();
        em.persist(libro);
        transaccion.commit();
    }

    public void eliminarLibro(Libro libro){
        transaccion.begin();
        em.remove(libro);
        transaccion.commit();
    }

    public void actualizarLibro(Libro libro){
        transaccion.begin();
        em.merge(libro);
        transaccion.commit();
    }

    public Libro getLibroIsbn(String isbn){
        Libro libro = em.find(Libro.class, isbn);
        return libro;
    }
}
