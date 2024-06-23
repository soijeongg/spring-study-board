package fastcampus.springstudyboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false,length = 1000)
    private String content;

    @Setter
    @Column(nullable = false,columnDefinition = "integer default 0" )
    private Integer viewCount=0;

    @Setter
    private String hashtag;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private final Set<Comment> Comments = new LinkedHashSet<>();

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(nullable = false)
    private  String modifiedBy;


    protected Article(String title,String content, Integer viewCount, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.viewCount = viewCount != null ? viewCount : 0;

    }

    public Article() {

    }

    public  static Article of(String title, String content, Integer viewCount, String hashtag) {
        return new Article(title,content,viewCount,hashtag);
    }
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;
        this.createdBy = "defaultUser";
        this.modifiedBy = "defaultUser";

        // createdBy와 updatedBy는 현재 인증된 사용자 정보로 설정해야 합니다.
    }
    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = LocalDateTime.now();
        this.modifiedBy = "defaultUser";
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
