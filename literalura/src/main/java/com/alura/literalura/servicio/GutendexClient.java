package com.alura.literalura.servicio;

import com.alura.literalura.modelo.Libro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GutendexClient {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books?search=";

    public List<Libro> buscarLibros(String titulo){
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL +  titulo;

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");

        List<Libro> libros = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Libro libro = new Libro();
            libro.setTitulo((String) result.get("title"));
            libro.setAutor(((List<Map<String, String>>) result.get("authors")).get(0).get("name"));
            libro.setIdioma(((List<String>) result.get("languages")).get(0));
            libros.add(libro);
        }

        return libros;
    }

}


}
