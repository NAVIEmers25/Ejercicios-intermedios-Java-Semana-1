/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author naviz
 */

import java.util.Scanner;

public class Ejercicio3_NumerosPrimos {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== VERIFICADOR DE NÚMEROS PRIMOS ===");
        System.out.print("Ingresa un número entero: ");
        
        try {
            int numero = scanner.nextInt();
            
            if (numero <= 1) {
                System.out.println("El número " + numero + " NO es primo.");
                System.out.println("Los números primos deben ser mayores que 1.");
            } else if (esPrimo(numero)) {
                System.out.println("El número " + numero + " ES primo.");
                mostrarDivisores(numero);
            } else {
                System.out.println("El número " + numero + " NO es primo.");
                mostrarDivisores(numero);
            }
            
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número entero válido.");
        }
        
        scanner.close();
    }
    
    //Verificamos si el numero es promo 
    public static boolean esPrimo(int numero) {
        // Los números menores o iguales a 1 no son primos
        if (numero <= 1) {
            return false;
        }
        
        // 2 es el único número primo par
        if (numero == 2) {
            return true;
        }
        
        // Los números pares mayores que 2 no son primos
        if (numero % 2 == 0) {
            return false;
        }
        
        // verificar divisores impares desde 3 hasta la raíz cuadrada del número
        // si un número tiene un divisor mayor que su raíz cuadrada,
        // también debe tener uno menor que su raíz cuadrada
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false; // Encontramos un divisor, no es primo
            }
        }
        
        return true; // No encontramos divisores, es primo
    }
    
   //Mostramos los numeros divisores
    public static void mostrarDivisores(int numero) {
        System.out.print("Divisores de " + numero + ": ");
        
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Contar divisores
        int cantidadDivisores = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                cantidadDivisores++;
            }
        }
        
        System.out.println("Cantidad de divisores: " + cantidadDivisores);
        System.out.println("(Un número primo tiene exactamente 2 divisores: 1 y él mismo)");
    }
}