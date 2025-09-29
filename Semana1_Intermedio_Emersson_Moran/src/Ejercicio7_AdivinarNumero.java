/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author naviz
 */
import java.util.Scanner;
import java.util.Random;


public class Ejercicio7_AdivinarNumero {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //este paquete nos ayuda a seleccionar un numero al azar
        Random random = new Random();
        
        System.out.println("=== JUEGO DE ADIVINAR EL NÚMERO ===");
        System.out.println("He pensado en un número entre 1 y 100. ¡Intenta adivinarlo!");
        
        // Generar número aleatorio entre 1 y 100
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 0;
        boolean adivinado = false;
        
        while (!adivinado) {
            System.out.print("Ingresa tu número: ");
            
            try {
                int numeroUsuario = scanner.nextInt();
                intentos++;
                
                if (numeroUsuario == numeroSecreto) {
                    adivinado = true;
                    System.out.println("¡Felicidades! Lo lograste en " + intentos + " intentos");
                } else if (numeroUsuario > numeroSecreto) {
                    System.out.println("Demasiado alto");
                } else {
                    System.out.println("Demasiado bajo");
                }
                
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}