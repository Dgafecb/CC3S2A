package main;

import java.util.List;

public class ArticuloImpresion {

    public static void printAllArticles(List<String> articles) {
        for (String article : articles) {
            System.out.println("Artículo: " + article);
        }
    }
}
