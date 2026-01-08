package carloschgas.cinematch.services;

import carloschgas.cinematch.DTOs.LikeRequest;
import carloschgas.cinematch.entity.MovieLike;
import carloschgas.cinematch.entity.RoomEntity;
import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.repository.LikeRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class LikeService {

    private final LikeRepo likeRepo;
    private final UserService userService;
    private final RoomService roomService;

    public LikeService(LikeRepo likeRepo, UserService userService, RoomService roomService){
        this.likeRepo = likeRepo;
        this.userService = userService;
        this.roomService = roomService;
    }

    public boolean likeMovie(LikeRequest request){


        UserEntity userWhoLiked = userService.findUserByID(request.userID());
        RoomEntity room = roomService.findByCode(request.roomCode());
        System.out.println(userWhoLiked.getId());
        MovieLike newLike = new MovieLike(request.movieId(), userWhoLiked, room);

        likeRepo.save(newLike);
        System.out.println(newLike.getMovieId());

        return isMatch(request.movieId(), room);


    }


    public boolean isMatch(Long movieId, RoomEntity room) {

        int totalUsers = room.getUsers().size();

        // busca apenas likes desse filme nessa sala
        List<MovieLike> likes = likeRepo.findByRoomAndMovieIdAndLikedTrue(
                room,
                movieId
        );

        return likes.size() == totalUsers;
    }

    public List<Long> getMatchedMovies(String roomCode){

        RoomEntity room = roomService.findByCode(roomCode);
        int totalUsers = room.getUsers().size();

        List<MovieLike> likes = likeRepo.findByRoom(room);

        Map<Long, Integer> likesByMovie = new HashMap<>();
        List<Long> matchedMovies = new ArrayList<>();

        for (MovieLike like : likes){

            if (!like.isLiked()) continue;

            Long movieId = like.getMovieId();
            likesByMovie.put(
                    movieId,
                    likesByMovie.getOrDefault(movieId, 0) + 1
            );
        }

        for (Map.Entry<Long, Integer> entry : likesByMovie.entrySet()){
            if (entry.getValue() == totalUsers){
                System.out.println("MATCH MOVIE ID:"+ entry);
                matchedMovies.add(entry.getKey());
            }
        }

        return matchedMovies;
    }



}
