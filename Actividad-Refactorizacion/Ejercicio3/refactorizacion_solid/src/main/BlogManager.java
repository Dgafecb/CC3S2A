package main;

import java.util.ArrayList;
import java.util.List;

public class BlogManager {
    private List<String> articles = new ArrayList<>();
    private ArticuloBaseDatos baseDatos;
    public void addArticle(String article) {
        if (article != null && !article.isEmpty()) {
            articles.add(article);
            System.out.println("Artículo añadido: " + article);
            guardarArticulo(article);
        }
    }
    public void guardarArticulo(String article){
        baseDatos = new ArticuloBaseDatos();
        baseDatos.saveArticleToDatabase(article);
    }

}
