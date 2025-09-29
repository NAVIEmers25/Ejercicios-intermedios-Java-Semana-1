/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author naviz
 */
import java.util.Scanner;

public class Ejercicio4_SerieFibonacci {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== GENERADOR DE SERIE FIBONACCI ===");
        System.out.print("¿Cuántos términos de la serie Fibonacci deseas ver? ");
        
        try {
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Debes ingresar un número positivo.");
            } else {
                System.out.println("\nLos primeros " + n + " términos de la serie Fibonacci son:");
                mostrarFibonacci(n);
                
                // Mostrar información adicional
                if (n > 0) {
                    long ultimoTermino = calcularFibonacci(n);
                    System.out.println("\nEl término #" + n + " de la serie es: " + ultimoTermino);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número entero válido.");
        }
        
        scanner.close();
    }
    
    // muestra los primeros n terminos
    public static void mostrarFibonacci(int n) {
        long anterior = 0;  // F(0) = 0
        long actual = 1;    // F(1) = 1
        
        // Casos especiales
        if (n >= 1) {
            System.out.print("1. " + anterior);
        }
        if (n >= 2) {
            System.out.print("\n2. " + actual);
        }
        
        // Generar el resto de términos
        for (int i = 3; i <= n; i++) {
            long siguiente = anterior + actual;
            System.out.println("\n" + i + ". " + siguiente);
            
            // Actualizar para la siguiente iteración
            anterior = actual;
            actual = siguiente;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Serie completa en una línea:");
        mostrarSerieEnLinea(n);
    }
    
    //muestra la serie en una sola linea, el parametro n es el numero a mostrar
    public static void mostrarSerieEnLinea(int n) {
        if (n <= 0) return;
        
        long anterior = 0;
        long actual = 1;
        
        System.out.print(anterior);
        
        if (n > 1) {
            System.out.print(", " + actual);
        }
        
        for (int i = 3; i <= n; i++) {
            long siguiente = anterior + actual;
            System.out.print(", " + siguiente);
            
            anterior = actual;
            actual = siguiente;
        }
        System.out.println();
    }
    
    //Calculamos el enesimo termino de la serie
    public static long calcularFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        long anterior = 0;
        long actual = 1;
        
        for (int i = 3; i <= n; i++) {
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        
        return actual;
    }
}
