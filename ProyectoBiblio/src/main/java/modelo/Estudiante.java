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
public class Estudiante {
    
    //atributos
    private String usuario;
    private String contrasena;
    private ArrayList<LibroPrestado> librosPrestados;


    //constructor con los dos atributos
    public Estudiante(String usuario, String contrasena){
      this.usuario = usuario;
      this.contrasena = contrasena;
      librosPrestados = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void prestarLibro(LibroPrestado  lPrestado){
      librosPrestados.add(lPrestado);
    }

    public boolean verificarLibro(String codigo){
      int i=0;
      while(i<librosPrestados.size()){
        if (librosPrestados.get(i).getCodigo().equals(codigo)){
          return false; //false si ya ha prestado el libro 
        }
        i++;
      }

      return true; //true si no ha prestado el libro 
    }

    public void verLibros(){
      for(LibroPrestado l: librosPrestados){
        System.out.println(l);
      }
    }
}
