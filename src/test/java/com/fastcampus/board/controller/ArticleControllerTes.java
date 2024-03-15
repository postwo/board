package com.fastcampus.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - 게시글")
@WebMvcTest(ArticleController.class) // 테스트 대상이 되는 컨트롤러만 빈으로 읽어드리는 것이 가능하다 (컨트롤러가 여러개 있을때 이클래스만 읽어들일수 있다)
class ArticleControllerTest {

    private final MockMvc mvc;

    //@Autowired 테스트 패키지에 있는 애는 오토 와이어들을 생성자가 하나만 있을 때 생략할수 없다
    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    // @Disabled("구현중") //각 단위 메소드별로 테스트를 제외 시킨다
    @DisplayName("[view][Get] 게시글 리스트 (게시판) 페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
        //Given

        //when & then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk()) //위 경로 요청하면 200떨어지고
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //text/html;charset=UTF-8   //TEXT_HTML타입으로 보여져야한다
                .andExpect(view().name("articles/index"))// 뷰 이름은 articles/index에 있어야 하고
                .andExpect(model().attributeExists("articles"));// 키값이 있는지 검사 //articles를 하나 넘겨줘야 한다

    }

    @Disabled("구현중")
    @DisplayName("[view][Get] 게시글 상세 페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticlesView_thenReturnsArticleView() throws Exception {
        //Given

        //when & then
        mvc.perform(get("/articles/1")) // /1=임의로 가짜 아이디를 넣어서 테스트
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail")) // view가 있어야 된다
                .andExpect(model().attributeExists("article"))// 키값이 있는지 검사
                .andExpect(model().attributeExists("articleComments"));//댓글들
    }

    @Disabled("구현중")
    @DisplayName("[view][Get] 게시글 검색 전용 페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
        //Given

        //when & then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
    }



    @Disabled("구현중")
    @DisplayName("[view][Get] 게시글 해시태그 검색 페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView() throws Exception {
        //Given

        //when & then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/hashtag"));
    }

}
