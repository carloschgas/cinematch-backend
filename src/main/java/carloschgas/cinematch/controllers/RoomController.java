package carloschgas.cinematch.controllers;


import carloschgas.cinematch.DTOs.JoinRoomRequest;
import carloschgas.cinematch.entity.RoomEntity;
import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.services.RoomService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:5173")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomEntity> createRoom(@RequestParam UUID user_id){
        return new ResponseEntity<>(service.createRoom(user_id), HttpStatus.CREATED);
    }

    @GetMapping("/{roomCode}")
    public ResponseEntity<RoomEntity> getRoom(@PathVariable String roomCode){
        return new ResponseEntity<>(service.getRoom(roomCode), HttpStatus.OK);
    }

    @PostMapping("/join/{roomCode}")
    public ResponseEntity<RoomEntity> joinRoom(@PathVariable String roomCode, @RequestBody JoinRoomRequest request){
        return new ResponseEntity<>(service.joinRoom(request.userID(), roomCode), HttpStatus.OK);
    }

}
