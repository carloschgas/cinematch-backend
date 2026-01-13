package carloschgas.cinematch.controllers;


import carloschgas.cinematch.DTOs.LikeRequest;
import carloschgas.cinematch.DTOs.MoviesDTO;
import carloschgas.cinematch.entity.MovieLike;
import carloschgas.cinematch.services.LikeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/likes")
@CrossOrigin(origins = "http://localhost:5173")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Boolean> like(@RequestBody LikeRequest request){
        boolean isMatch = likeService.likeMovie(request);
        return ResponseEntity.ok(isMatch);
    }

    @GetMapping("/matches/{roomCode}")
    public ResponseEntity<List<MoviesDTO>> getMatches(
            @PathVariable String roomCode
    ) {
        List<MoviesDTO> matches =
                likeService.getMatchedMoviesDetails(roomCode);

        if (matches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(matches);
    }





}
