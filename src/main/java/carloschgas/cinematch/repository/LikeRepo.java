package carloschgas.cinematch.repository;

import carloschgas.cinematch.entity.MovieLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepo extends JpaRepository <MovieLike, UUID> {
}
