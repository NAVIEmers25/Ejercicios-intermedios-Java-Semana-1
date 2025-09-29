import java.util.Scanner;

/**
@author naviz
 */
public class Ejercicio5_Factorial {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCULADORA DE FACTORIAL ===");
        System.out.print("Ingresa un número entero no negativo: ");
        
        try {
            int numero = scanner.nextInt();
            
            if (numero < 0) {
                System.out.println("Error: El factorial no está definido para números negativos.");
            } else {
                long resultado = calcularFactorial(numero);
                System.out.println("\nResultado:");
                System.out.println(numero + "! = " + resultado);
                mostrarFormula(numero);
            }
            
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número entero válido.");
        }
        
        scanner.close();
    }
    
   //calculamos el factorial utilizando la funcion long
    public static long calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
    
    
    public static void mostrarFormula(int n) {
        System.out.println("\nFórmula aplicada:");
        
        if (n == 0 || n == 1) {
            System.out.println(n + "! = 1 (por definición)");
        } else {
            System.out.print(n + "! = ");
            for (int i = n; i >= 1; i--) {
                System.out.print(i);
                if (i > 1) {
                    System.out.print(" × ");
                }
            }
            System.out.println();
        }
    }
}