package com.fastcampus.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map){
        map.addAttribute("articles", List.of()); //List.of()를 사용하여 빈 리스트를 생성
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String article(@PathVariable Long articleId ,ModelMap map){
        map.addAttribute("article","article" ); //TODO: 실제 데이터 넣어주기
        map.addAttribute("articleComments",List.of());

        return "articles/detail";
    }



}