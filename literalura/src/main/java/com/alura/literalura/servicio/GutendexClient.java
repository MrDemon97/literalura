package com.alura.literalura.servicio;

import com.alura.literalura.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GutendexClient {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books";

    public List<Libro> buscarLibrosPorTitulo(String titulo){
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL + "?search=" + titulo;
        return getLibrosFromAPI(url);
    }

    public List<Libro> listarTodosLosLibros() {
        String url = GUTENDEX_API_URL;
        return getLibrosFromApi(url);
    }

    public List<Libro> listarAutoresRegistrados() {
        String url = GUTENDEX_API_URL + "authors" ;
        return getLibrosFromApi(url);
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL + "?search=" + autor;
        return getLibrosFromAPI(url);
    }





}



