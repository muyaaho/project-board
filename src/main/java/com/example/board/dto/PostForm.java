package com.example.board.dto;

import com.example.board.entity.Post;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PostForm {
    private Long id;
    private String name;
    private String title;
    private String content;

    public Post toEntity() {
        return new Post(id, name, title, content);
    }
}
