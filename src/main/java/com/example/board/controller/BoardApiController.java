package com.example.board.controller;

import com.example.board.dto.PostForm;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import com.example.board.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;
    // GET
    @GetMapping("/api/board")
    public List<Post> index() {
        return boardService.index();
    }
    @GetMapping("/api/board/{id}")
    public Post show(@PathVariable Long id) {
        return boardService.show(id);
    }

    // POST
    @PostMapping("/api/board")
    public ResponseEntity<Post> create(@RequestBody PostForm dto) {
        Post created = boardService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // PATCH
    // DELETE
}
