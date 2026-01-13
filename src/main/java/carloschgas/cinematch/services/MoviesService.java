package carloschgas.cinematch.services;

import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.config.TmdbClient;
import carloschgas.cinematch.entity.RoomEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final TmdbClient OmbdbClient;
    private final RoomService roomService;

    public MoviesService(TmdbClient ombdbClient, RoomService roomService) {
        this.OmbdbClient = ombdbClient;
        this.roomService = roomService;
    }


    public List<MoviesDTO> getMovies(String roomCode){

        RoomEntity room = roomService.findByCode(roomCode);

        if (room.getProvidersId().size() == 0){
            return getPopularMovies();
        }

        else {
            List<Long> streamingsId = room.getProvidersId().stream().toList();
            return getMoviesByStreaming(streamingsId);
        }

    }

    public List<MoviesDTO> getPopularMovies() {
        return OmbdbClient.fetchPopularMovies();
    }


    public MoviesDTO getMovieByID(Long movie_id){
        return OmbdbClient.getMovieById(movie_id);
    }

    public List<MoviesDTO> getMoviesByStreaming(List<Long> streamingsId){
        return OmbdbClient.getMoviesByStreaming(streamingsId);
    }
}