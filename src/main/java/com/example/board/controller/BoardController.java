package com.example.board.controller;

import com.example.board.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {

    @GetMapping("/board/new")
    public String newArticleForm() {
        return "board/new";
    }

    @PostMapping("/board/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        return "";
    }
}
