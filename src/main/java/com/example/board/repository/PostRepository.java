package com.example.board.repository;

import com.example.board.entity.Post;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Override
    ArrayList<Post> findAll();
}
