package com.fastcampus.board.repository;


import com.fastcampus.board.config.JpaConfig;
import com.fastcampus.board.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@ActiveProfiles("testdb") //h2db 를 사용
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class) //이걸 안해주면 @EnableJpaAuditing이 자동으로 동작을 안한다
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;

    private final ArticleCommentRepository articleCommentRepository;


    //생성자 주입 패턴 @Autowired를 써준다
    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,@Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //Given

        //when
        List<Article> articles= articleRepository.findAll();

        //then
        assertThat(articles)
                .isNotNull()
                .hasSize(0);
    }


    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //Given
        long previousCount = articleRepository.count();


        //when
        Article savedArticle = articleRepository.save(Article.of("new article","new content","#spring"));


        //then
        assertThat(articleRepository.count())
                .isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);

        //when
        Article savedArticle = articleRepository.saveAndFlush(article);


        //then
        assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag",updatedHashtag);
    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count(); // 게시글을 지우면 댓글도 사라지게 할려고 Casecading을 사용(연관관계)
        long previousArticleComment = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();



        //when
        articleRepository.delete(article);


        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount -1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleComment - deletedCommentsSize); // 댓글이 많을 수돌있기 때문에 -1이 아니다

    }


}