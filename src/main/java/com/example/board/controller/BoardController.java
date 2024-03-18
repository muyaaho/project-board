package com.example.board.controller;

import com.example.board.dto.PostForm;
import com.example.board.entity.Post;
import com.example.board.repository.ArticleRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/board/new")
    public String newArticleForm() {
        return "board/new";
    }

    @PostMapping("/board/create")
    public String createArticle(PostForm form) {
        log.info(form.toString());

        Post post = form.toEntity();
        log.info(post.toString());

        Post saved = articleRepository.save(post);
        log.info(saved.toString());
        return "redirect:/board/" + saved.getId();
    }

    @GetMapping("/board/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        Post postEntity = articleRepository.findById(id).orElse(null);
        postEntity.changeNewLine();
        log.info(String.valueOf(postEntity));
        model.addAttribute("board", postEntity);

        return "board/show";
    }

    @GetMapping(value = {"/board", "/board/"})
    public String index(Model model) {
        List<Post> postEntityList = articleRepository.findAll();
        model.addAttribute("PostList", postEntityList);
        return "board/index";
    }

    @GetMapping("/board/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Post postEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("post", postEntity);
        return "board/edit";
    }
}
