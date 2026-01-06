package carloschgas.cinematch.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MoviesDTO(
        Long id,
        String title,
        @JsonProperty("release_date")
        String releaseDate,
        @JsonProperty("poster_path")
        String posterPath,
        String overview
) {}
