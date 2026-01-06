package carloschgas.cinematch.DTOs;

import java.time.LocalDateTime;

public record ErrorDTO(int status, String message, LocalDateTime timestamp) {
}
