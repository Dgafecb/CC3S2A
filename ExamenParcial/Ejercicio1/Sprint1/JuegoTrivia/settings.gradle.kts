rootProject.name = "JuegoTrivia"
include("src:test:pruebas")
findProject(":src:test:pruebas")?.name = "pruebas"
