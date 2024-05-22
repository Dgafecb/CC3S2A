## Ejercicio 3
## Clase inicial BlogManager
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
BlogManager tampoco cumple con el principio de inversion de dependencias porque depende directamente de la implementacion concreta de la base de datos en el metodo addArticle

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
}
```
Analizando para el 2do principio podriamos tener una interfaz GuardarArticulos que sea implementada por la clase ArticuloBaseDatos para permitirnos realizar cambios en caso que utilizemos otras formas de persistencia en el futuro

```java 
public interface GuardarArticulos {
    void saveArticleToDatabase(String article);
}

```
```java 
public class ArticuloBaseDatos implements GuardarArticulos {
    public static void saveArticleToDatabase(String article) {
    // Simulación de guardar en la base de datos
        System.out.println("Guardando en la base de datos: " + article);
    }
}
```

Con estos cambios la clase BlogManager realiza una tarea mas especifica


## Ejercicio 4