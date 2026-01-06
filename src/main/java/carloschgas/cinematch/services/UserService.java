package carloschgas.cinematch.services;

import carloschgas.cinematch.entity.UserEntity;
import carloschgas.cinematch.exceptions.InvalidUserNameException;
import carloschgas.cinematch.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserEntity createUser(String name){

        if (name == null || name.trim().isEmpty()){
            throw new InvalidUserNameException("Username cannot be null or empty");
        }

        if (name.length() < 3)  {
            throw new InvalidUserNameException("Username must have at least 3 characters");
        }

        UserEntity newUser = new UserEntity(name);
        repository.save(newUser);
        return newUser;
    }

    public UserEntity findUserByID(UUID user_id){
       UserEntity user = repository.findById(user_id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
       return user;
    }
}
