/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author naviz
 */

import java.util.Scanner;
public class Ejercicio6_Calificaciones {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ESTADÍSTICAS DE CALIFICACIONES ===");
        
        try {
            System.out.print("¿Cuántos estudiantes hay en la clase? ");
            int numEstudiantes = scanner.nextInt();
            
            if (numEstudiantes <= 0) {
                System.out.println("Error: Debe haber al menos un estudiante.");
                return;
            }
            
            // crear arreglo para almacenar las calificaciones
            double[] calificaciones = new double[numEstudiantes];
            
            // leer las calificaciones
            leerCalificaciones(scanner, calificaciones);
            
            // Calcular y mostrar estadísticas
            calcularEstadisticas(calificaciones);
            
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Reinicia el programa.");
        }
        
        scanner.close();
    }
    
    //solicitamos las calificacione y las guardamos en un arreglo
    public static void leerCalificaciones(Scanner scanner, double[] calificaciones) {
        System.out.println("\nIngresa las calificaciones de los estudiantes:");
        
        for (int i = 0; i < calificaciones.length; i++) {
            boolean calificacionValida = false;
            
            while (!calificacionValida) {
                try {
                    System.out.print("Estudiante " + (i + 1) + ": ");
                    calificaciones[i] = scanner.nextDouble();
                    calificacionValida = true;
                } catch (Exception e) {
                    System.out.println("Error: Ingresa un número válido.");
                    scanner.nextLine(); // Limpiar buffer
                }
            }
        }
    }
    
    
    public static void calcularEstadisticas(double[] calificaciones) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("?ESTADÍSTICAS DE LA CLASE");
        System.out.println("=".repeat(40));
        
        double promedio = calcularPromedio(calificaciones);
        double notaMaxima = encontrarMaxima(calificaciones);
        double notaMinima = encontrarMinima(calificaciones);
        
        System.out.printf("Número de estudiantes: %d\n", calificaciones.length);
        System.out.printf("Promedio general: %.2f\n", promedio);
        System.out.printf("Nota más alta: %.2f\n", notaMaxima);
        System.out.printf("Nota más baja: %.2f\n", notaMinima);
        
        // Mostrar todas las calificaciones
        System.out.println("\nTodas las calificaciones:");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.printf("Estudiante %d: %.2f\n", (i + 1), calificaciones[i]);
        }
    }
    
    //calcular el promedio de las calidicaciones
    public static double calcularPromedio(double[] calificaciones) {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }
    
   //encontramos la calificacion mas alta
    public static double encontrarMaxima(double[] calificaciones) {
        double maxima = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion > maxima) {
                maxima = calificacion;
            }
        }
        return maxima;
    }
    
    //encontramos la calificacion mas baja
    public static double encontrarMinima(double[] calificaciones) {
        double minima = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion < minima) {
                minima = calificacion;
            }
        }
        return minima;
    }
}
