package fastcampus.springstudyboard.repository;

import fastcampus.springstudyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}