package fastcampus.springstudyboard.repository;

import fastcampus.springstudyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}