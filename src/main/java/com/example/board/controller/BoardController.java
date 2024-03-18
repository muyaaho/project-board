package com.example.board.controller;

import com.example.board.dto.PostForm;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
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
    private PostRepository postRepository;

    @GetMapping("/board/new")
    public String newArticleForm() {
        return "board/new";
    }

    @PostMapping("/board/create")
    public String createArticle(PostForm form) {
        log.info(form.toString());

        Post post = form.toEntity();
        log.info(post.toString());

        Post saved = postRepository.save(post);
        log.info(saved.toString());
        return "redirect:/board/" + saved.getId();
    }

    @GetMapping("/board/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        Post postEntity = postRepository.findById(id).orElse(null);
        postEntity.changeNewLine();
        log.info(String.valueOf(postEntity));
        model.addAttribute("board", postEntity);

        return "board/show";
    }

    @GetMapping(value = {"/board", "/board/"})
    public String index(Model model) {
        List<Post> postEntityList = postRepository.findAll();
        model.addAttribute("postList", postEntityList);
        return "board/index";
    }

    @GetMapping("/board/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Post postEntity = postRepository.findById(id).orElse(null);
        model.addAttribute("post", postEntity);
        return "board/edit";
    }

    @PostMapping("/board/update")
    public String update(PostForm form) {
        log.info(form.toString());
        Post postEntity = form.toEntity();
        log.info(postEntity.toString());

        Post target = postRepository.findById(postEntity.getId()).orElse(null);
        if (target != null) {
            postRepository.save(postEntity);
        }
        return "redirect:/board/" + postEntity.getId();
    }

    @GetMapping("/board/{id}/delete")
    public String delete(@PathVariable Long id) {
        log.info("삭제 요청이 들어왔습니다.");

        Post target = postRepository.findById(id).orElse(null);
        log.info(target.toString());

        if (target != null) {
            postRepository.delete(target);
        }
        return "redirect:/board";
    }
}
