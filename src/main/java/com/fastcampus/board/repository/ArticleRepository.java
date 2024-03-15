package com.fastcampus.board.repository;


import com.fastcampus.board.domain.Article;
import com.fastcampus.board.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article,Long>,
        QuerydslPredicateExecutor<Article>, // 이거 하나만 넣어도 검색 기능은 끝난다 //QuerydslPredicateExecutor에 의해서 아티클에 있는 모든 필드들에 대한 검색이 열려 있다
        QuerydslBinderCustomizer<QArticle>//Q클래스를 넣어준다
{

    @Override // 검색에 대한 세부적인 규칙을 다시 재구성
    default void customize(QuerydslBindings bindings, QArticle root){ //선택적으로 검색할 수있게
        bindings.excludeUnlistedProperties(true); //리스팅을 하지 않은 프로퍼티는 검색에서 제외를 시키는 것을 true로 바꿔준다
        bindings.including(root.title,root.content,root.hashtag,root.createdAt,root.createdBy);
        //bindings.bind(root.title).first((SimpleExpression::eq));//검색 파라미터는 하나만 받는다 //SimpleExpression::eq SimpleExpression의 eq가 동일한 역할을한다
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase));//IgnoreCase는 대소문자 구분을 안하게 한다는 것이다
        bindings.bind(root.hashtag).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.createdAt).first((DateTimeExpression::eq)); //문자열이 아니기 때문에
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));
    }
}