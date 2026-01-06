package carloschgas.cinematch.services;

import carloschgas.cinematch.entity.MovieLike;
import carloschgas.cinematch.repository.LikeRepo;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepo likeRepo;

    public LikeService(LikeRepo likeRepo){
        this.likeRepo = likeRepo;
    }

    public MovieLike like(){
        return
    }
}
