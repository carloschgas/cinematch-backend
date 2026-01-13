package carloschgas.cinematch.controllers;

import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.services.MoviesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/{roomCode}")
    public List<MoviesDTO> getMovies(@PathVariable String roomCode){
        return moviesService.getMovies(roomCode);
    }




}
