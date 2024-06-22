package fastcampus.springstudyboard.repository;

import fastcampus.springstudyboard.config.JpaConfig;
import fastcampus.springstudyboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("jpa 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest{
        private final ArticleRepository articleRepository;

        private final CommentRepository commentRepository;

        public JpaRepositoryTest(
        @Autowired ArticleRepository articleRepository,
        @Autowired CommentRepository commentRepository
        ) {
            this.articleRepository = articleRepository;
            this.commentRepository = commentRepository;
        }

        @Test
        void given_when_then() {

        }


}