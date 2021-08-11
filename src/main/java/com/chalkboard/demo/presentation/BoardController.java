package com.chalkboard.demo.presentation;

import com.chalkboard.demo.application.form.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    // @Validated でバリデーションの実行
    // BindingResult でバリデーションの結果を受け取る
    @PostMapping("/board")
    public ModelAndView postComment(
            @Validated @ModelAttribute CommentForm comment,
            BindingResult bindingResult) {
        // エラーがあれば、入力を保持したままもとの入力フォームを表示
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/board");
            modelAndView.addObject("commentForm", comment);
            return modelAndView;
        }
        //POSTリクエストを再送しないよう、リダイレクト
        return new ModelAndView("redirect:/board");
    }
}
