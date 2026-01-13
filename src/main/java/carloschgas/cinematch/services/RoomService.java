package carloschgas.cinematch.services;

import carloschgas.cinematch.entity.RoomEntity;
import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepository repository;
    private final UserService userService;

    public RoomService (RoomRepository repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }

    public RoomEntity createRoom(UUID user_id, Set<Long> providersId, Integer maxUsers){
        RoomEntity newRoom = new RoomEntity();
        newRoom.setMaxUsers(maxUsers);
        newRoom.getProvidersId().addAll(providersId);

        repository.save(newRoom);

        joinRoom(user_id, newRoom.getCode());

        return newRoom;

    }

    public RoomEntity findByCode(String roomCode){
        return repository.findByCode(roomCode);
    }

    public RoomEntity joinRoom(UUID user_id, String roomCode){
        RoomEntity room = repository.findByCode(roomCode);
        UserEntity user = userService.findUserByID(user_id);
        room.setUsersInList(user);

        System.out.println("Added user" + user.getName() + "in room" + roomCode);
        return repository.save(room);
    }

    public Set<UserEntity> getUsers(String roomCode){
        RoomEntity room = findByCode(roomCode);

        return room.getUsers();
    }

    public RoomEntity getRoom(String roomCode){
        return repository.findByCode(roomCode);
    }

}
