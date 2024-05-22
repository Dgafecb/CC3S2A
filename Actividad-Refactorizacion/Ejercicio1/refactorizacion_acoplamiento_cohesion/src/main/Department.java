package main;

import java.util.ArrayList;

public class Department {
   String nombre;
   ArrayList<Empleado> listaEmpleados = new ArrayList<>();
   public void addEmployee(String name, String department) {
// Añade un empleado al departamento
      System.out.println("Empleado añadido");
   }
   public void removeEmployee(String name) {
// Elimina un empleado
      System.out.println("Empleado eliminado");
   }
}
