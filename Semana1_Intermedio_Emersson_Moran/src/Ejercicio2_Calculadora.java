
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author naviz
 */
public class Ejercicio2_Calculadora {

 private static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        System.out.println("=== CALCULADORA AVANZADA ===");
        
        while (continuar) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    Suma();
                    break;
                case 2:
                    Resta();
                    break;
                case 3:
                    Multiplicacion();
                    break;
                case 4:
                    Division();
                    break;
                case 5:
                    Potencia();
                    break;
                case 6:
                    RaizCuadrada();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("¡Gracias por usar la calculadora!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
            
            if (continuar) {
                System.out.println("\n" + "=".repeat(40) + "\n");
            }
        }
        
        entrada.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("Selecciona una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Potencia (x^y)");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Salir");
        System.out.print("\nIngresa tu opción (1-7): ");
    }
    
    private static int obtenerOpcion() {
        try {
            return entrada.nextInt();
        } catch (Exception e) {
            entrada.nextLine();
            return -1; 
        }
    }
    
    private static double obtenerNumero(String mensaje) {
        System.out.print(mensaje);
        try {
            return entrada.nextDouble();
        } catch (Exception e) {
            entrada.nextLine();
            System.out.println("Entrada no válida. Usando 0 como valor por defecto.");
            return 7;
        }
    }
    
    private static void Suma() {
        System.out.println("\n--- SUMA ---");
        double num1 = obtenerNumero("Ingresa el primer número: ");
        double num2 = obtenerNumero("Ingresa el segundo número: ");
        
        double resultado = num1 + num2;
        System.out.printf("Resultado: %.2f + %.2f = %.2f\n", num1, num2, resultado);
    }
    
    private static void Resta() {
        System.out.println("\n--- RESTA ---");
        double num1 = obtenerNumero("Ingresa el primer número: ");
        double num2 = obtenerNumero("Ingresa el segundo número: ");
        
        double resultado = num1 - num2;
        System.out.printf("Resultado: %.2f - %.2f = %.2f\n", num1, num2, resultado);
    }
    
    private static void Multiplicacion() {
        System.out.println("\n--- MULTIPLICACIÓN ---");
        double num1 = obtenerNumero("Ingresa el primer número: ");
        double num2 = obtenerNumero("Ingresa el segundo número: ");
        
        double resultado = num1 * num2;
        System.out.printf("Resultado: %.2f × %.2f = %.2f\n", num1, num2, resultado);
    }
    
    private static void Division() {
        System.out.println("\n--- DIVISIÓN ---");
        double dividendo = obtenerNumero("Ingresa el dividendo: ");
        double divisor = obtenerNumero("Ingresa el divisor: ");
        
        // Validación del divisor
        if (divisor == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return;
        }
        
        double resultado = dividendo / divisor;
        System.out.printf("Resultado: %.2f ÷ %.2f = %.2f\n", dividendo, divisor, resultado);
    }
    
    private static void Potencia() {
        System.out.println("\n--- POTENCIA ---");
        double base = obtenerNumero("Ingresa la base: ");
        double exponente = obtenerNumero("Ingresa el exponente: ");
        
        double resultado = Math.pow(base, exponente);
        System.out.printf("Resultado: %.2f ^ %.2f = %.2f\n", base, exponente, resultado);
    }
    
    private static void RaizCuadrada() {
        System.out.println("\n--- RAÍZ CUADRADA ---");
        double numero = obtenerNumero("Ingresa el número: ");
        
        // Validación para números negativos
        if (numero < 0) {
            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
            return;
        }
        
        double resultado = Math.sqrt(numero);
        System.out.printf("Resultado: √%.2f = %.2f\n", numero, resultado);
    }
    
}
