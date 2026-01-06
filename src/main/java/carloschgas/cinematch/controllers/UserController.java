package carloschgas.cinematch.controllers;


import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/u")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestParam String name){

        return new ResponseEntity<>(service.createUser(name), HttpStatus.CREATED);
    }
}
