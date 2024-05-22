package main;
public class ArticuloBaseDatos implements GuardarArticulos {
    @Override
    public void saveArticleToDatabase(String article) {
    // Simulación de guardar en la base de datos
        System.out.println("Guardando en la base de datos: " + article);
    }
}
