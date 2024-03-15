package com.fastcampus.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//이거는 억지로 테스트 한거랑 똑같다 @WebMvcTest를 안쓰고 @SpringBootTest를 쓰면 test가 가능하기는 하다
//@WebMvcTest //WebMvcTest는 슬라이스 테스트이다  컨트롤러 외의 빈드를 로드하지 않는다, 컨트롤러와 연관된 내용을 최소한으로 읽는다


@Disabled("Spring Data Rest 통합테스트는 불필요하므로 제외시킴") //해당 테스트 클래스에 밑에 있는 모든 유닛 테스트들은 그 메소드들은 실행되지 않게 된다
@Transactional
@DisplayName("Data Rest - Api 테스트")
@AutoConfigureMockMvc
@SpringBootTest // mock을 써야만 원하는 내용들을 다 불러온다
public class DataRestTest {

    private final MockMvc mvc; //MockMvc를 사용할려면 위에 @AutoConfigureMockMvc이 어노테이션을 걸어줘야 한다

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api]게시글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticles_thenReturnsJsonResponse() throws Exception {
        mvc.perform(get("/api/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP 응답 상태가 OK(200)인지 확인
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @DisplayName("[api]게시글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticle_thenReturnJsonResponse() throws Exception {
        //given


        //when & then
        mvc.perform(get("/api/articles/1")) //test데이터가 존재 한다는 가정하에/1을 넣음
                .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP 응답 상태가 OK(200)인지 확인
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));

    }


    @DisplayName("[api]  댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingComments_thenReturnsArticleCommentsJsonResponse() throws Exception {
        //given


        //when & then
        mvc.perform(get("/api/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP 응답 상태가 OK(200)인지 확인
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @DisplayName("[api]  댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingComment_thenReturnsArticleCommentJsonResponse() throws Exception {
        //given


        //when & then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP 응답 상태가 OK(200)인지 확인
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));

    }


}
