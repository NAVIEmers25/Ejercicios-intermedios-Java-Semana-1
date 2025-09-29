/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author naviz
 */
//Esta clase nos ayuda a simular parte del proyecto de un mini inventario
//para un producto xd, ya siguiendo buenas practicas seria una clase aparte para poder
//reutilizarla xd

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    
   //creamos un constructor para poder crear un nuevo producto
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    // Métodos getter
    public String getNombre() { 
        return nombre; 
    }
    
    public double getPrecio() { 
        return precio; 
    }
    
    public int getCantidad() { 
        return cantidad; 
    }
    
    // Métodos setter
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }
    
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
    }
    
    //funcion para calcular el total
    public double calcularValorTotal() {
        return precio * cantidad;
    }
    
   
    @Override
    public String toString() {
        return String.format("%-15s | $%8.2f | %5d | $%10.2f", 
    nombre, precio, cantidad, calcularValorTotal());
    }
    
}
