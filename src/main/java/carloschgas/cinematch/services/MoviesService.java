package carloschgas.cinematch.services;

import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.config.TmdbClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final TmdbClient OmbdbClient;

    public MoviesService(TmdbClient ombdbClient) {
        this.OmbdbClient = ombdbClient;
    }

    public List<MoviesDTO> searchMovies() {
        return OmbdbClient.fetchPopularMovies();
    }
}