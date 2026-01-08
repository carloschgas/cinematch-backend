package carloschgas.cinematch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter

@Entity
public class MovieLike {
@Id
@GeneratedValue
    private UUID id;

    private Long movieId; // id do TMDB

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private RoomEntity room;

    private boolean liked = true; // true = like, false = dislike

    public MovieLike(long l, UserEntity userWhoLiked, RoomEntity room) {
        this.movieId = l;
        this.user = userWhoLiked;
        this.room = room;
    }

    public MovieLike(){}
}