/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pamela Rugel Díaz
 */
public class LibroBiblioteca{
    //atributos
  private int cantidad;
  public String codigo;
  public String titulo;
  public String autor;

  //constructor con los dos atributos
  public LibroBiblioteca(String codigo,String titulo,String autor,int cantidad){
    this.codigo = codigo;
    this.titulo = titulo;
    this.autor = autor;
    this.cantidad = cantidad;
  }

  public void setCantidad(int cant){
    cantidad = cantidad+cant;
  }

  //getters
  public int getCantidad(){
    return cantidad;
  }
  
  public String getCodigo(){
    return codigo;
  }

  public String getTitulo(){
    return titulo;
  }

  public String getAutor(){
    return autor;
  }

  public void prestar(){
    cantidad--;
  }

  public String toString(){
    return "Código: "+codigo+", titulo: "+titulo+", autor: "+autor+", cantidad: "+cantidad;
  }
}
