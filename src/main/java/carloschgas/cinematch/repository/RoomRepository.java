package carloschgas.cinematch.repository;

import carloschgas.cinematch.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

     RoomEntity findByCode(String code);
}
