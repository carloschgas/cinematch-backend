package carloschgas.cinematch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table (name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, unique = true)
    String code;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToMany
    @JoinTable(name = "room_users", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name ="user_id"))

    private Set<UserEntity> users = new HashSet<>();

    public RoomEntity (){
        this.code = UUID.randomUUID().toString().substring(0,5);
    }

    public void setUsersInList(UserEntity user){
        users.add(user);
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
