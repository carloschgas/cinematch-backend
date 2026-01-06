package carloschgas.cinematch.controllers;


import carloschgas.cinematch.DTOs.LikeRequest;
import carloschgas.cinematch.entity.MovieLike;
import carloschgas.cinematch.services.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/room/{roomCode}/like")
@CrossOrigin(origins = "http://localhost:5173")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<MovieLike> likeMovie(@RequestParam UUID roomCode, @RequestBody LikeRequest request){
        return new ResponseEntity<>(likeService.like(), HttpStatus.OK)
    }
}
