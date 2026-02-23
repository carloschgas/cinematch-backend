package carloschgas.cinematch.DTOs;

import java.util.Set;
import java.util.UUID;

public record CreateRoomRequest(UUID userId, Set<Long> providersId, Integer maxUsers) {
}
