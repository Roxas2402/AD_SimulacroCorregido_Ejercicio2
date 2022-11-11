package com.cieep;

import modelos.Abonado;
import modelos.Alquiler;
import modelos.Autor;
import modelos.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.LocalDate;

public class Main {

    //TODO: Arreglar el error final
    public static void main(String[] args) {
        Abonado abonado = new Abonado();
        abonado.setNombre("Manolito");
        Autor autor = new Autor();
        Libro libro = new Libro();
        libro.setTitulo("Por qué no dedicarse a la programación");
        libro.setAutor(autor);
        Alquiler alquiler = new Alquiler();
        alquiler.setFecha(Date.valueOf(LocalDate.now()));

        abonado.getAlquileres().add(alquiler);
        libro.getAlquileres().add(alquiler);
        autor.getLibros().add(libro);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(abonado);
        session.persist(autor);
        session.persist(libro);
        session.persist(alquiler);
        session.getTransaction().commit();
        session.close();
    }
}