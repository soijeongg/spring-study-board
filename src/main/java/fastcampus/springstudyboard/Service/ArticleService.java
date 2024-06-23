package fastcampus.springstudyboard.Service;

import fastcampus.springstudyboard.domain.Article;
import fastcampus.springstudyboard.repository.ArticleRepository;
import fastcampus.springstudyboard.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    //게시글 저장 메서드
    @Transactional
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    //전체 게시글 조회
    @Transactional
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    @Transactional
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    //업데이트
    @Transactional
    public Article updateArticle(Long id, Article newArticleData) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article ID"));

        article.setTitle(newArticleData.getTitle());
        article.setContent(newArticleData.getContent());
        article.setViewCount(newArticleData.getViewCount());
        article.setHashtag(newArticleData.getHashtag());

        return articleRepository.save(article);
    }
    @Transactional
    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid article ID");
        }
        articleRepository.deleteById(id);
    }
}

