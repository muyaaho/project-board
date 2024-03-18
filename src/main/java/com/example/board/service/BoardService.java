package com.example.board.service;

import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> index() {
        return postRepository.findAll();
    }

    public Post show(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
