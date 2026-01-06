package carloschgas.cinematch.controllers;

import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.services.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/movies")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/popular")
    public List<MoviesDTO> searchMovies() {
        return moviesService.searchMovies();
    }
}
