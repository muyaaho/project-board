package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;

    @Column
    private String username;

    @Column
    private String content;

    public void changeNewLine() {
        content = content.replaceAll("\n", "<br>");
    }

    public void patch(Post post) {
        if (post.title != null)
            this.title = post.title;
        if (post.username != null)
            this.username = post.username;
        if (post.content != null)
            this.content = post.content;

    }
}
