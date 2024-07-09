package com.alura.literalura.servicio;

import com.alura.literalura.modelo.Libro;
import com.alura.literalura.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private GutendexClient gutendexClient;

    public List<Libro> buscarPorTitulo(String titulo){
        return libroRepositorio.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Libro> listarTodosLosLibros(){
        return libroRepositorio.findAll();
    }

    public List<Libro> buscarPorIdioma(String idioma){
        return libroRepositorio.findByIdioma(idioma);
    }

    public void guardarLibro(Libro libro){
        libroRepositorio.save(libro);
    }

    public List<Libro> buscarLibroEnAPI(String titulo){
        return gutendexClient.buscarLibros(titulo);
    }
}
