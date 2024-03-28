package com.example.board.entity;

import com.example.board.dto.CommentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Post post) {
        if (dto.getId() != null)
            throw new IllegalStateException("댓글 생성 실패, 댓글의 id가 없어야 합니다.");
        if (dto.getPostId() != post.getId())
            throw new IllegalStateException("댓글 생성 실패, 게시글의 id가 잘못됐습니다.");
        return new Comment(dto.getId(),
                post,
                dto.getNickname(),
                dto.getBody());
    }
}
