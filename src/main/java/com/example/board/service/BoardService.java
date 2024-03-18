package com.example.board.service;

import com.example.board.dto.PostForm;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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

    public Post create(PostForm dto) {
        Post post = dto.toEntity();
        if (post.getId() != null) {
            return null;
        }
        if (post.getUsername() == null) {
            return null;
        }
        return postRepository.save(post);
    }

    public Post update(Long id, PostForm dto) {
        Post post = dto.toEntity();
        log.info("id: {}, post: {}", id, post.toString());

        Post target = postRepository.findById(id).orElse(null);
        if (target == null || id != post.getId()) {
            log.info("잘못된 요청입니다. id: {}, post: {}", id, post.toString());
            return null;
        }

        target.patch(post);
        Post updated = postRepository.save(target);
        return updated;
    }

    public Post delete(Long id) {
        Post target = postRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        postRepository.delete(target);
        return target;
    }
}
