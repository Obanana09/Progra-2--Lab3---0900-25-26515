import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 11-15. Clase Producto con precio encapsulado, validación de precio positivo,
// método para mostrar producto y lista de productos.
public class Ej03_Producto {

    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            setPrecio(precio);
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser positivo.");
            }
            this.precio = precio;
        }

        public void mostrarProducto() {
            System.out.println("Producto: " + nombre + " | Precio: Q" + precio);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        System.out.print("¿Cuántos productos desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("--- Producto " + i + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());
            try {
                productos.add(new Producto(nombre, precio));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n--- Lista de productos ---");
        for (Producto p : productos) {
            p.mostrarProducto();
        }

        sc.close();
    }
}
