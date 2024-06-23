package fastcampus.springstudyboard.Controller;

import fastcampus.springstudyboard.Service.ArticleService;
import fastcampus.springstudyboard.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;

    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

   @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
   }

   @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id,@RequestBody Article newArticleData) {
       return articleService.updateArticle(id, newArticleData);

   }

   @DeleteMapping("/{id}")
    public Article deleteArticle(@PathVariable Long id) {
       articleService.deleteArticle(id);
       return null;
   }
}
