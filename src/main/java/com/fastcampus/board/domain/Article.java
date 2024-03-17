package com.fastcampus.board.domain;




//@Getter
//@ToString(callSuper = true) //쉽게 출력이 가능하게 callSuper = trued이거를 하면은 안쪽까지 드렁가서 그 투스트링을 찍어 낸다
//@Table(indexes = { // 빠르게 서치하기 위해 인덱스 사용
//        @Index(columnList = "title"),
//        @Index(columnList = "hashtag"),
//        @Index(columnList = "createdAt"),
//        @Index(columnList = "createdBy")
//}) //사이즈(int,varchar)가 크면 인데스를 걸수가 없다
////@EntityListeners(AuditingEntityListener.class) //@EnableJpaAuditing 때문에 여기서도 이렇게 선어해줘야한다 // 시간정보 등 때문에 사용
//@Entity
//public class Article extends AuditingFields{ //게시글
//    @Id //프라이머리키
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//mysql db autoincrement느 IDENTITY를 걸어줘야한다 // auto인크리먼트를 사용하기 위해 사용
//    private Long id;
//
//    @Setter @ManyToOne(optional = false) private UserAccount userAccount; //객체 매핑이 되어서 안까지 투스트링을 출력하게 되었다
//
//    //클래스에 setter를 걸지않고 각 필드에 거는 이유는 일부러 사용자가 특정필드에 접근한 세팅을 하지 못하게 하기 위해 이렇게 사용
//    //@Column(nullable = false) not null을 표시해주기 위해 사용
//    @Setter @Column(nullable = false) private String title; // 제목 //수정하기 setter를 걸어준다
//    @Setter @Column(nullable = false, length = 10000) private String content; //내용
//
//    @Setter private String hashtag;//해시태그
//
//    //article에 연동되어 있는 comment는 중복을 허용하지 않고 다 여기에서 모아서 collention으로 보겠다
//    //실무에서는 casecade(양방향 바인딩을 풀고 많이 한다 이걸쓰면 강하게 결합되기 때문에 원치 않는 데이터 손실이 일어날수도 있기 때문에)
//    @ToString.Exclude // 이걸 안쓰면 무한 루프가 발생하기 때문에 사용
//    @OrderBy("createdAt DESC") // 정렬기준
//    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) //mappedBy 이걸 사용해서 이름을 지정해줘야 한다 이걸 하지 않으면 기본이름을 따로 쓰는데 그 이름은 두 엔티티의 이름을 합치는거다
//    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();
//
//    //자동으로 생성 4개의 필드를 auditingFields에다가 빼서 사용
////   @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; //생성일시
////   @CreatedBy @Column(nullable = false,length = 100) private String createdBy; // 생성자 Auditing이거 때문에 uno가 자동으로 들어감
////   @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
////   @LastModifiedBy @Column(nullable = false) private String modifiedBy; // 수정자 Auditing이거 때문에 uno가 자동으로 들어감
//
//
//
//
//    //기본생성자
//    //public 으로 열지 않고 직접 코드 바깥에서 new로 생성하지 못하게 하기 위해 protected를 사용
//    protected Article() {}
//
//    private Article(UserAccount userAccount,String title, String content, String hashtag) {
//        this.userAccount = userAccount;
//        this.title = title;
//        this.content = content;
//        this.hashtag = hashtag;
//    }
//
//    //도메인  아티클을 생성하고자 할 때는 어떤값을 필요로 한다는 걸 이것으로 가이드
//    public static Article of(UserAccount userAccount,String title, String content, String hashtag) {
//        return new Article(userAccount,title,content,hashtag); //생성자 사용가능
//    }
//
//    //같은 조건이 무어인가를 화인하기 위해 사용
//
//
//    //@equals and hashcode를 각 필드의 값이 모두 맞는지 검사하기 때문에 사용하지 않는다
//    //이거는 equals and hashcode을 사용하지 않고  skeleton 코드를 만든거다
//    //이거를 만든이유는 위의 각필드가 모두 맞는지 검사할 필요가 없어서 이렇게 따로 만든거다
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Article article)) return false;
//        return id != null&& id.equals(article.id);
//        //id != null&& id.equals(article.id); 이게 뜻하는 바는 지금 막 만든 아직 영속화되지 않은 엔티티는 모두 동등성 검사를 탈락한다(결론적으로는 모두 각각 다 다른 값으로 보겠다라는 것이다)
//        //데이터베이스에 데이터를 연결시키지 않았을 때 아직 인서트하기 전에 만든 엔티티는 id가 null이 아닌가를 체그해 준다
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
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @JoinColumn(name = "userId")
    @ManyToOne(optional = false)
    private UserAccount userAccount; // 유저 정보 (ID)

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    @ToString.Exclude
    @JoinTable(
            name = "article_hashtag",
            joinColumns = @JoinColumn(name = "articleId"),
            inverseJoinColumns = @JoinColumn(name = "hashtagId")
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Hashtag> hashtags = new LinkedHashSet<>();


    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


    protected Article() {}

    private Article(UserAccount userAccount, String title, String content) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
    }

    public static Article of(UserAccount userAccount, String title, String content) {
        return new Article(userAccount, title, content);
    }

    public void addHashtag(Hashtag hashtag) {
        this.getHashtags().add(hashtag);
    }

    public void addHashtags(Collection<Hashtag> hashtags) {
        this.getHashtags().addAll(hashtags);
    }

    public void clearHashtags() {
        this.getHashtags().clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}