/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author naviz
 */
public class Ejercicio8_Inventario {
    private static ArrayList<Producto> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        System.out.println(" === SISTEMA DE INVENTARIO === ");
        System.out.println("¡Bienvenido al gestor de inventario!");
        
        while (continuar) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    calcularValorTotal();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema de inventario! ");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
            
            if (continuar) {
                System.out.println("\n" + "=".repeat(50) + "\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal del sistema
     */
    private static void mostrarMenu() {
        System.out.println("MENÚ:");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos registrados");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Salir");
        System.out.print("\nSelecciona una opción (1-4): ");
    }
    
   
    private static int obtenerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); 
            return -1; // Opción inválida
        }
    }
    
    //regustrar un nuevo producto
    private static void registrarProducto() {
        scanner.nextLine(); 
        
        System.out.println("\n === REGISTRAR NUEVO PRODUCTO ===");
        
        try {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();
            
            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                return;
            }
            
            System.out.print("Precio unitario: $");
            double precio = scanner.nextDouble();
            
            if (precio < 0) {
                System.out.println("Advertencia: Precio negativo ingresado.");
            }
            
            System.out.print("Cantidad en stock: ");
            int cantidad = scanner.nextInt();
            
            if (cantidad < 0) {
                System.out.println("Advertencia: Cantidad negativa ingresada.");
            }
            
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            inventario.add(nuevoProducto);
            
            System.out.println("¡Producto registrado exitosamente!");
            System.out.println("Información del producto:");
            System.out.println("  Nombre: " + nombre);
            System.out.printf("   Precio: $%.2f\n", precio);
            System.out.println("  Cantidad: " + cantidad);
            System.out.printf("   Valor total: $%.2f\n", precio * cantidad);
            
        } catch (Exception e) {
            System.out.println("Error: Datos inválidos. Producto no registrado.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    //muestra los productos
    private static void mostrarProductos() {
        System.out.println("\n === PRODUCTOS REGISTRADOS ===");
        
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            System.out.println("Usa la opción 1 para registrar productos.");
            return;
        }
        
        System.out.println("Total de productos: " + inventario.size());
        System.out.println("\n" + "=".repeat(55));
        System.out.printf("%-15s | %-8s | %-5s | %-10s\n", 
                         "PRODUCTO", "PRECIO", "CANT.", "VALOR TOTAL");
        System.out.println("=".repeat(55));
        
        for (int i = 0; i < inventario.size(); i++) {
            System.out.printf("%2d. %s\n", (i + 1), inventario.get(i).toString());
        }
        
        System.out.println("=".repeat(55));
    }
    
    //calcula y muestra el valor total del inventario
    private static void calcularValorTotal() {
        System.out.println("\n === VALOR TOTAL DEL INVENTARIO ===");
        
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío. Valor total: $0.00");
            return;
        }
        
        double valorTotal = 0;
        int cantidadTotal = 0;
        
        System.out.println("Desglose por productos:");
        System.out.println("-".repeat(40));
        
        for (Producto producto : inventario) {
            double valorProducto = producto.calcularValorTotal();
            valorTotal += valorProducto;
            cantidadTotal += producto.getCantidad();
            
            System.out.printf("%-15s: $%8.2f (%d unidades)\n", 
                            producto.getNombre(), valorProducto, producto.getCantidad());
        }
        
        System.out.println("-".repeat(40));
        System.out.printf("RESUMEN:\n");
        System.out.printf("   Productos diferentes: %d\n", inventario.size());
        System.out.printf("   Total de unidades: %d\n", cantidadTotal);
        System.out.printf("   VALOR TOTAL: $%.2f\n", valorTotal);
    }
}