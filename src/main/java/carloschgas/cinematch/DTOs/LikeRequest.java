package carloschgas.cinematch.DTOs;

import java.util.UUID;

public record LikeRequest(long movieId, UUID userID, String roomCode) {
}
