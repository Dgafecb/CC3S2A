# Clase inicial BlogManager
```java 
public class BlogManager {
private List<String> articles = new ArrayList<>();
public void addArticle(String article) {
    if (article != null && !article.isEmpty()) {
    articles.add(article);
    System.out.println("Artículo añadido: " + article);
    saveArticleToDatabase(article);
    }
}
private void saveArticleToDatabase(String article) {
    // Simulación de guardar en la base de datos
    System.out.println("Guardando en la base de datos: " + article);
    }
    public void printAllArticles() {
    for (String article : articles) {
    System.out.println("Artículo: " + article);
    }
}
}
```
El primer cambio que realizaremos es crear 2 clases ArticuloPersistencia y ArticuloImpresion
debido a que la clase BlogManager no cumple con el principio SOLID de responsabilidad unica.

```java 
public class ArticuloPersistencia {
    public static void saveArticleToDatabase(String article) {
    // Simulación de guardar en la base de datos
        System.out.println("Guardando en la base de datos: " + article);
    }


public class ArticuloImpresion {

    public static void printAllArticles(List<String> articles) {
        for (String article : articles) {
            System.out.println("Artículo: " + article);
        }
    }
}
}```