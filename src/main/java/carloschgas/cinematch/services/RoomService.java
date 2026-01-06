package carloschgas.cinematch.services;

import carloschgas.cinematch.entity.RoomEntity;
import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepository repository;
    private final UserService userService;

    public RoomService (RoomRepository repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }

    public RoomEntity createRoom(UUID user_id){
        RoomEntity newRoom = new RoomEntity();

        UserEntity initialUser = userService.findUserByID(user_id);

        repository.save(newRoom);

        addUser(initialUser, newRoom.getCode());

        return newRoom;

    }

    public void addUser(UserEntity user, String roomCode){
        RoomEntity room = repository.findByCode(roomCode);
        room.setUsersInList(user);
        repository.save(room);
        System.out.println("Added user" + user.getName() + "in room" + roomCode);
    }

    public RoomEntity getRoom(String roomCode){
        return repository.findByCode(roomCode);
    }

}
