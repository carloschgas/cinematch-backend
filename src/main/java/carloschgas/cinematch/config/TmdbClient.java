package carloschgas.cinematch.config;

import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.DTOs.TmdbResults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TmdbClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${tmdb.api.key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/popular?language=pt-BR";

    public List<MoviesDTO> fetchPopularMovies() {

        String url = BASE_URL + "&api_key=" + apiKey;

        TmdbResults response =
                restTemplate.getForObject(url, TmdbResults.class);

        return response.results();
    }

}
