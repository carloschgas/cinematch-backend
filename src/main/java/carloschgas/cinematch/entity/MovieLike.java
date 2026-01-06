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

@AllArgsConstructor
@NoArgsConstructor
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

private boolean liked; // true = like, false = dislike
}