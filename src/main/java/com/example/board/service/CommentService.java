package com.example.board.service;

import com.example.board.dto.CommentDto;
import com.example.board.entity.Comment;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<CommentDto> comments(Long postId) {
        return commentRepository.findByPostId(postId)
                .stream()
                .map(CommentDto::createCommentDto)
                .collect(Collectors.toList());
    }
}
