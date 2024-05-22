package main;

import java.util.ArrayList;
import java.util.List;

public class BlogManager {
    private List<String> articles = new ArrayList<>();
    public void addArticle(String article) {
        if (article != null && !article.isEmpty()) {
            articles.add(article);
            System.out.println("Artículo añadido: " + article);
            ArticuloPersistencia.saveArticleToDatabase(article);
        }
    }
    public void printAllArticles() {
        ArticuloImpresion.printAllArticles(articles);
    }
}
public class BlogManager {
    private List<String> articles = new ArrayList<>();
    private ArticleRepository articleRepository;

    public BlogManager(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    private boolean isValidArticle(String article) {
        return article != null && !article.isEmpty();
    }

}