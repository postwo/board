package com.fastcampus.board.repository;


import com.fastcampus.board.domain.ArticleComment;
import com.fastcampus.board.domain.QArticleComment;
import com.fastcampus.board.domain.projection.ArticleCommentProjection;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ArticleCommentProjection.class) //yaml 파일에서 detection-strategy: annotated 이것 때문에 어노테이션 사용
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>, //Long 아이디 타입을 뜻한다
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{

    List<ArticleComment> findByArticle_Id(Long articleId);
    void deleteByIdAndUserAccount_UserId(Long articleCommentId, String userId);

    @Override // 검색에 대한 세부적인 규칙을 다시 재구성
    default void customize(QuerydslBindings bindings, QArticleComment root) { //선택적으로 검색할 수있게
        bindings.excludeUnlistedProperties(true); //리스팅을 하지 않은 프로퍼티는 검색에서 제외를 시키는 것을 true로 바꿔준다
        bindings.including( root.content, root.createdAt, root.createdBy);
        //bindings.bind(root.title).first((SimpleExpression::eq));//검색 파라미터는 하나만 받는다 //SimpleExpression::eq SimpleExpression의 eq가 동일한 역할을한다
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase));//IgnoreCase는 대소문자 구분을 안하게 한다는 것이다
        bindings.bind(root.createdAt).first((DateTimeExpression::eq)); //문자열이 아니기 때문에
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));
    }
}






