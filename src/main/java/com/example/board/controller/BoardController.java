package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("/board/new")
    public String newArticleForm() {
        return "board/new";
    }

    @PostMapping("/board/create")
    public String createArticle() {
        return "";
    }
}
