package fastcampus.springstudyboard.Service;
import fastcampus.springstudyboard.repository.ArticleRepository;
import fastcampus.springstudyboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class CommentService {
    private ArticleRepository articleRepository;
    private CommentRepository commentRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository,CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

}
