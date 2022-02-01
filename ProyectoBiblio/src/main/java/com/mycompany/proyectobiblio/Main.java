/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectobiblio;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;

/**
 *
 * @author Pamela Rugel Díaz
 */
public class Main {
    public static Biblioteca biblioteca;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


      biblioteca = new Biblioteca();
      biblioteca.generarBiblioteca();


      boolean salir = false; // para que el bucle se inicie
      while (!salir) {
        System.out.println();System.out.println();
        System.out.println("-----INICIO DE SESIÓN-----");
        System.out.println("1. Administrador");
        System.out.println("2. Estudiante");
        System.out.println("3. Salir");

        System.out.println("Escribe una de las opciones: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
        case 1:
          menuAdministrador();
          break;
        case 2:
          menuEstudiante();
          break;
        case 3:
          salir = true;
          System.out.println();
          break;
        default:
            System.out.println();
            System.out.print("Solo números entre 1 y 3");
            System.out.println();
        }
      }
    }




    public static void menuAdministrador(){
      System.out.println();System.out.println();
      System.out.println("-----ADMINISTRADOR-----");
      System.out.println("Usuario: ");
      String usuarioAdmin = sc.nextLine();
      System.out.println("Contraseña: ");
      String contraAdmin  = sc.nextLine();

      boolean salir1 = false;
      while(!salir1){
        System.out.println();System.out.println();
        System.out.println("1. Agregar libro");
        System.out.println("2. Bucar información de un libro");
        System.out.println("3. Cerrar Sesión");

        System.out.println("Escribe una de las opciones: ");
        int opcion1 = sc.nextInt();
        sc.nextLine();

        switch(opcion1){
          case 1:
            System.out.println();

            //Puede agregar libro al sistema
            menuAdmin1();
            break;
          case 2:
            //Buscar info del libro por el código
            System.out.println();
            menuAdmin2();
            break;
          case 3:
            salir1 = true;
            break;
          default:
              System.out.println();
              System.out.print("Solo números entre 1 y 3");
        }
      }
    }


    public static void menuAdmin1(){
      System.out.println("-----INFORMACIÓN DEL LIBRO-----");
      System.out.println("Código: ");
      String codigo = sc.nextLine();
      System.out.println("Titulo: ");
      String titulo = sc.nextLine();
      System.out.println("Autor: ");
      String autor = sc.nextLine();
      System.out.println("Cantidad disponible: ");
      int cantidad = sc.nextInt();
      sc.nextLine();

      LibroBiblioteca libro = new LibroBiblioteca(codigo, titulo, autor, cantidad);
      biblioteca.agregarLibro(libro);
    }



    public static void menuAdmin2(){
      System.out.println("Ingrese el código: ");
      String cod = sc.nextLine();

      biblioteca.buscarInfoLibro(cod);
    }

    public static void menuEstudiante(){
      System.out.println();System.out.println();
      System.out.println("-----ESTUDIANTE----");
      System.out.println("Usuario: ");
      String usuario = sc.nextLine();
      System.out.println("Contraseña: ");
      String contra  = sc.nextLine();

      Estudiante  e = biblioteca.buscarEstudiante(usuario, contra);

      boolean salir2 = false;

      if(e==null){ //si no existe el estudiante 
        System.out.println("Usuario no existente o contraseña incorrecta");
        salir2=true;
        System.out.println();
      }


      while(!salir2){
        System.out.println();System.out.println();
        System.out.println("1. Prestar libros");
        System.out.println("2. Ver mis libros prestados");
        System.out.println("3. Cerrar Sesión");  

        System.out.println("Escribe una de las opciones: ");
        int opcion2 = sc.nextInt();
        sc.nextLine();

        switch(opcion2){
          case 1:
           //prestar libros
            menu1Est(e);
            break;
          case 2:
            //ver los libros prestados
            System.out.println();
            System.out.println("-----LIBROS PRESTADOS----");
            e.verLibros();
            break;
          case 3:
            salir2 = true;
            System.out.println();
            break;
          default:
              System.out.println();
              System.out.println("Solo números entre 1 y 3");
              System.out.println();
        }
      }
    }


    public static void menu1Est(Estudiante e){
      System.out.println();
      System.out.println("-----LIBROS DISPONIBLES----");
      biblioteca.disponibles();
      System.out.println();
      System.out.println("Confirmar préstamo: C");
      System.out.println("Cancelar préstamo: X");

      ArrayList<String> codigos = new ArrayList<>();

      boolean salir3 = false;
      while(!salir3){
        System.out.println("Código: ");
        String codi = sc.nextLine(); 
        if(codi.equals("C") | codi.equals("c")  ){
          salir3=true;
          biblioteca.prestarLibros(codigos, e);
        }else if (codi.equals("X") | codi.equals("x")){
          salir3=true;
          System.out.println("Préstamo Cancelado");
        }else if (codigos.contains(codi)){
          System.out.println("No puede prestar libro con el mismo código");
        }else{
          if(biblioteca.existeLibro(codi)){ //verificar si existe en la biblioteca
              if(e.verificarLibro(codi)){ //no ha prestado el libro
                  codigos.add(codi);
              }else{
                  System.out.println("Libro prestado con anterioridad");
              }
          }else{
              System.out.println("Libro no disponible en la biblioteca");
          }
          
        }  

      }
    }

}
