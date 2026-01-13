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

    private static final String POPULAR_URL =
            "https://api.themoviedb.org/3/movie/popular";

    private static final String MOVIE_URL =
            "https://api.themoviedb.org/3/movie";

    private static final String DISCOVER_MOVIE_URL =
            "https://api.themoviedb.org/3/discover/movie";

    public List<MoviesDTO> fetchPopularMovies() {
        String url = POPULAR_URL +
                "?language=pt-BR&api_key=" + apiKey;

        TmdbResults response =
                restTemplate.getForObject(url, TmdbResults.class);

        return response.results();
    }

    public MoviesDTO getMovieById(Long movieID) {
        String url = MOVIE_URL +
                "/" + movieID +
                "?language=pt-BR&api_key=" + apiKey;

        return restTemplate.getForObject(url, MoviesDTO.class);
    }


    public List<MoviesDTO> getMoviesByStreaming(List<Long> streamingID){

        String providers = streamingID.stream().map(String::valueOf).reduce((a,b)->a+"|"+b).orElse("");

        String url = DISCOVER_MOVIE_URL +
                "?api_key=" + apiKey +
                "&language=pt-BR" +
                "&watch_region=BR" +
                "&with_watch_providers=" + providers;


        TmdbResults response =
                restTemplate.getForObject(url, TmdbResults.class);

        return response.results();
    }

}
