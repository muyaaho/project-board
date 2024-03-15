package com.example.board.dto;

import com.example.board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String name;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, name, title, content);
    }
}
