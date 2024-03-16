package com.fastcampus.board.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@DisplayName("View 컨트롤러 - 인증")
@WebMvcTest //이걸 사용해서 시큐리티가 적용된 상태로 테스트를 해볼수 있다
public class AuthControllerTest {


    private final MockMvc mvc;

    //@Autowired 테스트 패키지에 있는 애는 오토 와이어들을 생성자가 하나만 있을 때 생략할수 없다
    public AuthControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("[view][Get] 로그인 페이지 - 정상호출")
    @Test
    public void givenNoting_whenTryingToLogIn_thenReturnsLoginView() throws Exception {
        //Given

        //when & then
        mvc.perform(get("/login"))
                .andExpect(status().isOk()) //위 경로 요청하면 200떨어지고
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)); //text/html;charset=UTF-8   //TEXT_HTML타입으로 보여져야한다
    }
}
