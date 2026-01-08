package carloschgas.cinematch.repository;

import carloschgas.cinematch.entity.MovieLike;
import carloschgas.cinematch.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LikeRepo extends JpaRepository <MovieLike, UUID> {

    List<MovieLike> findByRoomAndMovieIdAndLikedTrue(
            RoomEntity room,
            Long movieId
    );
    List<MovieLike> findByRoom(RoomEntity room);
}
