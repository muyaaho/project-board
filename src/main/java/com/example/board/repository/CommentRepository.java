package com.example.board.repository;

import com.example.board.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시글의 모든 댓글 조회
    @Query(value="SELECT * FROM comment WHERE post_id = :postId", nativeQuery = true)
    List<Comment> findByPostId(Long postId);
    // 특정 닉네임의 모든 댓글 조회
    @Query(value="SELECT * FROM comment WHERE nickname = :nickname", nativeQuery = true)
    List<Comment> findByNickname(String nickname);

}
