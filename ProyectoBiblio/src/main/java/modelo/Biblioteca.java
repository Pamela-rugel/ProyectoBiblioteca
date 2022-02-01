/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author Pamela Rugel Díaz
 */
public class Biblioteca {
    
    //atributos
    private ArrayList<LibroBiblioteca> libros;
    private ArrayList<Estudiante> estudiantes;


    //constructor con los atributos
    public Biblioteca(){
      libros= new ArrayList<>();
      estudiantes= new ArrayList<>();
    }

    public void agregarLibro(LibroBiblioteca libro){

      int i=0;
      boolean flag = false; //true si el libro existe

      while(i<libros.size() & !flag){
        if (libros.get(i).getCodigo().equals(libro.getCodigo())){
          libros.get(i).setCantidad(libro.getCantidad());
          flag = true;
        }
        i++;
      }

      //agregar si no existe
      if (!flag){
        libros.add(libro);
      } 

      System.out.print("Agregado con éxito!");
    }

    public void buscarInfoLibro(String codigo){
      int i=0;
      boolean flag = false; //true si el libro existe
      while(i<libros.size() & !flag){
        if (libros.get(i).getCodigo().equals(codigo)){
          System.out.print(libros.get(i));
          flag = true;
        }
        i++;
      }

      //agregar si no existe
      if (!flag){
        System.out.print("No existe libro con ese código");
      } 
    }

    public void disponibles(){
      for(LibroBiblioteca libro:libros){
        System.out.println(libro);
      }
    }

    public Estudiante buscarEstudiante(String usuario, String contra){
      int i=0;    
      while(i<estudiantes.size()){
          Estudiante e= estudiantes.get(i);
          if (e.getUsuario().equals(usuario) && e.getContrasena().equals(contra)){
              return estudiantes.get(i);
            }
          i++;
      }

      return null;
    }

    public void prestarLibros(ArrayList<String> codigos, Estudiante e){
      for(LibroBiblioteca libro:libros){
        if(codigos.contains(libro.getCodigo())){
          libro.prestar();
          LibroPrestado lp = new LibroPrestado(libro.getCodigo(), libro.getTitulo(), libro.getAutor());
          e.prestarLibro(lp);
        }
      }
      System.out.println("Libros prestados con éxito!");
    }
    
    public boolean existeLibro(String codigo){
      int i=0;
      while(i<libros.size()){
        if (libros.get(i).getCodigo().equals(codigo)){
          return true; //true si exite el libro 
        }
        i++;
      }
      return false; //false si no existe el libro 
    }

    //agregar informacion de prueba a la Biblioteca
    public void generarBiblioteca(){
      LibroBiblioteca libro1 = new LibroBiblioteca("001","Crepúsculo","Stephenie Meyer",7);
      LibroBiblioteca libro2 = new LibroBiblioteca("002","El diario de Ana Frank","Anna Frank",8);
      LibroBiblioteca libro3 = new LibroBiblioteca("003","El código Da Vinci","Dan Brown",4);
      libros.add(libro1);libros.add(libro2);libros.add(libro3);

      Estudiante e = new Estudiante("pamela", "1234");
      ArrayList<String> codigos = new ArrayList<>();
      codigos.add("001");codigos.add("002");
      prestarLibros(codigos, e);
      estudiantes.add(e);
    }
    
}
