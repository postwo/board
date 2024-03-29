package com.fastcampus.board.domain;


//import lombok.*;
//
//import javax.persistence.*;
//import java.util.LinkedHashSet;
//import java.util.Objects;
//import java.util.Set;
//
//@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
//@Getter
//@ToString(callSuper = true)
//@Table(indexes = { // 빠르게 서치하기 위해 인덱스 사용
//        @Index(columnList = "content"),
//        @Index(columnList = "createdAt"),
//        @Index(columnList = "createdBy")
//}) //사이즈(int,varchar)가 크면 인데스를 걸수가 없다
////@EntityListeners(AuditingEntityListener.class)
//@Entity
//public class ArticleComment extends AuditingFields { //댓글
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//mysql db autoincrement느 IDENTITY를 걸어줘야한다 // auto인크리먼트를 사용하기 위해 사용
//    private Long id;
//
//
//    @Setter @ManyToOne(optional = false) private Article article; //@ManyToOne = 댓글에서 게시글 // 게시글 아이디 //그냥 관계형 데이터베이스 스타일로 한다고 하면 Article이 아니라 Long이 된다
//    @Setter @ManyToOne(optional = false) private UserAccount userAccount;
//    @Setter  @Column(nullable = false, length = 500)  private String content; //내용
//
//    //자동으로 생성
////    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; //생성일시
////    @CreatedBy @Column(nullable = false,length = 100) private String createdBy; // 생성자 Auditing이거 때문에 uno가 자동으로 들어감
////    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
////    @LastModifiedBy @Column(nullable = false , length = 100) private String modifiedBy; // 수정자 Auditing이거 때문에 uno가 자동으로 들어감
//
//    //기본 생성자
//    // protected ArticleComment(){} // 이렇게 안만들고 롬복으로  @NoArgsConstructor(access = AccessLevel.PROTECTED) 이걸 사용해서 처리할수도 있다
//
//
//    //세팅하고 싶은 내용만 넣은 생성자
//    private ArticleComment(Article article,UserAccount userAccount ,String content) {
//        this.userAccount = userAccount;
//        this.article = article;
//        this.content = content;
//    }
//
//
//    //팩토리 메소드
//    public static ArticleComment of(Article article,UserAccount userAccount ,String content) {  //of 붙이기
//        return new ArticleComment(article,userAccount,content);
//    }
//
//
//    // equals and hashcode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ArticleComment that)) return false;
//        return id != null && id.equals(that.id); //유니크 키인 아이디 사용
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ArticleComment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article; // 게시글 (ID)

    @Setter
    @JoinColumn(name = "userId")
    @ManyToOne(optional = false)
    private UserAccount userAccount; // 유저 정보 (ID)

    @Setter
    @Column(updatable = false)
    private Long parentCommentId; // 부모 댓글 ID

    @ToString.Exclude
    @OrderBy("createdAt ASC")
    @OneToMany(mappedBy = "parentCommentId", cascade = CascadeType.ALL)
    private Set<ArticleComment> childComments = new LinkedHashSet<>();

    @Setter @Column(nullable = false, length = 500) private String content; // 본문


    protected ArticleComment() {}

    private ArticleComment(Article article, UserAccount userAccount, Long parentCommentId, String content) {
        this.article = article;
        this.userAccount = userAccount;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }

    public static ArticleComment of(Article article, UserAccount userAccount, String content) {
        return new ArticleComment(article, userAccount, null, content);
    }

    public void addChildComment(ArticleComment child) {
        child.setParentCommentId(this.getId());
        this.getChildComments().add(child);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}