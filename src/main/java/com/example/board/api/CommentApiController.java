package com.example.board.api;

import com.example.board.dto.CommentDto;
import com.example.board.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    // 1. 댓글 조회
    @GetMapping("/api/board/{postId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long postId) {
        List<CommentDto> dtos = commentService.comments(postId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
