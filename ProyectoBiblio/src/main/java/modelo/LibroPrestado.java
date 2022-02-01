/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Calendar;
/**
 *
 * @author Pamela Rugel Díaz
 */
public class LibroPrestado {
    
  //atributos
  private String codigo;
  private String titulo;
  private String autor;
  private String fechaEmi;
  private String fechaDev;


  //constructor 
  public LibroPrestado(String codigo,String titulo,String autor){
    this.codigo = codigo;
    this.titulo = titulo;
    this.autor = autor;
    this.fechaEmi= formatoFecha(Calendar.getInstance());
    Calendar dev = Calendar.getInstance();
    dev.add(Calendar.DAY_OF_MONTH, 30);
    this.fechaDev= formatoFecha(dev);
  }
  
   public LibroPrestado(String codigo,String titulo,String autor,String fechaEmi,String fechaDev){
    this.codigo = codigo;
    this.titulo = titulo;
    this.autor = autor;
    this.fechaEmi= fechaEmi;
    this.fechaDev= fechaDev;
  }
  
  public String getCodigo(){
    return codigo;
  }
  
  @Override
  public String toString(){
    return "Titulo:"+titulo+", autor:"+autor+", fecha de emisión: "+fechaEmi+", fecha de devolución: "+fechaDev;
  }

  public String formatoFecha(Calendar f){
    String fecha = f.get(Calendar.YEAR)+"/"+(f.get(Calendar.MONTH)+1)+"/"+f.get(Calendar.DAY_OF_MONTH);
    return fecha;
  }
}
