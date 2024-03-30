package com.example.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.board.entity.Comment;
import com.example.board.entity.Post;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByPostId() {
        Long postId = 4L;
        List<Comment> comments = commentRepository.findByPostId(postId);
        Post article = new Post(4L, "당신의 인생 영화는?", "관리자1", "댓글로 알려주세요");
        Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
        Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
        Comment c = new Comment(3L, article, "Choi", "쇼생크 탈출");

        List<Comment> expected = Arrays.asList(a, b, c);
        assertEquals(expected.toString(), comments.toString(), "4번의 모든 댓글을 출력");
    }

    @Test
    void findByNickname() {
        // 1. 입력 데이터 준비
        String nickname = "Park";
        // 2. 실제 데이터
        List<Comment> comments = commentRepository.findByNickname(nickname);
        // 3. 예상 데이터
        Comment a = new Comment(1L, new Post(4L, "당신의 인생 영화는?","관리자1", "댓글로 알려주세요"), nickname, "굿 윌 헌팅");
        Comment b = new Comment(4L, new Post(5L, "당신의 소울 푸드는?", "관리자1", "댓글로 알려주세요"), nickname, "치킨");
        Comment c = new Comment(7L, new Post(6L, "당신의 취미는?", "관리자1", "댓글로 알려주세요"), nickname, "조깅");
        List<Comment> expected = Arrays.asList(a, b, c);
        // 4. 비교 및 검증
        assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력");
    }
}