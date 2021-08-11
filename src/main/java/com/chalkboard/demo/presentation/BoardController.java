package com.chalkboard.demo.presentation;

import com.chalkboard.demo.application.form.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardController {
    // localhost:8080/board
    @GetMapping("/board")
    public ModelAndView viewBoard(ModelAndView modelAndView){
        modelAndView.setViewName("board"); // ファイルのパスの設定
        modelAndView.addObject("commentForm", new CommentForm()); // Thymeleafにデータを渡す(空のフォームデータ)
        return modelAndView;
    }

    // @PostMappingでPOSTで送信された/boardパスのリクエストを受けている
    @PostMapping("/board")
    public String postComment(@ModelAttribute CommentForm comment){
        return "board";
    }
}
